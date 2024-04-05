<%@page import="utils.DBConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>사용자 인증 처리</h2>
	
	<%
		String empid = request.getParameter("employeeId");
		String userpw = request.getParameter("userPw");
		
		Connection conn = null; //디비 접속 성공시 접속 정보 저장
		PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
		ResultSet rs = null;//select 결과를 저장하는 정보
		try{
			conn=DBConfig.getConnection();
			out.println("접속 성공");
		}catch(SQLException e){
			out.println("접속 실패");
		}
		
		int result=0;
		//아이디 비밀번호 체크 코드
		try{
			String sql = "SELECT COUNT(*) CNT FROM EMPLOYEES WHERE EMPLOYEE_ID = ? AND USER_PW=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empid));
			pstmt.setString(2, userpw);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				result=rs.getInt("CNT");
				System.out.println("결과result: "+result);
			}
			
			if(result==1){
				out.println("<script>location.href='main.jsp'</script>");
			} else{
				out.println("<script>location.href='loginform.jsp'</script>");
			}
			
		}catch(SQLException e){
			System.out.println("없음");
		}
	%>
	
	<% //System.out.println(empid); %>
	<br>
	<% //System.out.println(userpw); %>
</body>
</html>