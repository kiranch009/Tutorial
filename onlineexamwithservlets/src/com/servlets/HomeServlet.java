package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.utils.Constants;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute(Constants.USER_KEY);
		
        PrintWriter out = response.getWriter();
        out.println("<Html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.print("Welcome "+user.getUserName());
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>");
        out.println("<a href=\"exam\">Take Exam</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("<a href=\"/editUser\">Update User Information</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</Html>");

	}

}
