package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.ExamAnswerChoice;
import com.beans.ExamQuestion;
import com.beans.Technology;
import com.dao.ExamDao;
import com.utils.JDBCUtils;

public class ExamDAOImpl implements ExamDao {
	
    @Autowired
	private DataSource dataSource;

	public static final String SQL_TECHNOLOGIES_LIST = "SELECT * FROM technology";

	public static final String SQL_SELECT_QUESTION = "select * from exam_question q, exam_answer_choice c where q.question_id=c.question_id and q.technlogy_id=?";

	@Override
	public List<Technology> getAvailableTechnologies() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_TECHNOLOGIES_LIST);
			List<Technology> list = new ArrayList<Technology>();
			while (rs.next()) {
				Technology technology = new Technology();
				technology.setTechnologyId(rs.getInt("technology_id"));
				technology.setTechnologyName(rs.getString("technology_name"));
				list.add(technology);
			}
			return list;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(stmt);
			JDBCUtils.closeConnection(conn);
		}
	}

	@Override
	public List<ExamQuestion> getQuestions(Integer technologyId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, ExamQuestion> map = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_QUESTION);
			pstmt.setInt(1, technologyId);
			rs = pstmt.executeQuery();

			map = new HashMap<Integer, ExamQuestion>();
			ExamQuestion bean = null;
			Integer questionId = null;
			ExamAnswerChoice choice = null;
			List<ExamAnswerChoice> examAnswerChoices=null;
			while (rs.next()) {
				questionId = rs.getInt(rs.getInt("question_id"));
				bean = map.get(questionId);
				if (bean == null) {
					bean = new ExamQuestion();
					bean.setQuestionId(questionId);
					bean.setQuestion(rs.getString("question"));
					examAnswerChoices=new ArrayList<ExamAnswerChoice>();
					choice = new ExamAnswerChoice();
					choice.setChoiceId(rs.getInt("choice_id"));
					choice.setAnswerChoice(rs.getString("answer_choice"));
					examAnswerChoices.add(choice);
					bean.setExamAnswerChoices(examAnswerChoices);
					map.put(questionId, bean);
				} else {
					choice = new ExamAnswerChoice();
					choice.setChoiceId(rs.getInt("choice_id"));
					choice.setAnswerChoice(rs.getString("answer_choice"));
					bean.getExamAnswerChoices().add(choice);
				}
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(pstmt);
			JDBCUtils.closeConnection(conn);
		}

		return new ArrayList<ExamQuestion>(map.values());
	}

}
