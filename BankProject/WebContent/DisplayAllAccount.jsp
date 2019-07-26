<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import = "java.util.List, com.lti.bean.Account" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of all accounts</h2>
<font color="yellow" size = "6">
</font>
<%
List<Account> mylist = (List<Account>) application.getAttribute("acclist");
for(Account o:mylist)
{
	out.println("Aid is " +o.getAid() + "<br>");
	out.println("Aname is " +o.getAname() + "<br>");
	out.println("DOB is " +o.getDob() + "<br>");
	out.println("Bal is " +o.getBalance() + "<br>");
	out.println("<hr>");
}
%>
<hr>
<a href = "index.html"> Home </a>
</body>
</html>