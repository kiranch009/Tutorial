package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet{
	
	
	public SampleServlet()
	{
		System.out.println();
	}
	
	public void init(ServletConfig config)
	{
		config.getInitParameter("");
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//
		request.getAttribute("userName");
		
		PrintWriter out=response.getWriter();
		out.write("<html><h1>Hello</h1></html>");
	}
	
	  public void 	destroy(){
		  System.out.println("");
	  }
	

}
