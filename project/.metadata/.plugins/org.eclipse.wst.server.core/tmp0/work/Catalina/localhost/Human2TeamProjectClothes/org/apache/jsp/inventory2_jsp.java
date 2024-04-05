/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-03-08 00:34:06 UTC
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

public final class inventory2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1709707807062L));
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1709707807070L));
    _jspx_dependants.put("/login_header.jsp", Long.valueOf(1709707807068L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/inventory.css\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./image/favicon.ico\" />\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		request.setCharacterEncoding("UTF-8");
		String currentPage=request.getParameter("pagenum");
		String itemName = request.getParameter("itemName");
		String itemCategory = request.getParameter("itemCategory");
		String itemdivision = request.getParameter("itemdivision");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		if(currentPage==null){
			currentPage="1";
		}
		if(itemName==null){
			itemName="";
		}
		if(itemCategory==null){
			itemCategory="";
		}
		
		if(itemdivision==null){
			itemdivision="";
		}
		
		if(itemdivision.equals("all")){
			itemdivision="";
			System.out.println(itemdivision);
		} else if(itemdivision.equals("store")){
			itemdivision="입고";
			System.out.println(itemdivision);
		} else if(itemdivision.equals("release")){
			itemdivision="출고";
			System.out.println(itemdivision);
		}
		if(start==null){
			start="";
		}
		if(end==null){
			end="";
		}

		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		//페이징 변수
		int totalCount=0;
		int pageCount=5;
		int limit=10;
		int totalPage=0;
		int pageGroup=0;
		int firstNumber=0;
		int lastNumber=0;
		int row = 0;
		int lastpageGroup=0;
		int next=0;
		int prev=0;
		
		try{
			conn=DBConfig.getConnection();
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"container\">\r\n");
      out.write("    ");
      out.write('\r');
      out.write('\n');

    // 로그인 여부 확인
    if (session.getAttribute("id") == null) {
        response.sendRedirect("index.jsp"); // 로그인 페이지로 이동
    }

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/header.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<header>\r\n");
      out.write("		<div class=\"logo\">\r\n");
      out.write("			<a href=\"main.jsp\" class=\"logodiv\">\r\n");
      out.write("				<img src=\"image/icons.png\" alt=\"icon\">\r\n");
      out.write("				<div class=\"logoname\">의류 생산 관리</div>\r\n");
      out.write("			</a>\r\n");
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
      out.write("		<ul class=\"menu\">\r\n");
      out.write("			<li class=\"list\">\r\n");
      out.write("			<a>");
      out.print(session.getAttribute("id"));
      out.write("님, 환영합니다.</a>\r\n");
      out.write("			<ul class=\"submenu\">\r\n");
      out.write("				<li class=\"list\"><a href=\"manageredit.jsp\">회원정보</a></li>\r\n");
      out.write("				<li class=\"list\"><a href=\"logout.jsp\">로그아웃</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("        <div id=\"content\">\r\n");
      out.write("            <div id=\"top\">\r\n");
      out.write("                <form action=\"inventory2.jsp\" id=\"searchForm\" method=\"get\">\r\n");
      out.write("                    <div id=\"search\">\r\n");
      out.write("                        <select class=\"selectClass\" id=\"selectId\" onchange=\"tagSelect()\">\r\n");
      out.write("                            <option disabled>==선택==</option>\r\n");
      out.write("                      		<option>현재고</option>\r\n");
      out.write("                            <option selected>기간별재고</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <input type=\"text\" name=\"itemName\" class=\"textInput\" id=\"selectItemName\" placeholder=\"제품명 입력\" value=\"");
      out.print(itemName);
      out.write("\">\r\n");
      out.write("                        <input type=\"submit\" value=\"검색\" id=\"submitbtn\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                  	<div id=\"category2\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><label for=\"\" class=\"labelText\">카테고리</label><input type=\"text\" name=\"itemCategory\" class=\"textInput\" id=\"itemCategory\" placeholder=\"카테고리 입력\" value=\"");
      out.print(itemCategory);
      out.write("\"></li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                           		<label for=\"\" class=\"labelText\" style=\"margin-left: 20px\">구분</label>\r\n");
      out.write("                           		");

                           			if(itemdivision.equals("")){
                           				
      out.write("\r\n");
      out.write("                           				<label for=\"\">전체</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"all\" checked>\r\n");
      out.write("		                           		<label for=\"\">입고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"store\">\r\n");
      out.write("		                           		<label for=\"\">출고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"release\">\r\n");
      out.write("                           				");

                           			}else if(itemdivision.equals("입고")){
                           				
      out.write("\r\n");
      out.write("                           				<label for=\"\">전체</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"all\">\r\n");
      out.write("		                           		<label for=\"\">입고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"store\" checked>\r\n");
      out.write("		                           		<label for=\"\">출고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"release\">\r\n");
      out.write("                           				");

                           			}else if(itemdivision.equals("출고")){
                           				
      out.write("\r\n");
      out.write("                           				<label for=\"\">전체</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"all\">\r\n");
      out.write("		                           		<label for=\"\">입고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"store\">\r\n");
      out.write("		                           		<label for=\"\">출고</label>\r\n");
      out.write("		                           		<input type=\"radio\" name=\"itemdivision\" value=\"release\" checked>\r\n");
      out.write("                           				");

                           			}
                           		
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <ul style=\"margin-top: 20px\">\r\n");
      out.write("                        	<li>\r\n");
      out.write("                        		<label for=\"\" class=\"labelText\">기준날짜(시작)</label>\r\n");
      out.write("                        		<input type=\"text\" name=\"start\" class=\"textInput\" id=\"start\" placeholder=\"날짜 입력\" value=\"");
      out.print(start);
      out.write("\">\r\n");
      out.write("                        		<input type=\"date\" class=\"date\" id=\"startDate\" onchange=\"startDateMethod()\">\r\n");
      out.write("                        	</li>\r\n");
      out.write("                        	<li>\r\n");
      out.write("                        		<label for=\"\" class=\"labelText\">기준날짜(종료)</label>\r\n");
      out.write("                        		<input type=\"text\" name=\"end\" class=\"textInput\" id=\"end\" placeholder=\"날짜 입력\" value=\"");
      out.print(end);
      out.write("\">\r\n");
      out.write("                        		<input type=\"date\" class=\"date\" id=\"endDate\" onchange=\"endDateMethod()\">\r\n");
      out.write("                        	</li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            ");

            	String sql ="";
                        				
                if(start=="" && end==""){
              		sql ="SELECT (SELECT COUNT(*) "+
              				"FROM IMPORT i, PRODUCTS p "+ 
              				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%') "+
              				"+(SELECT COUNT(*) "+
              				"FROM EXPORT e, PRODUCTS p "+ 
              				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%') A "+
              				"FROM DUAL";
              	}else if(start!="" && end!=""){
              		sql ="SELECT (SELECT COUNT(*) "+
              				"FROM IMPORT i, PRODUCTS p "+ 
              				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' AND i.IMPORT_DATE BETWEEN '"+start+"' AND '"+end+"') "+
              				"+(SELECT COUNT(*) "+
              				"FROM EXPORT e, PRODUCTS p "+ 
              				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' AND E.EXPORT_DATE BETWEEN '"+start+"' AND '"+end+"') A "+
              				"FROM DUAL";
              	}else if(start=="" && end!=""){
              		sql ="SELECT (SELECT COUNT(*) "+
              				"FROM IMPORT i, PRODUCTS p "+ 
              				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' AND i.IMPORT_DATE <= '"+end+"') "+
              				"+(SELECT COUNT(*) "+
              				"FROM EXPORT e, PRODUCTS p "+ 
              				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' AND E.EXPORT_DATE <= '"+end+"') A "+
              				"FROM DUAL";
              	}else if(start!="" && end==""){
              		sql ="SELECT (SELECT COUNT(*) "+
              				"FROM IMPORT i, PRODUCTS p "+ 
              				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' AND i.IMPORT_DATE >= '"+start+"') "+
              				"+(SELECT COUNT(*) "+
              				"FROM EXPORT e, PRODUCTS p "+ 
              				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
              				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' AND E.EXPORT_DATE >= '"+start+"') A "+
              				"FROM DUAL";
               	}
            	pstmt = conn.prepareStatement(sql);
      			rs=pstmt.executeQuery();
     			
      			if(rs.next()){
     				totalCount+=rs.getInt(1);
     			}
      			
      			totalPage = (int)(totalCount/limit);
            	if(totalCount%limit>0){
            		totalPage+=1;
            	}
            
	            if(totalPage<Integer.parseInt(currentPage)){
					currentPage=Integer.toString(totalPage);
				}
	            pageGroup=Integer.valueOf(currentPage)/pageCount;

				if(pageGroup==0){
					pageGroup++;
				}
				
				lastNumber = pageGroup*pageCount;

				if(lastNumber>totalPage){
					lastNumber=totalPage;
				}

				firstNumber = lastNumber-(pageCount-1);
				
				next = lastNumber+1;
				prev = firstNumber-1;
				
				if(firstNumber<=0){
					firstNumber=1;
					prev=1;
				}
				
				int count=Integer.parseInt(currentPage)-1;
				
				row=limit*count;
            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"bottom\">\r\n");
      out.write("                <div id=\"title\">\r\n");
      out.write("                    <p>기간별 재고 현황</p>\r\n");
      out.write("                </div>\r\n");
      out.write("              	<div id=\"subject\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"category\" style=\"width: 10%\">일자</li>\r\n");
      out.write("                        <li class=\"category\" style=\"width: 5%\">구분</li>\r\n");
      out.write("                        <li class=\"size\" style=\"width: 10%\">제품번호</li>\r\n");
      out.write("                        <li class=\"itemnum\" style=\"width: 15%\">카테고리</li>\r\n");
      out.write("                        <li class=\"itemname\" style=\"width: 50%\">제품명</li>\r\n");
      out.write("                        <li class=\"count\" style=\"width: 10%\">수량</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("               		");

               		if(start=="" && end==""){
                  		sql ="(SELECT TO_CHAR(i.IMPORT_DATE,'yyyy-mm-dd') i_date,i.DIVISION, i.ITEM_NUM,p.CATEGORY ,p.ITEM_NAME ,i.IMPORT_QUANTITY  "+
                  				"FROM IMPORT i, PRODUCTS p "+ 
                  				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
                  				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%') "+
                  				"UNION ALL"+
                  				"(SELECT TO_CHAR(E.EXPORT_DATE,'YYYY-MM-DD') E_DATE, E.DIVISION, E.ITEM_NUM, P.CATEGORY, P.ITEM_NAME, E.EXPORT_QUANTITY   "+
                  				"FROM EXPORT e, PRODUCTS p "+
                  				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
                  						"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%') "+
                  				"OFFSET "+row+" ROWS FETCH NEXT "+limit+" ROW ONLY";
                  	} else if(start!="" && end!=""){
                  		sql ="(SELECT TO_CHAR(i.IMPORT_DATE,'yyyy-mm-dd') i_date,i.DIVISION, i.ITEM_NUM,p.CATEGORY ,p.ITEM_NAME ,i.IMPORT_QUANTITY  "+
                  				"FROM IMPORT i, PRODUCTS p "+ 
                  				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
                  				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' "+
                  				"AND I.IMPORT_DATE BETWEEN '"+start+"' AND '"+end+"') "+
                  				"UNION ALL"+
                  				"(SELECT TO_CHAR(E.EXPORT_DATE,'YYYY-MM-DD') E_DATE, E.DIVISION, E.ITEM_NUM, P.CATEGORY, P.ITEM_NAME, E.EXPORT_QUANTITY   "+
                  				"FROM EXPORT e, PRODUCTS p "+
                  				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
                  						"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' "+
                  						"AND E.EXPORT_DATE BETWEEN '"+start+"' AND '"+end+"') "+
                  						"OFFSET "+row+" ROWS FETCH NEXT "+limit+" ROW ONLY";
                  	} else if(start=="" && end!=""){
                  		sql ="(SELECT TO_CHAR(i.IMPORT_DATE,'yyyy-mm-dd') i_date,i.DIVISION, i.ITEM_NUM,p.CATEGORY ,p.ITEM_NAME ,i.IMPORT_QUANTITY  "+
                  				"FROM IMPORT i, PRODUCTS p "+ 
                  				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
                  				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' "+
                  				"AND I.IMPORT_DATE <= '"+end+"') "+
                  				"UNION ALL"+
                  				"(SELECT TO_CHAR(E.EXPORT_DATE,'YYYY-MM-DD') E_DATE, E.DIVISION, E.ITEM_NUM, P.CATEGORY, P.ITEM_NAME, E.EXPORT_QUANTITY   "+
                  				"FROM EXPORT e, PRODUCTS p "+
                  				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
                  						"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' "+
                  						"AND E.EXPORT_DATE <= '"+end+"') "+
                  						"OFFSET "+row+" ROWS FETCH NEXT "+limit+" ROW ONLY";
                  	} else if(start!="" && end==""){
                  		sql ="(SELECT TO_CHAR(i.IMPORT_DATE,'yyyy-mm-dd') i_date,i.DIVISION, i.ITEM_NUM,p.CATEGORY ,p.ITEM_NAME ,i.IMPORT_QUANTITY  "+
                  				"FROM IMPORT i, PRODUCTS p "+ 
                  				"WHERE i.ITEM_NUM =p.ITEM_NUM "+
                  				"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND I.DIVISION LIKE '%"+itemdivision+"%' "+
                  				"AND I.IMPORT_DATE >= '"+start+"') "+
                  				"UNION ALL"+
                  				"(SELECT TO_CHAR(E.EXPORT_DATE,'YYYY-MM-DD') E_DATE, E.DIVISION, E.ITEM_NUM, P.CATEGORY, P.ITEM_NAME, E.EXPORT_QUANTITY   "+
                  				"FROM EXPORT e, PRODUCTS p "+
                  				"WHERE E.ITEM_NUM =P.ITEM_NUM "+
                  						"AND P.ITEM_NAME LIKE '%"+itemName+"%' AND P.CATEGORY LIKE '%"+itemCategory+"%' AND E.DIVISION LIKE '%"+itemdivision+"%' "+
                  						"AND E.EXPORT_DATE >= '"+start+"') "+
                  						"OFFSET "+row+" ROWS FETCH NEXT "+limit+" ROW ONLY";
                   	}
               		
               		pstmt = conn.prepareStatement(sql);
      				rs=pstmt.executeQuery();
      				while(rs.next()){
      					
      out.write("\r\n");
      out.write("      					<ul>\r\n");
      out.write("	                        <li class=\"category\" style=\"width: 10%\">");
      out.print(rs.getString(1));
      out.write("</li>\r\n");
      out.write("	                        <li class=\"category\" style=\"width: 5%\">");
      out.print(rs.getString(2));
      out.write("</li>\r\n");
      out.write("	                        <li class=\"size\" style=\"width: 10%\">");
      out.print(rs.getString(3));
      out.write("</li>\r\n");
      out.write("	                        <li class=\"itemnum\" style=\"width: 15%\">");
      out.print(rs.getString(4));
      out.write("</li>\r\n");
      out.write("	                        <li class=\"itemname\" style=\"width: 50%\">");
      out.print(rs.getString(5));
      out.write("</li>\r\n");
      out.write("	                        <li class=\"count\" style=\"width: 10%\">");
      out.print(rs.getInt(6));
      out.write("</li>\r\n");
      out.write("	                    </ul>\r\n");
      out.write("      					");

      				}
       				
      out.write("\r\n");
      out.write("       			</div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"page\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                    	");

                           	if(pageGroup!=1){
                           		
      out.write("\r\n");
      out.write("                           		<li>\r\n");
      out.write("		                      		<a class=\"pageNum pagebtn\" href=\"inventory2.jsp?itemName=");
      out.print(itemName);
      out.write("&itemCategory=");
      out.print(itemCategory);
      out.write("&pagenum=");
      out.print(prev);
      out.write("\">이전</a>\r\n");
      out.write("		                      	</li> \r\n");
      out.write("                           		");

                           	}
                        
      out.write("  \r\n");
      out.write("                    	                       \r\n");
      out.write("                        ");

                        for(int i=firstNumber;i<=lastNumber;i++){
                    		if (i == Integer.parseInt(currentPage)) { 
                           		
      out.write("\r\n");
      out.write("                           		<li>\r\n");
      out.write("                        			<a class=\"pageNum\" style=\"background-color: #8785A2; color: white;\" href=\"inventory2.jsp?itemName=");
      out.print(itemName);
      out.write("&itemCategory=");
      out.print(itemCategory);
      out.write("&pagenum=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\r\n");
      out.write("                        		</li>\r\n");
      out.write("                           		");

                            } else{
                            	
      out.write("\r\n");
      out.write("                                <li>\r\n");
      out.write("                        			<a class=\"pageNum\" href=\"inventory2.jsp?itemName=");
      out.print(itemName);
      out.write("&itemCategory=");
      out.print(itemCategory);
      out.write("&itemdivision=");
      out.print(itemdivision);
      out.write("&start=");
      out.print(start);
      out.write("&end=");
      out.print(end);
      out.write("&pagenum=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\r\n");
      out.write("                        		</li>		\r\n");
      out.write("                                ");

                            }
                    	}
                        
      out.write("  \r\n");
      out.write("                         \r\n");
      out.write("                       	");

                           	if(pageGroup!=lastpageGroup && pageGroup!=1){
                           		
      out.write("\r\n");
      out.write("                           		<li>\r\n");
      out.write("		                       		<a class=\"pageNum pagebtn\" href=\"inventory2.jsp?itemName=");
      out.print(itemName);
      out.write("&itemCategory=");
      out.print(itemCategory);
      out.write("&pagenum=");
      out.print(next);
      out.write("\">다음</a>\r\n");
      out.write("		                       	</li>\r\n");
      out.write("                           		");

                           	}
                        
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
 
					}catch(Exception e){
						
					}
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("     ");
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
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("	    function startDateMethod(){\r\n");
      out.write("			var dateControl = document.getElementById(\"startDate\").value;\r\n");
      out.write("			var itemDate = document.getElementById(\"start\").value=dateControl;\r\n");
      out.write("		}\r\n");
      out.write("	    function endDateMethod(){\r\n");
      out.write("			var dateControl = document.getElementById(\"endDate\").value;\r\n");
      out.write("			var itemDate = document.getElementById(\"end\").value=dateControl;\r\n");
      out.write("		}\r\n");
      out.write("    \r\n");
      out.write("    	function tagSelect() {\r\n");
      out.write("    		var opt = document.getElementById(\"selectId\");\r\n");
      out.write("            var optVal = opt.options[opt.selectedIndex].text;\r\n");
      out.write("            if(optVal==\"현재고\"){\r\n");
      out.write("            	location.href='inventory.jsp';\r\n");
      out.write("            } else if(optVal==\"기간별재고\"){\r\n");
      out.write("            	location.href='inventory2.jsp';\r\n");
      out.write("            }\r\n");
      out.write("		}\r\n");
      out.write("    </script>\r\n");
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
