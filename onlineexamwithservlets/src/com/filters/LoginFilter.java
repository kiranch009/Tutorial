package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utils.Constants;

public class LoginFilter implements Filter {

   
    public LoginFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session=((HttpServletRequest)request).getSession();
		if(session.getAttribute(Constants.USER_KEY)==null)
		{
			HttpServletResponse httpServletResponse=(HttpServletResponse)response;
			httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL("index"));
		}
		else{
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
