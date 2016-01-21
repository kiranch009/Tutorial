package com.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Messages;
public class ResourcesLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config)
    {
        InputStream inputStream = config.getServletContext().getResourceAsStream("/WEB-INF/messages.properties");
        try
        {
            Messages.load(inputStream);
        } catch (IOException e)
        {
            throw new RuntimeException("Error in resourceloader");
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
