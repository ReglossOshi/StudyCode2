<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.util.*, java.io.*,java.text.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String fileName = request.getParameter("filename");
	String fileNameEncoding = URLEncoder.encode(fileName, "UTF-8");
	
	System.out.println(fileName);
	
	String savePath="C:\\Users\\human-01\\Desktop\\StudyCode\\starbucks-springboot\\src\\main\\resources\\static\\upload-files";
	File file = new File(savePath+"\\"+fileName);
	
	
	//File 다운로드 처리 Header설정
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	
	
	//out객체 초기화
	out.clear();
	pageContext.pushBody();
	
	// File 다운로드 처리
	BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
	
	int read = 0;
	byte b[] = new byte[1024 * 4];
	while ((read = fin.read(b)) != -1) {
		outs.write(b, 0, read);
	}
	outs.flush();
	outs.close();
	fin.close();
%>