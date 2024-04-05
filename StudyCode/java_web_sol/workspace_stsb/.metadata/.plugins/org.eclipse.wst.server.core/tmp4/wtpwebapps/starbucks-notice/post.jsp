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
    <title>Starbucks Korea Coffee</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/notice.css">
    <link rel="stylesheet" href="css/post.css">
    
    <link rel="icon" href="images/favicon.ico">
    <script defer src="js/jquery-3.7.1.min.js"></script>
    <script defer src="js/main.js"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <!-- lodash -->
    <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.21/lodash.min.js"></script>
    <!-- gsap -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/ScrollToPlugin.min.js"></script>
    
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
		
<%
	String num = request.getParameter("num");
	//1.JSDB로 Oracle연결 ->java - DBConfig.java
	Connection conn = null; //디비 접속 성공시 접속 정보 저장
	PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
	ResultSet rs = null;
	

	try{
		conn=DBConfig.getConnection();
		
		//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
		
		String sql = "UPDATE BO_FREE SET HIT=HIT+1 WHERE NUM=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,Integer.parseInt(num));
		pstmt.executeUpdate();
		
	}catch(Exception e){
		System.out.println("에러 로그:"+e.getMessage());
	}
%>
		<div class="inner post">
			<%
				
				
				if(num.equals("0")){
					%>
					<div class="title">
						<h1>서비스 개선 및 서비스 점검 안내</h1><a href="#"><img alt="페북" src="https://image.istarbucks.co.kr/common/img/whatsnew/icon_cpv_f.png"></a>
					</div>
					<div class="contents">
						<pre>
안녕하세요. 스타벅스 코리아입니다.

보다 나은 서비스 제공을 위한 시스템 점검을 진행합니다.

- 점검 시간 : 2024년 1월 25일(목) 오전 01:30 ~ 1월 25일(목) 오전 03:00

- 대상서비스 : 스타벅스 APP, 홈페이지


해당 점검 시간 중 서비스 이용에 불편 사항이 발생할 수 있는 점 양해 부탁드립니다.				
						</pre>
					</div>
					<div class="bottom">
						<input type="button" value="목록" onclick="location.href='notice.jsp'">
					</div>
					<div class="order">
						<div class="prev">
							<h3>윗글</h3>
							<p>해당글이 없습니다.</p>
						</div>
						<div class="next">
							<h3>아랫글</h3>
							<p>시스템 개선 및 서비스 점검 안내</p>
						</div>
					</div>
					
					<%
				} else{
					
					try{
						conn=DBConfig.getConnection();
						System.out.println("접속 성공");
						
						//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
						
						String sql = "SELECT A.SUBJECT,A.CONTENT,A.PREV,A.NEXT FROM (SELECT NUM,SUBJECT,CONTENT,LAG(SUBJECT,1,'해당글이 없습니다.')OVER(ORDER BY NUM) PREV, LEAD(SUBJECT,1,'해당글이 없습니다.')OVER(ORDER BY NUM) NEXT FROM BO_FREE ORDER BY NUM) A WHERE A.NUM=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(num));
						//3. rs로 데이터 가져온 걸 웹에 보여주기 => 쿼리 실행 결과 출력
						rs = pstmt.executeQuery();

						while(rs.next()){
						
							%>
								<div class="title">
						<h1><%= rs.getString(1)%></h1><a href="#"><img alt="페북" src="https://image.istarbucks.co.kr/common/img/whatsnew/icon_cpv_f.png"></a>
					</div>
					<div class="contents">
						<pre>
<%=rs.getString(2) %>		
						</pre>
					</div>
					<div class="bottom">
						<input type="button" value="목록" onclick="location.href='notice.jsp'">
					</div>
					<div class="order">
						<div class="prev">
							<h3>윗글</h3>
							<p><%=rs.getString(3)%></p>
						</div>
						<div class="next">
							<h3>아랫글</h3>
							<p><%=rs.getString(4)%></p>
						</div>
					</div>
							<% 
						}
						
					}catch(SQLException e){
						System.out.println("에러 로그:"+e.getMessage());
					}
				}
			%>
		</div>
	</section>
</body>
</html>