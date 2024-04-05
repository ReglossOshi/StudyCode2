<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .employee-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
        }

        input {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #217dbb;
        }
</style>
</head>
<body>
	<div class="employee-form">
    <h2>부서 정보 등록</h2>
    <form id="departForm" action="depreg.jsp">
      <label for="depid">부서번호</label>
        <input type="text" id="depid" name="depid" required>
      
        <label for="depname">부서명</label>
        <input type="text" id="depname" name="depname" required>

        <button type="submit">등록</button>
    </form>
</div>

<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>

<script>
	$(document).ready(function(){
		$('#departForm').submit(function(){});
	});
</script>
</body>
</html>