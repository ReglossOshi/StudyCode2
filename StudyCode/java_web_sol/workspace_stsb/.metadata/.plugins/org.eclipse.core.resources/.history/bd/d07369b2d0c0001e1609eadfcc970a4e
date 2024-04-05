<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="css/style.css">
     <script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
    <title>글쓰기</title>
</head>
<body>
    <div class="card">
        <div class="card-header1">
            <h1><a href="adminNotice.jsp">스타벅스 공지사항 작성</a></h1>
        </div>
        <form action="adminNoticeInsert.jsp" method="post" id="form1" onSubmit="return false">
        <div class="card-write">
            <div class="myinfo">
                이름<input type="text" id="korname" name="korname" placeholder="이름을 입력하세요.">
            </div>
            <div class="title-w">
                제목<input type="text" id="title" name="title" placeholder="제목을 입력하세요.">
            </div>
            <div class="msg">
                내용<textarea  id="content" name="content" placeholder="내용을 입력하세요."></textarea>
                <input type="file" name="filecontent" id="">
            </div>
        </div>
        <div class="btn-w"><input type="submit" value="작성" class="btn-w" onclick="checkWrite()"></div>
        </form>
    </div>
    <script>
    	function checkWrite() {
    		if(!$('#korname').val()){
    			alert('이름을 입력하세요.');
    			$('#korname').focus();
    			
    			return;
    		}
    		
    		if($('#korname').val().length>=5){
    			alert('10자이내로 입력하세요.');
    			$('#korname').focus();
    			
    			return;
    		}
    		
    		if(!$('#title').val()){
    			alert('제목을 입력하세요.');
    			$('#title').focus();
    			
    			return;
    		}
    		if(!$('#content').val()){
    			alert('내용을 입력하세요.');
    			$('#content').focus();
    			
    			return;
    		}
    		document.getElementById('form1').submit();
		}
    </script>
</body>
</html>