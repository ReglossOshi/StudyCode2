<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		
		String name = request.getParameter("employeeName");
		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");
		
		Connection conn = null; //디비 접속 성공시 접속 정보 저장
		PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
		try{
			conn=DBConfig.getConnection();
			out.println("접속 성공");
		}catch(SQLException e){
			System.out.println("에러 로그:"+e.getMessage());
		}
		
		int result=0;
		try{
				String sql="INSERT INTO BO_FREE (name, subject, content) "
						+"VALUES (?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				result=pstmt.executeUpdate();
				out.println("전송 완료:"+result);
				if(result==1){
					out.println("<script>location.href='board.jsp'</script>");
				}else{
					out.println("<script>location.href='board.jsp'</script>");
				}
				
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	%>
</body>
</html>