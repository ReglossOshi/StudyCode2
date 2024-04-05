<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Document</title>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="background">
        <div class="size">
                <div class="log">로그인</div>
            <div class="loginbox">
                    <div class="welcome">Welcome! 스타벅스 코리아에 오신 것을 환영합니다.</div>
                        <form class="text" action="loginSearch.jsp" method="get">
                        	<input type="text" name="id" class="lgtext" id="" placeholder="아이디를 입력해 주세요.">
	                        <input type="password" name="pw"  class="lgtext" id="" placeholder="비밀번호를 입력해 주세요.">
	                        <div class="check">
	                            <input type="checkbox" name="save" id="save">
	                            <label for="save">아이디 저장</label>
	                        </div>
	                        <input type="submit" value="로그인" id="loginbtn" onclick="">
                        
                        <p>
                        * 타 사이트와 비밀번호를 동일하게 사용할 경우 도용의 위험이 있으므로, 정기적인 비밀번호 변경을 해주시길 바랍니다.
                        <br>
                        * 스타벅스 코리아의 공식 홈페이지는 Internet Explorer 9.0 이상, Chrome, Firefox, Safari 브라우저에 최적화 되어있습니다.
                        </p>
                    	</form>
                        <div class="btn">
                            <ul>
                                <li><a href="#">회원가입</a></li>
                                <li><a href="#">아이디 찾기</a></li>
                                <li><a href="#">비밀번호 찾기</a></li>
                            </ul>
                        </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    	
    </script>
</body>
</html>