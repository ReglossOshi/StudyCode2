<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@page import="com.oreilly.servlet.*" %>
<%@page import="com.oreilly.servlet.multipart.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	//String num = request.getParameter("num");
	//String korname = request.getParameter("korname");
	//String title = request.getParameter("title");
	//String content = request.getParameter("content");
	
	String num = "";
	String korname = "";
	String title = "";
	String content = "";

//1.JSDB로 Oracle연결 ->java - DBConfig.java
	Connection conn = null; //디비 접속 성공시 접속 정보 저장
	PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
	Exception exception = null;
	String savePath="C:\\Users\\human-08\\Desktop\\git-Regloss\\Example\\java_web_sol\\workspace_stsb\\starbucks-notice\\src\\main\\webapp\\upload-files";
	
	try{
			MultipartRequest multi = new MultipartRequest(
				request,
				savePath, //실제 파일을 저장할 서버의 디렉토리
				1024*1024*5, //업로드 제한 파일 크기(단위BYTE)->5MB
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
			num = multi.getParameter("num");
			korname = multi.getParameter("korname");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			String file1Prev = multi.getParameter("file1Prev");
			String file2Prev = multi.getParameter("file2Prev");
			String filename1= multi.getFilesystemName("filecontent1");
			String filename2= multi.getFilesystemName("filecontent2");
			
			String fileQueryName1 = "";
			if (filename1 != null) {
				// 실제 첨부파일1 삭제
				File file = new File(savePath + "\\" + file1Prev);
				if (file.exists()) {
					file.delete();
				}
				
				fileQueryName1 = ", FILE1_PATH = '" + filename1 + "' ";
			}
			String fileQueryName2 = "";
			if (filename2 != null) {
				// 실제 첨부파일2 삭제
				File file = new File(savePath + "\\" + file2Prev);
				if (file.exists()) {
					file.delete();
				}
				// 실제 첨부파일2 삭제
				fileQueryName2 = ", FILE2_PATH = '" + filename2 + "' ";
			}
			
		conn=DBConfig.getConnection();
		
		//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
		
		String sql = "UPDATE BO_FREE SET NAME = ?, SUBJECT = ?, CONTENT = ? " 
				+ fileQueryName1 + fileQueryName2 + " WHERE NUM = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, korname);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setInt(4,Integer.parseInt(num));
		
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
		alert('공지사항 글이 성공적으로 수정되었습니다.');
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
    