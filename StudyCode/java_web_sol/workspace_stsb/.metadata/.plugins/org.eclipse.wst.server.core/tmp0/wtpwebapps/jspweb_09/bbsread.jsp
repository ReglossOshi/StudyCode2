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
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 800px;
      margin: 50px auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2, h3, p {
      color: #333;
    }

    .meta-info {
      margin-bottom: 20px;
    }

    .meta-info span {
      font-weight: bold;
    }

    .content {
      line-height: 1.6;
    }

    .back-link {
      display: flex;
      justify-content: center;
      margin-top: 20px;
    }

    .back-link button {
      background-color: #4caf50;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .back-link button:hover {
      background-color: #45a049;
    }

    .comments-section {
      margin-top: 30px;
      border-top: 1px solid #ccc;
      padding-top: 20px;
    }

    .comment-form {
      margin-bottom: 20px;
    }

    .comment-form textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .comment-list {
      list-style: none;
      padding: 0;
    }

    .comment {
      border-bottom: 1px solid #ccc;
      padding: 10px 0;
    }

    .attachment {
      margin-top: 20px;
    }

    .attachment a {
      display: block;
      color: #4caf50;
      text-decoration: none;
      font-weight: bold;
      margin-top: 10px;
    }

    .attachment a:hover {
      text-decoration: underline;
    }

    .delete-button {
      background-color: #f44336;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      margin-top: 10px;
    }

    .delete-button:hover {
      background-color: #d32f2f;
    }
  </style>
</head>
<body>
<!-- 헤더영역 공통부분 -->
   <%@ include file="header.jsp" %>
   
   <%
		Connection conn = null; //디비 접속 성공시 접속 정보 저장
		PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
		ResultSet rs = null;
		String num =request.getParameter("num");
		
		try{
			conn=DBConfig.getConnection();
			System.out.println("접속 성공");
		}catch(SQLException e){
			System.out.println("에러 로그:"+e.getMessage());
		}
		BoardVo board = new BoardVo();
		try{
			String sql = "SELECT NUM, SUBJECT, NAME, TO_CHAR(REGDATE,'YYYY-MM-DD') AS REGDATE,CONTENT FROM BO_FREE WHERE NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				board.setNum(rs.getInt("NUM"));
				board.setSubject(rs.getString("SUBJECT"));
				board.setName(rs.getString("NAME"));
				board.setRegdate(rs.getString(4));
				board.setContent(rs.getString("CONTENT"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
   %>
	<div class="container">
    <h2><%=board.getSubject() %></h2>
    <div class="meta-info">
      <span>작성자:</span> <%=board.getName() %><br>
      <span>작성일:</span> <%=board.getRegdate() %>
    </div>
    <div class="content">
      <p><%=board.getContent() %></p>
    </div>
 <div class="back-link">
      <button onclick="goBack()">목록으로 돌아가기</button>
    </div>

    <!-- 댓글 섹션 시작 -->
    <div class="comments-section">
      <h3>댓글</h3>

      <!-- 댓글 작성 폼 -->
      <div class="comment-form">
        <textarea id="commentText" placeholder="댓글을 작성하세요"></textarea>
        <button onclick="postComment()">댓글 작성</button>
      </div>

      <!-- 댓글 목록 -->
      <ul class="comment-list">
        <li class="comment">댓글 1: 여기에 댓글 내용이 들어갑니다.</li>
        <li class="comment">댓글 2: 다른 사용자의 댓글 내용이 들어갑니다.</li>
      </ul>
    </div>
    <!-- 댓글 섹션 끝 -->

    <!-- 삭제 버튼 -->
    <button class="delete-button" onclick="deletePost(<%= board.getNum()%>)">게시글 삭제</button>

  </div>
  <script type="text/javascript">
  		function deletePost(num) {
  			var ok = confirm("선택한 글을 삭제하시겠습니까?");
  			if(ok==true){
  				location.href="bbsdelete.jsp?num="+num;
  			} else if(ok==false){
  				location.href="bbsread.jsp?num="+num;
  			}
			
		}
  		function goBack(){
  			location.href="board.jsp";
  		}
  </script>
</body>
</html>