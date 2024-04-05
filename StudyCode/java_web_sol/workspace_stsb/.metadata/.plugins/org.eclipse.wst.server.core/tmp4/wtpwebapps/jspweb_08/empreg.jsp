<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.DBConfig" %>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("직원정보처리<br>");
		String empid = request.getParameter("empid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
	
		Connection connection = null;
		PreparedStatement pstmt =null;
		
		try{
			connection = DBConfig.getConnection();
			out.println("jsp계정 접속<br>");
		}catch(Exception e){
			out.println("jsp계정 접속 실패<br>");
		}
		
		//폼정보에서 받은 변수들 empid, name, email, contact 값 저장
		
		try{
			String sql="INSERT INTO EMPLOYEES(EMPLOYEE_ID, LAST_NAME,EMAIL,PHONE_NUMBER) VALUES (?,?,?,?)";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, empid);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, contact);
			int result = pstmt.executeUpdate();
			out.println("데이터 등록 결과 "+result);
			if(result==1){
				out.println("<script>alert('직원등록성공!')</script>");
				out.println("<script>location.href='emplist.jsp'</script>");
			} else{
				out.println("실패");
			}
			
		}catch(SQLException e){
			
		}
	%>
	<%= empid %>
	<%= name %>
	<%= email %>
	<%= contact %>
</body>
</html>