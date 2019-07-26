package com.lti.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/AccountServlet" })
public class AuditFilter implements Filter {

  
    public AuditFilter() {
       
    }


	public void destroy() {
		System.out.println("Audit filter is destroyed");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("-----------------------");
		System.out.println("audit filter====> doFilter");
		HttpServletRequest req=(HttpServletRequest) request;
		String url=req.getRequestURL().toString();   //finding requested url
		System.out.println("URL Intercepted====> "+url);	
		//start time
		long start =System.currentTimeMillis();
		//pass the request along the filter action
		chain.doFilter(request, response);
		//end time
		long end =System.currentTimeMillis();
		System.out.println("======>URL "+url+"took time"+(end-start)+"ms" );
		System.out.println("----------------------");
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
			System.out.println("Audit filter is initialized");
	}

}
