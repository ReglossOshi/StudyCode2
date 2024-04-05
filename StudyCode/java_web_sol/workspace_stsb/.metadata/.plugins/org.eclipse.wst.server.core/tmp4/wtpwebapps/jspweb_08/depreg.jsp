<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.DBConfig" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String depid = request.getParameter("depid");
	String depname = request.getParameter("depname");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBConfig.getConnection();
			
		}catch(Exception e){
			out.println("");
		}
			
		try{
			String sql="INSERT INTO DEPARTMENTS(DEPART_ID, DEPART_NAME) VALUES (?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, depid);
			pstmt.setString(2, depname);
			int result = pstmt.executeUpdate();
			if(result==1){
				out.println("<script>alert('직원등록성공!')</script>");
				out.println("<script>location.href='deplist.jsp'</script>");
			} else{
				out.println("실패");
			}
		}catch(SQLException e){
			out.println("저장실패");
		}
	%>
</body>
</html>