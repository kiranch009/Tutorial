package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.QuestionBean;
import com.services.ExamService;
import com.services.impl.ExamServiceImpl;

public class StartExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StartExamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamService service = new ExamServiceImpl();
        List<QuestionBean> list = service.getQuestions(Integer.parseInt(request.getParameter("technology")));
        request.setAttribute("QUESTION_LIST", list);
        request.getRequestDispatcher("/jsp/startexam_view.jsp").forward(request, response);
	}

}
