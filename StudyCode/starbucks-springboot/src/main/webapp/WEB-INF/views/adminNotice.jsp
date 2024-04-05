<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DBConfig"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
    <title>스타벅스 어드민 공지사항</title>
</head>
<body>
    <div class="card">
        <div class="card-header"><a href="#"><h1>스타벅스 어드민 공지사항</h1></a></div>
        <div class="card-body">
            <input type="search" name="search-text" id="search-text" placeholder="검색어를 입력하세요." value='<c:out value="${search}"/>'><a class="search" href="javascript: searchText();">검색</a>
            
            <c:forEach items="${freeBoardVOList}" var="freeBoard">
            	<div class="content-box">
	               <div class="check"><c:out value="${freeBoard.num}" /></div>
	               <div class="title">
	               		<a href='/adminNoticeUpdateForm?num=<c:out value="${freeBoard.num}" />'>
	               		<c:out value="${freeBoard.subject}" />
	               		</a>
	               </div>
	               <div><c:out value="${freeBoard.hit}" /></div>
	               <div class="delete">
	               <form id="deleteForm" action="/adminNoticeDelete" method="post" onsubmit="return false">
	               		<input type="hidden" name="num" value='<c:out value="${freeBoard.num}"/>'>
	               		<input type="hidden" name="file1" value='<c:out value="${freeBoard.file1Path}"/>'>
	               		<input type="hidden" name="file2" value='<c:out value="${freeBoard.file2Path}"/>'>
	               		<button type="submit" onclick="textdelete()">X</button>
	               </form>
	               </div>
	     		</div>
            </c:forEach>
            
            <ul class="number">
                <li><a href="adminNotice.jsp?pagenum=">&lt;</a></li>
                <li>
             		<a href="/adminNoticeList?pagenum=">1</a>
             	</li>
                <li><a href="adminNotice.jsp?pagenum=">&gt;</a></li>
            </ul>
        </div>
        <div class="btn">
            <a href="/adminNoticeInsertForm">글쓰기</a>
        </div>
    </div>

    <script type="text/javascript">
		const insertSuccessCount = '<c:out value="${insertSuccessCount}" />';	
    	if(insertSuccessCount){
    		alert('글이 성공적으로 등록되었습니다.');
    	}
    	
    	const num = '<c:out value="${num}"/>';
    	if(num){
    		alert('글이 삭제 되었습니다.');
    	}
    	
    	function searchText() {
			location.href="/adminNoticeList?search="+$('#search-text').val();
		}


    	function textdelete() {
    		
    		var a = confirm("선택한 글을 정말 삭제하시겠습니까?");
    		if(a==true){
    			document.getElementById('deleteForm').submit();
    		}
		}
    </script>
   <%
	   	// 캐시 만료를 통한 뒤로가기 방지
	    response.setHeader("Expires", "Thu, 27 Jul 2023 09:00:00 GMT"); // 현재시각보다 이전으로만 만료시간을 설정
	    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0"); // str 로 "" 으로 넣는것보단, 상수형으로 넣어주는게 좋다. 
	    response.setHeader("Pragma", "no-cache"); 
   %>
</body>
</html>