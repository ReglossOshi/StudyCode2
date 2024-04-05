<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		%>	
		<p>로그인</p>
		<p>아이디 <%=id %></p>
		<p>비밀번호 <%=password %></p>
</body>
</html>