<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("num");

//1.JSDB로 Oracle연결 ->java - DBConfig.java
	Connection conn = null; //디비 접속 성공시 접속 정보 저장
	PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
	Exception exception = null;

	try{
		conn=DBConfig.getConnection();
		
		//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
		
		String sql = "DELETE FROM bo_free WHERE NUM=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,Integer.parseInt(num));
		
		pstmt.executeUpdate();
		
	}catch(Exception e){
		exception=e;
		System.out.println("에러 로그:"+e.getMessage());
	} finally{
		if(pstmt !=null){try{pstmt.close();}catch(SQLException e){}}
		if(conn !=null){try{conn.close();}catch(SQLException e){}}
	}
%>

<%
	if(exception==null){
		%>
		<script>
		alert('공지사항 글이 성공적으로 삭제되었습니다.');
		location.href='<%=request.getContextPath()%>/adminNotice.jsp';
		</script>
		<%	
	} else{
		%>
		공지사항 글 등록이 실패하였습니다. 시스템 관리자에게 문의하세요.<BR>
		오류내용:<%=exception.getMessage() %>
		<%
	}
%>
    