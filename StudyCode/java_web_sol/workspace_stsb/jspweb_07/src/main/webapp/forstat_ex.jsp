<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp를 사용하여 테이블 구현</h2>
	<%
		ArrayList<String> name = new ArrayList<>();
		name.add("김상완");
		name.add("배승재");
		name.add("송지우");
		ArrayList<String> departName = new ArrayList<>();
		departName.add("기획팀");
		departName.add("개발팀");
		departName.add("보안팀");
		
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>직원명</th>");
		out.println("<th>부서명</th>");
		
		for(int i=0;i<name.size();i++){
			out.println("<tr>");
			out.println("<td>"+ name.get(i) +"</td>");
			out.println("<td>"+ departName.get(i) +"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
	%>
</body>
</html>