<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="css/style.css">
     <script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
    <title>공지사항 수정</title>
</head>
<body>
	<%
		String num = request.getParameter("num");
		//1.JSDB로 Oracle연결 ->java - DBConfig.java
		Connection conn = null; //디비 접속 성공시 접속 정보 저장
		PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
		ResultSet rs = null;
		
		
		
		try{
			conn=DBConfig.getConnection();
			
			//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
			String sql = "SELECT NUM, NAME, SUBJECT, CONTENT, FILE1_PATH, FILE2_PATH FROM BO_FREE WHERE NUM =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			//3. rs로 데이터 가져온 걸 웹에 보여주기 => 쿼리 실행 결과 출력
			rs = pstmt.executeQuery();
			
			//rs.last();
			//int i=rs.getRow();
			//rs.beforeFirst();
	%>

    <div class="card">
        <div class="card-header1">
            <h1><a href="adminNotice.jsp">스타벅스 공지사항 수정</a></h1>
        </div>
        <%
        while(rs.next()){
        %>
        <form action="adminNoticeUpdate.jsp?num=<%=rs.getInt(1)%>" method="post" id="form1" onSubmit="return false" enctype="multipart/form-data">
        <input type="hidden" name="num" value="<%= num %>">
        <input type="hidden" name="file1Prev" value="<%= rs.getString("FILE1_PATH") == null ? "" : rs.getString("FILE1_PATH") %>">
        <input type="hidden" name="file2Prev" value="<%= rs.getString("FILE2_PATH") == null ? "" : rs.getString("FILE2_PATH") %>">
        <div class="card-write">
            <div class="myinfo">
                이름<input type="text" id="korname" name="korname" placeholder="이름을 입력하세요." value="<%=rs.getString(2)%>">
            </div>
            <div class="title-w">
                제목<input type="text" id="title" name="title" placeholder="제목을 입력하세요."  value="<%=rs.getString(3)%>">
            </div>
            <div class="msg">
                내용<textarea  id="content" name="content" placeholder="내용을 입력하세요." ><%=rs.getString(4)%></textarea>
                1. <input type="file" name="filecontent1" id="filecontent1">
                <div>등록된 첨부파일1 -> <a href="./fileDownload.jsp?filename=<%= rs.getString(5) %>"><%= rs.getString(5) %></a></div></div>
                <BR>
                2. <input type="file" name="filecontent2" id="filecontent2">
                <div>등록된 첨부파일2 -> <a href="./fileDownload.jsp?filename=<%= rs.getString(6) %>"><%= rs.getString(6) %></a></div></div>
            </div>
            <% 
			}
			
		}catch(SQLException e){
			System.out.println("에러 로그:"+e.getMessage());
		}
	%>
        </div>
        <div class="btn-w"><input type="submit" value="수정" class="btn-w" onclick="checkUpdate()"></div>
        </form>
    </div>
    <script>
    	function checkUpdate() {
    		if(!$('#korname').val()){
    			alert('이름을 입력하세요.');
    			$('#korname').focus();
    			
    			return;
    		}
    		
    		if($('#korname').val().length>=5){
    			alert('10자이내로 입력하세요.');
    			$('#korname').focus();
    			
    			return;
    		}
    		
    		if(!$('#title').val()){
    			alert('제목을 입력하세요.');
    			$('#title').focus();
    			
    			return;
    		}
    		if(!$('#content').val()){
    			alert('내용을 입력하세요.');
    			$('#content').focus();
    			
    			return;
    		}
    		document.getElementById('form1').submit();
		}
    </script>
</body>
</html>