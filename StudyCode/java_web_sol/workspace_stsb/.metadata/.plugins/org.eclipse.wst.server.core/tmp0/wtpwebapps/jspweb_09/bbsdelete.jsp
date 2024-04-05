<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="vo.BoardVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 헤더영역 공통부분 -->
	<%
		Connection conn = null; //디비 접속 성공시 접속 정보 저장
		PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
		String num =request.getParameter("num");
		
		try{
			conn=DBConfig.getConnection();
			System.out.println("접속 성공");
		}catch(SQLException e){
			System.out.println("에러 로그:"+e.getMessage());
		}
		BoardVo board = new BoardVo();
		try{
			
			String sql = "DELETE FROM BO_FREE WHERE NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
			out.println("<script>location.href='board.jsp'</script>");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
   %>
</body>
</html>