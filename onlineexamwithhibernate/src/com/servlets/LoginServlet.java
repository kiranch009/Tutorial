package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.services.LoginService;
import com.services.impl.LoginServiceImpl;
import com.utils.Constants;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();

        User user = loginService.getUser(request.getParameter("userName"), request.getParameter("password"));
        if (user == null)
        {
            request.setAttribute(Constants.LOGIN_FAILED_KEY, "login failed");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else
        {
            response.sendRedirect(response.encodeRedirectURL("home"));
        }
	}

}
