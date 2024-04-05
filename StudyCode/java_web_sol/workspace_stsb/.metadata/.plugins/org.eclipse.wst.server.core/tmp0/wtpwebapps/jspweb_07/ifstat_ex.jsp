<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학점 계산 예제</h2>
	
	<%
		//성적: 83
		int score = 83;
		//조건문을 A,B,C,D,F로 판별하는 코드 구현
		String rank;
		if(score>=90){
			rank="A";
		} else if(score>=80){
			rank="B";
		} else if(score>=70){
			rank="C";
		} else if(score>=60){
			rank="D";
		} else{
			rank="E";
		}
	%>
	<p>성적: <%=score%></p>
	<p>학점: <%=rank%></p>
</body>
</html>