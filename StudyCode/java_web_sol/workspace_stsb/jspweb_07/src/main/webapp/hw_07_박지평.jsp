<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{margin: auto;}
	.name{background-color: plum;}
</style>
</head>
<body>
	<div>
	<h1>구구단</h1>
	<table border="1">
		<%
			out.println("<tr>");
			for(int i=2;i<10;i++){
				out.println("<td class='name'>"+i+"단"+"</td>");		
			}
			out.println("</tr>");
			
			for(int i=1;i<10;i++){
				out.println("<tr>");
				for(int j=2;j<10;j++){
					out.println("<td>"+j+"X"+i+"="+i*j+"</td>");			
				}
				out.println("</tr>");
			}
			
		%>
	</table>
	</div>
</body>
</html>