/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-03-07 06:17:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fadd_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1709707807062L));
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1709707807070L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1709707807062L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <title>제품 등록</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"./css/product_add.css\">\r\n");
      out.write("  <link rel=\"icon\" href=\"./image/favicon.ico\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,700,0,0\" />\r\n");
      out.write("  <script src=\"./js/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/header.css\">\r\n");
      out.write("<link rel=\"icon\" href=\"./image/favicon.ico\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<header>\r\n");
      out.write("		<div class=\"logo\">\r\n");
      out.write("			<a href=\"index.jsp\" class=\"logodiv\">\r\n");
      out.write("				<img src=\"image/icons.png\" alt=\"icon\">\r\n");
      out.write("				<div class=\"logoname\">의류 생산 관리</div>\r\n");
      out.write("			</a>	\r\n");
      out.write("			<div class=\"login\">\r\n");
      out.write("				<button>로그인</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/menu.css\">\r\n");
      out.write("<link rel=\"icon\" href=\"./image/favicon.ico\" />\r\n");
      out.write("<!-- 메뉴 아이콘 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\r\n");
      out.write("<title>의류 생산 관리 시스템</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div id=\"round\">\r\n");
      out.write("		<div id=\"menu\">\r\n");
      out.write("        <input type=\"checkbox\" id=\"menubtn\">\r\n");
      out.write("        <label for=\"menubtn\" id=\"menubtnlabel\"><span class=\"material-symbols-outlined\">menu</span></label>\r\n");
      out.write("        <ul id=\"menuUl\">\r\n");
      out.write("            <li><a href=\"orderList.jsp\" class=\"dir\"><span class=\"material-symbols-outlined dir2\">menu_book</span> 주문 의뢰서</a></li>\r\n");
      out.write("            <li><a href=\"store.jsp\" class=\"dir\"><span class=\"material-symbols-outlined dir2\">inventory_2</span> 입고 등록</a></li>\r\n");
      out.write("            <li><a href=\"inventory.jsp\" class=\"dir\"><span class=\"material-symbols-outlined dir2\">inventory_2</span> 재고 관리</a></li>\r\n");
      out.write("            <li><a href=\"product_list.jsp\" class=\"dir\"><span class=\"material-symbols-outlined dir2\">inventory_2</span> 제품 관리</a></li>\r\n");
      out.write("            <li><a href=\"nike/button.html\" class=\"dir\"><span class=\"material-symbols-outlined dir2\">inventory_2</span> 월별 매출 관리</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	</header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("  <div class=\"pro_add_header\">\r\n");
      out.write("    <h1><a href=\"./product_list.jsp\" id=\"form1\" class=\"proList\" onSubmit=\"return false\">\r\n");
      out.write("    		<span class=\"material-symbols-outlined\">arrow_back</span>제품 목록\r\n");
      out.write("    	</a>\r\n");
      out.write("    </h1>\r\n");
      out.write("    <div class=\"pro_add\">\r\n");
      out.write("      <h2>제품 등록 작성란</h2>\r\n");
      out.write("      <form action=\"./product_add.jsp\" method=\"post\">\r\n");
      out.write("        <div class=\"proInfo\">\r\n");
      out.write("          <div class=\"item_num\">\r\n");
      out.write("            <strong>제품 번호</strong><br>\r\n");
      out.write("              <input type=\"text\" id=\"proNum\" name=\"proNum\" placeholder=\"제품 번호를 입력해주세요\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_gender\">\r\n");
      out.write("            <strong>성별</strong><br>\r\n");
      out.write("              <input type=\"radio\" id=\"gender\" name=\"gender\" value=\"M\">남자\r\n");
      out.write("              <input type=\"radio\" id=\"gender\" name=\"gender\" value=\"W\">여자\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_category\">\r\n");
      out.write("            <strong>카테고리</strong><br>\r\n");
      out.write("              <select id=\"category\" name=\"category\">\r\n");
      out.write("                <option value=\"탑&티셔츠</\">탑&티셔츠</option>\r\n");
      out.write("                <option value=\"후디&크루\">후디&크루</option>\r\n");
      out.write("                <option value=\"재킷&베스트\">재킷&베스트</option>\r\n");
      out.write("              </select>\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_type\">\r\n");
      out.write("            <strong>종류</strong><br>\r\n");
      out.write("              <select id=\"type\" name=\"type\">\r\n");
      out.write("                <option value=\"긴팔\">긴팔</option>\r\n");
      out.write("                <option value=\"반팔\">반팔</option>\r\n");
      out.write("                <option value=\"후디\">후디</option>\r\n");
      out.write("                <option value=\"폴로\">폴로</option>\r\n");
      out.write("                <option value=\"셔츠\">셔츠</option>\r\n");
      out.write("              </select>\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_name\">\r\n");
      out.write("            <strong>제품 이름</strong><br>\r\n");
      out.write("              <input type=\"text\" id=\"proName\" name=\"proName\" placeholder=\"제품 이름을 입력해주세요\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_size\">\r\n");
      out.write("            <strong>사이즈</strong><br>\r\n");
      out.write("              <select id=\"size\" name=\"size\">\r\n");
      out.write("                <option value=\"XS\">XS</option>\r\n");
      out.write("                <option value=\"X\">X</option>\r\n");
      out.write("                <option value=\"M\">M</option>\r\n");
      out.write("                <option value=\"L\">L</option>\r\n");
      out.write("                <option value=\"XL\">XL</option>\r\n");
      out.write("              </select>\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_color\">\r\n");
      out.write("            <strong>색상</strong><br>\r\n");
      out.write("              <input type=\"text\" id=\"color\" name=\"color\" placeholder=\"색상을 입력해주세요\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <br>\r\n");
      out.write("          <br>\r\n");
      out.write("          <div class=\"add_price\">\r\n");
      out.write("            <strong>가격</strong><br>\r\n");
      out.write("              <input type=\"text\" id=\"proPrice\" name=\"proPrice\" placeholder=\"제품의 가격을 입력해주세요\">\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div class=\"btn-w\">\r\n");
      out.write("          <input type=\"submit\" value=\"작성\" class=\"input-btn-w\" onClick=\"javascript: prevCheckTextBox();\" />\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <script>\r\n");
      out.write("  	function prevCheckTextBox() {\r\n");
      out.write("  		if (!$('#proNum').val()) {	\r\n");
      out.write("  			alert('제품 번호를 입력해주세요.');\r\n");
      out.write("  			$('#proNum').focus();	\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#proNum').val()) {	\r\n");
      out.write("  			alert('제품 번호를 입력해주세요.');\r\n");
      out.write("  			$('#proNum').focus();		\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#gender').val()) {	\r\n");
      out.write("  			alert('성별을 클릭해주세요.');\r\n");
      out.write("  			$('#gender').focus();	\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if ($('#category').val()) { 	\r\n");
      out.write("  			alert('카테고리를 선택해주세요.');\r\n");
      out.write("  			$('#category').focus();		\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#type').val()) {	\r\n");
      out.write("  			alert('유형을 선택해주세요.');\r\n");
      out.write("  			$('#type').focus();	\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#proName').val()) {\r\n");
      out.write("  			alert('제품 이름을 입력해주세요.');\r\n");
      out.write("  			$('#proName').focus();		\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#size').val()) {	\r\n");
      out.write("  			alert('사이즈를 선택해주세요.');\r\n");
      out.write("  			$('#size').focus();		\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#color').val()) {	\r\n");
      out.write("  			alert('색상을 입력해주세요.');\r\n");
      out.write("  			$('#color').focus();	\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  		if (!$('#proPrice').val()) {	\r\n");
      out.write("  			alert('제품의 가격을 입력해주세요.');\r\n");
      out.write("  			$('#proPrice').focus();		\r\n");
      out.write("  			\r\n");
      out.write("  			return;\r\n");
      out.write("  		}\r\n");
      out.write("  			\r\n");
      out.write("  		// 실제 form의 action의 값으로 전송\r\n");
      out.write(" 		document.getElementById('form1').submit();\r\n");
      out.write("  	}\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/header.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <footer>\r\n");
      out.write("  	<div>\r\n");
      out.write("			<div>이용약관 ·운영정책 ·청소년보호정책 ·위치정보이용약관 ·개인정보처리방침 ·웹접근성안내 ·고객센터</div>\r\n");
      out.write("			<div>Copyright &#169; SM Corp. All rights reserved.<span><img src=\"./image/logo.png\" alt=\"logo\"></span></div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
