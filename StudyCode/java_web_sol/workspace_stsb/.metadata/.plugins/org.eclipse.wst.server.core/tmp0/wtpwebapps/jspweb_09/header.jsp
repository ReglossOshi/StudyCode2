<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	 <div class="top-menu">
    <div class="logo">휴먼교육(주)</div>
    <div class="login-menu">
      <li><a href="#">Home</a></li>
      <li><a href="#">About</a></li>
      <li><a href="board.jsp">Board</a></li>
      <li><button onclick="showLoginModal()">로그인</button></li>
    </div>
  </div>
  
  <script type="text/javascript">
  	function showLoginModal(){
  		location.href="loginform.jsp";
  	}
  </script>
</body>
</html>