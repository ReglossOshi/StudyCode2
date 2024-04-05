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

        .board-container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .board-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .board-item:last-child {
            border-bottom: none;
        }

        .board-item a {
            text-decoration: none;
            color: #333;
        }

        .board-item .bbshead {
            text-align: center;
            background-color: #333;
            font-weight: bold;
            color: white;
            padding: 10px;
        }
        .board-item .bbshead a{
            color: white;
        }
        .board-item .number {
            flex: 1;
            text-align: center;
        }

        .board-item .title {
            flex: 4;
        }

        .board-item .author {
            flex: 2;
            text-align: center;
        }

        .board-item .views {
            flex: 1;
            text-align: center;
        }

        .add-button {
            display: block;
            margin: 20px auto;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
            text-align: center;
            border-radius: 4px;
        }

        .add-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<!-- 헤더영역 공통부분 -->
   <%@ include file="header.jsp" %>
   <!-- 헤더영역 공통부분 끝 -->
   
   <div class="board-container">
    <h2>게시판 목록</h2>
   
      
     
       <%
	       	Connection conn = null; //디비 접속 성공시 접속 정보 저장
			PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
			ResultSet rs = null;
			try{
				conn=DBConfig.getConnection();
				System.out.println("접속 성공");
			}catch(SQLException e){
				System.out.println("에러 로그:"+e.getMessage());
			}
			//게시판 데이터 검색
			
			ArrayList<BoardVo> boardList = new ArrayList<>();
			
			try{
			String sql = "SELECT NUM, SUBJECT, NAME, HIT FROM BO_FREE ORDER BY NUM DESC";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				BoardVo board = new BoardVo();
				board.setNum(rs.getInt("NUM"));
				board.setSubject(rs.getString("SUBJECT"));
				board.setName(rs.getString("NAME"));
				board.setHit(rs.getInt("HIT"));
				boardList.add(board);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
       %>
       
        <div class="board-item">
           <div class="bbshead number">번호</div>
           <div class="bbshead title"><a href="#">제목</a></div>
           <div class="bbshead author">작성자</div>
           <div class="bbshead views">조회수</div>
       </div>
       
         <!-- 반복 구문 -->
         <%
         	int number = boardList.size();
         	for(int i=0;i<boardList.size();i++){
         		BoardVo temp = boardList.get(i);
         		
         %>
       <div class="board-item">
           <div class="number"><%= number-- %></div>
           <div class="title"><a href="bbsread.jsp?num=<%=temp.getNum() %>" ><%= temp.getSubject() %></a></div>
           <div class="author"><%= temp.getName() %></div>
           <div class="views"><%= temp.getHit() %></div>
       </div>
       <%} %>
       
       <!-- 추가적인 게시물 목록은 필요에 따라 반복해서 추가 -->
   
       <a href="writeform.jsp" class="add-button">새 게시물 작성</a>
   </div>
   
</body>
</html>