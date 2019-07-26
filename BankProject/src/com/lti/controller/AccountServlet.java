package com.lti.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.bean.Account;
import com.lti.service.AccountService;
import com.lti.service.AccountServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(urlPatterns = {"/AccountServlet"}, 
initParams = {
		@WebInitParam(name= "minBalance",value = "1000.00"),
		@WebInitParam(name= "ifsc",value = "ABC565650")
}
)

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			String s_aid = request.getParameter("aid");
			int myaid = Integer.parseInt(s_aid);
			String s_aname = request.getParameter("aname");
			
			String s_dob = request.getParameter("dob");
			DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dob = LocalDate.parse(s_dob,df);
			
			String s_bal = request.getParameter("balance");
			double bal = Double.parseDouble(s_bal);
			
			String s_minbal = getInitParameter("min balance");
			double minbal = Double.parseDouble(s_minbal);
			if(bal<minbal)
			{
				throw new Exception("Minimum balance should be" +minbal);
			}
			
			String sif = getInitParameter("ifsc");
			System.out.println("IFSC code" +sif);
			
			Account ob = new Account(myaid, s_aname,dob,bal);
			AccountService service = new AccountServiceImpl();
			service.createNewAccount(ob);
			System.out.println("Account inserted");
			
			
			//adding new account to list
			ServletContext application = getServletContext();
			List<Account> mylist = (List<Account>) application.getAttribute("acclist");
			mylist.add(ob);
			application.setAttribute("acclist", mylist);
			
			
			request.setAttribute("myacc", ob);
			RequestDispatcher red =  request.getRequestDispatcher("Success.jsp");
				red.forward(request, response);
		}
		catch(Exception e)
		{
			String error = e.getMessage();
			request.setAttribute("err",error);
			RequestDispatcher red = request.getRequestDispatcher("InsertAccount.jsp");
			red.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
