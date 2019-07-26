<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Acccount Form</h1>
<form method = "post" action = "AccountServlet">
Enter AID:
<input type = "text" name = "aid"><br>
Enter NAME:
<input type = "text" name = "aname"><br>
Enter DOB:
<input type = "text" name = "dob" placeholder = "dd-MM-yyyy"> <br>
Enter BALANCE:
<input type = "text" name = "balance" > <br>
<input type = "submit" value = "InsertAccount">
</form>
<hr>
<font color = "orange" size ="6">
</font>
<%String err = (String)request.getAttribute("err"); %>
<%if(err!=null)
{
	out.println(err);
}
%>
</body>
</html>