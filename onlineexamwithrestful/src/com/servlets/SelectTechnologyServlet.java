package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.services.ExamService;
import com.services.impl.ExamServiceImpl;
import com.utils.Constants;

public class SelectTechnologyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectTechnologyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamService service = new ExamServiceImpl();
        request.setAttribute(Constants.TECHNOLOGIES_LIST_KEY, service.getAvailableTechnologies());
        request.getRequestDispatcher("/jsp/selecttechnology_view.jsp").forward(request, response);
	}

}
