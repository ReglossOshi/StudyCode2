<%@page import="java.sql.SQLException"%>
<%@page import="vo.DepVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="utils.DBConfig" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* 직원 목록 */
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
   .employee-list {
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
   }

   table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
   }

   th, td {
      border: 1px solid #ddd;
      padding: 10px;
      text-align: left;
   }

   th {
      background-color: #3498db;
      color: #fff;
   }
</style>
</head>
<body>
<%
      // 오라클 디비와 접속
      Connection connection = null;
      // 접속하기 
      try {
        //connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        connection = DBConfig.getConnection();
        System.out.println("jsp계정 접속성공");
      }catch(Exception e) {
        System.out.println("jsp계정 접속실패");        
      }   
      
      //직원정보 목록을 가져오는 쿼리 실행
      PreparedStatement pstmt = null;
      ResultSet resultSet = null;
      ArrayList<DepVo> deplist = new ArrayList<>();
      try{
    	  String sql = "SELECT DEPART_ID,DEPART_NAME FROM DEPARTMENTS ORDER BY DEPART_ID";
    	  pstmt = connection.prepareStatement(sql);
    	  resultSet = pstmt.executeQuery();
    	  
    	  while(resultSet.next()){
    		  DepVo depvo = new DepVo();
    		  depvo.setDEPART_ID(resultSet.getString("DEPART_ID"));
    		  depvo.setDEPART_NAME(resultSet.getString("DEPART_NAME"));
    		  deplist.add(depvo);
    	  }
    	  out.println(deplist.size());
      }catch(SQLException e){
    	  System.out.println("에러로그:직원목록==>"+e.getMessage());
      }
      
   %>

 	<div class="employee-list">
        <h2>부서 목록</h2>
        <button onclick="handleAddButtonClick()">부서 등록</button> <!-- 등록 버튼 추가 -->
        <table>
            <thead>
            <tr>
            	<th>부서번호</th>
                <th>부서명</th>
                <th>동작</th> <!-- 새로운 열 추가 -->
                
            </tr>
            </thead>
            <tbody>
            <% 
            	for(int i=0;i<deplist.size();i++){
            		DepVo temp = deplist.get(i);
            %>
            <tr>
            	<td><%=temp.getDEPART_ID() %></td>
                <td><%=temp.getDEPART_NAME() %></td>
                <td><button onclick="handleButtonClick(0)">수정 처리</button> <!-- 버튼 추가 -->
                <button onclick="handleButtonClick(0)">삭제 처리</button><!-- 버튼 추가 -->
                
                </td> <!-- 상세보기 버튼 추가 -->
            </tr>
            
            <%
            	}
            %>
           
            <!-- 다른 직원들의 정보도 추가할 수 있습니다. -->
            </tbody>
        </table>
    </div>
    
    <script>
      function handleAddButtonClick() {
           location.href="depform.jsp";
       }
   </script>
</body>
</html>