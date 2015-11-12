package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beans.QuestionBean;
import com.dao.ExamDAO;

public class ExamDAOImpl implements ExamDAO
{

    public static final String SQL_TECHNOLOGIES_LIST = "SELECT * FROM technologies";

    public static final String SQL_SELECT_QUESTION =
            "select * from exam_questions q, exam_answer_choice c where q.question_id=c.question_id and q.technlogy_id=?";

    @Override
    public Map<Integer, String> getAvailableTechnologies()
    {

        Connection conn = null;
        Statement stmt = null;
        Map<Integer, String> map = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "root");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_TECHNOLOGIES_LIST);
            map = new HashMap<Integer, String>();
            while (rs.next())
            {
                map.put(rs.getInt("technology_id"), rs.getString("technology_name"));
            }

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return map;

    }

    @Override
    public List<QuestionBean> getQuestions(Integer technologyId)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Map<Integer, QuestionBean> map = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "root");
            pstmt = conn.prepareStatement(SQL_SELECT_QUESTION);
            pstmt.setInt(1, technologyId);
            ResultSet rs = pstmt.executeQuery();
            map = new HashMap<Integer, QuestionBean>();
            QuestionBean bean = null;
            Integer questionId = null;
            Map<Integer, String> choiceMap = null;
            while (rs.next())
            {
                questionId = rs.getInt(rs.getInt("question_id"));
                bean = map.get(questionId);
                if (bean == null)
                {
                    bean = new QuestionBean();
                    bean.setQuestionId(questionId);
                    bean.setQuestion(rs.getString("question"));
                    choiceMap = new HashMap<Integer, String>();
                    choiceMap.put(rs.getInt("choice_id"), rs.getString("answer_choice"));
                    bean.setAnswerChoices(choiceMap);
                    map.put(questionId, bean);
                } else
                {
                    bean.getAnswerChoices().put(rs.getInt("choice_id"), rs.getString("answer_choice"));
                }
            }

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return new ArrayList<QuestionBean>(map.values());
    }

}
