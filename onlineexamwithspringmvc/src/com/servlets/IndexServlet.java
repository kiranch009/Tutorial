package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Constants;
import com.utils.Messages;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();

	    out.println("<Html>");
	    out.println("<head>");
	    out.println("</head>");
	    out.println("<body>");
        if (request.getAttribute(Constants.LOGIN_FAILED_KEY) != null)
        {
            out.println("<h4>" + Messages.getMessage("login.failed") + "</h4>");
        }
        out.println("<form method=\"post\" action=\"login\">");
	    out.println("<table>");
	    out.println("<tr>");
	    out.println("<td>");
	    out.println("Login Id:");
	    out.println("</td>");
	    out.println("<td>");
        out.println("<input type=\"text\" id=\"userName\" name=\"userName\"/>");
	    out.println("</td>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<td>");
	    out.println("Password:");
	    out.println("</td>");
	    out.println("<td>");
        out.println("<input type=\"password\" id=\"password\" name=\"password\"/>");
	    out.println("</td>");
	    out.println("</tr>");
	    out.println("<tr>");
	    out.println("<td>");
        out.println("<input type=\"submit\" id=\"submit\" value=\"Login\"/>");
	    out.println("</td>");
	    out.println("<td>");
        out.println("<a href=\"/register\">Register here</a>");
	    out.println("</td>");
	    out.println("</tr>");
	    out.println("</table>");
	    out.println("</form>");
	    out.println("</body>");
	    out.println("</Html>");
	}

}
