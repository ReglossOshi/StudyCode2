/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-02-01 08:13:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.DBConfig;
import java.sql.*;
import java.util.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public final class adminNoticeInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("com.oreilly.servlet");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.oreilly.servlet.multipart");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("utils.DBConfig");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	//String korname = request.getParameter("korname");
	//String title = request.getParameter("title");
	//String content = request.getParameter("content");

	String korname ="";
	String title = "";
	String content = "";
	
//1.JSDB로 Oracle연결 ->java - DBConfig.java
	Connection conn = null; //디비 접속 성공시 접속 정보 저장
	PreparedStatement pstmt = null; //쿼리를 실행하기 객체 정보
	Exception exception = null;
	
	String savePath="C:\\Users\\human-08\\Desktop\\git-Regloss\\Example\\java_web_sol\\workspace_stsb\\starbucks-notice\\src\\main\\webapp\\upload-files";
	
	try{
		MultipartRequest multi = new MultipartRequest(
			request,
			savePath, //실제 파일을 저장할 서버의 디렉토리
			1024*1024*5, //업로드 제한 파일 크기(단위BYTE)->5MB
			"UTF-8",
			new DefaultFileRenamePolicy()
		);
		korname = multi.getParameter("korname");
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		
		String filename1= multi.getFilesystemName("filecontent1");
		String filename2= multi.getFilesystemName("filecontent2");
	
		
		
		conn=DBConfig.getConnection();
		
		//2. BO_FREE 테이블에서 SQL로 데이터 가져오기
		
		String sql = "INSERT INTO BO_FREE(NAME, SUBJECT, CONTENT,FILE1_PATH,fILE2_PATH) VALUES (?,?,?,?,?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, korname);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, filename1);
		pstmt.setString(5, filename2);
		
		pstmt.executeUpdate();
		
	}catch(Exception e){
		exception=e;
		System.out.println("에러 로그:"+e.getMessage());
	} finally{
		if(pstmt !=null){try{pstmt.close();}catch(SQLException e){}}
		if(conn !=null){try{conn.close();}catch(SQLException e){}}
	}

      out.write("\r\n");
      out.write("\r\n");

	if(exception==null){
		
      out.write("\r\n");
      out.write("		<script>\r\n");
      out.write("		alert('공지사항 글이 성공적으로 등록되었습니다.');\r\n");
      out.write("		location.href='");
      out.print(request.getContextPath());
      out.write("/adminNotice.jsp';\r\n");
      out.write("		</script>\r\n");
      out.write("		");
	
	} else{
		
      out.write("\r\n");
      out.write("		공지사항 글 등록이 실패하였습니다. 시스템 관리자에게 문의하세요.<BR>\r\n");
      out.write("		오류내용:");
      out.print(exception.getMessage() );
      out.write("\r\n");
      out.write("		");

	}

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
