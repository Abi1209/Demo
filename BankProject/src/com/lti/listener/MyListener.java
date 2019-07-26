package com.lti.listener;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.lti.bean.Account;
import com.lti.service.AccountService;
import com.lti.service.AccountServiceImpl;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	 System.out.println("CONTEXT DESTROYED");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("CONTEXT INITIALIZED");
        AccountService service = new  AccountServiceImpl();
        List<Account>alist = service.getAllAccounts();
        
        //set the above list in the ServletContext
        
        ServletContext application = arg0.getServletContext();
        application.setAttribute("acclist", alist);
    }
	
}
