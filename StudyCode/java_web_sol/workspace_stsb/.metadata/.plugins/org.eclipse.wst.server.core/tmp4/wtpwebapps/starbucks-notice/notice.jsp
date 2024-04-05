<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 | Starbucks Korea Coffee</title>
    <link rel="stylesheet" href="css/reset.css">
    
    <link rel="icon" href="images/favicon.ico">
    <script defer src="js/jquery-3.7.1.min.js"></script>
    <script defer src="js/main.js"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <!-- lodash -->
    <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
    <!-- gsap -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/ScrollToPlugin.min.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/notice.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- swiper 11버전 -->
    <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css">
    <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
  </head>
<body>
	<%@ include file="header.jsp" %>

	<section>
		<%@ include file="list.jsp" %>
        <div class="inner select">
        	<div class="select-input">
        		<input type="text" id="selin" placeholder="검색어를 입력해 주세요."/>
        		<input type="button" name="" id="selbut" value="검색"/>
        	</div>
        </div>
        <div class="inner tab">
        	<table>
        		<tr>
        			<th>NO</th>
        			<th>제목</th>
        			<th>날짜</th>
        			<th>조회수</th>
        		</tr>
        		
        		<!-- 반복될 구간 -->
        		<%
        			//1.JSDB로 Oracle연결 ->java - DBConfig.java
        			Connection conn = null; //디비 접속 성공시 접속 정보 저장
					Statement stmt = null; //쿼리를 실행하기 객체 정보
					ResultSet rs = null;
					
					try{
						conn=DBConfig.getConnection();
						System.out.println("접속 성공");
						
						//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
						stmt = conn.createStatement();
						String sql = "SELECT num, subject, TO_CHAR(regdate,'YYYY-MM-DD'),hit FROM BO_FREE order by num";
						
						//3. rs로 데이터 가져온 걸 웹에 보여주기 => 쿼리 실행 결과 출력
						rs = stmt.executeQuery(sql);
						
						//rs.last();
						//int i=rs.getRow();
						//rs.beforeFirst();

						while(rs.next()){
						
							%>
							<tr>
			        			<td><%=rs.getInt(1) %></td>
			        			<td><a href="post.jsp?num=<%=rs.getInt(1)%>"><%=rs.getString(2) %></a></td>
			        			<td><%=rs.getString(3) %></td>
			        			<td><%=rs.getInt(4) %></td>
			        		</tr>
							<% 
						}
						
					}catch(SQLException e){
						System.out.println("에러 로그:"+e.getMessage());
					}
        		%>
        					<tr>
			        			<td>1</td>
			        			<td><a href="./post.jsp?num=0">서비스 개선 및 서비스 점검 안내</a></td>
			        			<td>2024-01-24</td>
			        			<td>891</td>
			        		</tr>
        	</table>
        	
        	<div class="number">
        		[1, 2, 3, 4, 5]
        	</div>
        </div>
	</section>
</body>
</html>