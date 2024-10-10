<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="IndexStyle.css">
</head>
<body>
<% 
	HttpSession session1 = request.getSession(false);
	
	if(session1 != null && session1.getAttribute("username") != null){
		String username = (String) session1.getAttribute("username");
	
%>
	<div class="container">
		<h1>Welcome, <%= username %>!</h1>
		<h3>This project is passionately created by Roshan Dhote to
			demonstrate my full stack understanding</h3>
		<p>MCA candidate at TGPCET, Nagpur University, with a BCA degree
			from Amravati University. Proficient in C, Java, Python, SQL and
			MySQL database. Actively pursuing expertise in Servlet, JSP,
			Spring-MVC. Eager to apply and expand technical skills in a dynamic
			and challenging environment, with a passion for continuous learning
			and adopting new technologies.</p>
   
		you can <a href="LogoutServlet">Logout</a> securely

	</div>
	<% }
	else{
		response.sendRedirect("login.jsp");
	}
	%>

</body>
</html>
