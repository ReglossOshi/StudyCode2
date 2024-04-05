<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>간단한 연산 예제</h2>
	
	<% 
		int apples = 232;
		int cntperbox = 20;
		//사과 박스 몇개 필요한가.
		//남는 사과의 개수
		
		int box = apples/cntperbox;
		int apple = apples%cntperbox;
		
		//out.println("박스 "+box+"개"+" 남은사과 "+apple+"개");
	%>
	<p>총 사과 <%=apples%>개</p>
	<p>박스 <%=box%>개 </p>
	<p>남은 사과 <%=apple%>개</p>
</body>
</html>