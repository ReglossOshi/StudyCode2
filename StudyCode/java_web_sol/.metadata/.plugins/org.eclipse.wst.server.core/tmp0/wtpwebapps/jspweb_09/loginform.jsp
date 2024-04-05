<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 정보 시스템 예제</title>
    <link rel="stylesheet" href="loginform.css">
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form class="login-form" action="loginpro.jsp" method="GET">
        <input type="text" id="employeeId" name="employeeId" placeholder="사원번호" required>
        <input type="password" id="password" name="userPw" placeholder="비밀번호" required>
        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>