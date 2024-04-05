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
    <title>스타벅스 어드민 공지사항</title>
</head>
<body>
    <!-- 1. 게시판의 화면은 class="card"로 적용 -->
    <div class="card">

        <!-- 1-1. 게시판 이름은 class="card-header"로  <div>로 구역 설정 -->
        <div class="card-header"><a href="#"><h1>스타벅스 어드민 공지사항</h1></a></div>

        <!-- 1-2. 내용은 class="card-body"로 <div>로 구역 설정 -->
        <div class="card-body">
	<%
	//request, session, application =>웹 서버 생명 주기 scope
	session.setAttribute("name", "홍길동");
	//application.setAttribute("name-id", "홍길동");
	//session.getAttribute(arg0, arg1);
	
	String search=request.getParameter("search");
	//1.JSDB로 Oracle연결 ->java - DBConfig.java
	Connection conn = null; //디비 접속 성공시 접속 정보 저장
	PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
	ResultSet rs = null;
	if(search==null){
		search="";
	}
	%>
            <!-- 검색어 입력하기 -->
            <input type="search" name="search-text" id="search-text" placeholder="검색어를 입력하세요." value="<%=search%>"><a class="search" href="javascript: searchText();">검색</a>
            
            <!-- 내용을 HTML로 작성하기 -->
    <% 
		String currentPage=request.getParameter("pagenum");
		
		if(currentPage==null){
			currentPage="1";
		}
	
		int totalCount=0;
		int pageCount=5;
		int limit=5;
		int totalPage=0;
		int pageGroup=0;
		int firstNumber=0;
		int lastNumber=0;
		int row = 0;
		int count=0;
		int next=0;
		int prev=0;
		
		try{
			conn=DBConfig.getConnection();
			String sql = "SELECT count(*) FROM BO_FREE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				totalCount+=rs.getInt(1);

			}
			
			totalPage = (int)(totalCount/limit);

			
			if(totalCount%limit>0){
				totalPage+=1;
			}

			
			if(totalPage<Integer.parseInt(currentPage)){
				currentPage=Integer.toString(totalPage);
			}
			
			pageGroup=Integer.valueOf(currentPage)/pageCount;

			if(pageGroup==0){
				pageGroup++;
			}

			
			lastNumber = pageGroup*pageCount;

			if(lastNumber>totalPage){
				lastNumber=totalPage;
			}

			firstNumber = lastNumber-(pageCount-1);
			
			next = lastNumber+1;
			prev = firstNumber-1;
			
			if(firstNumber<=0){
				firstNumber=1;
				prev=1;
			}
			
			count=Integer.parseInt(currentPage)-1;
			
			row=limit*count;
			
		}catch(SQLException e){
			System.out.println("에러 로그:"+e.getMessage());
		}
	%>
            
            <%
					try{
						conn=DBConfig.getConnection();
						
						//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
						String sql = "SELECT num, subject, TO_CHAR(regdate,'YYYY-MM-DD'),hit FROM BO_FREE WHERE subject LIKE '%"+search+"%' order by num OFFSET "+row+" ROWS FETCH NEXT "+limit+" ROW ONLY";
						pstmt = conn.prepareStatement(sql);

						
						//3. rs로 데이터 가져온 걸 웹에 보여주기 => 쿼리 실행 결과 출력
						rs = pstmt.executeQuery();
						
						//rs.last();
						//int i=rs.getRow();
						//rs.beforeFirst();

						while(rs.next()){
						
							%>
								<div class="content-box">
					                <div class="check"><input type="checkbox" name="" id=""></div>
					                <div class="title"><a href="adminNoticeUpdateForm.jsp?num=<%=rs.getInt(1)%>"><%=rs.getString(2) %></a></div>
					                <div class="delete">
					                	<button onclick="textdelete(<%=rs.getInt(1)%>)">X</button>
					                </div>
           						</div>
							<% 
						}
						
					}catch(SQLException e){
						System.out.println("에러 로그:"+e.getMessage());
					}
        		%>
	
            <ul class="number">
                <li><a href="adminNotice.jsp?pagenum=<%=prev%>">&lt;</a></li>
                <%
                	for(int i=firstNumber;i<=lastNumber;i++){
                		if (i == Integer.parseInt(currentPage)) { 
                		%>
                			<li>
                				<a href="adminNotice.jsp?pagenum=<%=i%>" style="background-color: rgb(252, 212, 205);"><%=i%></a>
                				<%System.out.println("등록"); %>
                			</li>
                		<%
                		} else{
                			%>
                				<li>
                					<a href="adminNotice.jsp?pagenum=<%=i%>"><%=i%></a>
                				</li>
                			<%
                		}
                	}
                %>
                <li><a href="adminNotice.jsp?pagenum=<%=next%>">&gt;</a></li>
            </ul>
        </div>

        <!-- 1-3. 글쓰기 버튼은 class="btn"로 <div>로 구역 설정 -->
        <div class="btn">
            <a href="adminNoticeInsertForm.jsp">글쓰기</a>
        </div>
    </div>
    
    <script type="text/javascript">
    
    	function searchText() {
			location.href="adminNotice.jsp?search="+$('#search-text').val();
		}
    	
    	
    	function textdelete(num) {
    		var a = confirm("선택한 글을 정말 삭제하시겠습니까?");
    		if(a==true){
    			location.href="adminNoticeDelete.jsp?num="+num;
    		}
		}
    </script>
</body>
</html>