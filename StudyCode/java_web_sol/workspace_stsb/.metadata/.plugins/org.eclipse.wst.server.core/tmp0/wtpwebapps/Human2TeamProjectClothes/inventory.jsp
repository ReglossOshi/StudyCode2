<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/rest.css">
    <link rel="stylesheet" href="css/inventory.css">
    <link rel="icon" href="image/icons.png">
    <!-- 구글 아이콘 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <title>의류 생산 관리</title>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="container">
        <div class="content">
            <div class="search">
                <div class="sort">
                    <input type="text" name="" id="searchtext" class="searchdiv" placeholder="검색어 입력">
                    <button id="searchbtn" class="searchdiv"><span class="material-symbols-outlined">search</span></button>
                    <select name="" id="searchdiv" class="searchdiv">
                        <option value="">제품명</option>
                        <option value="">종류</option>
                        <option value="">제품명+종류</option>
                        <option value="">입고일자</option>
                        <option value="">출고일자</option>
                    </select>
                </div>
            </div>
            <table class="detail">
                <tr>
                    <th class="det num">No.</th>
                    <th class="det">종류</th>
                    <th class="det">사이즈</th>
                    <th class="det product">제품명</th>
                    <th class="det">최초입고일자</th>
                    <th class="det">최근출고일자</th>
                    <th class="det quantity">입고 수량</th>
                    <th class="det quantity">출고 수량</th>
                    <th class="det quantity">현 재고량</th>
                </tr>
                <tr>
                    <td class="det num">1</td>
                    <td class="det">셔츠</td>
                    <td class="det">S</td>
                    <td class="det product">이상한이름의 긴 상의</td>
                    <td class="det tradeDate">2024-12-15</td>
                    <td class="det tradeDate">2025-12-16</td>
                    <td class="det quantity">100개</td>
                    <td class="det quantity">50개</td>
                    <td class="det quantity">50개</td>
                </tr>
            </table>
            <div class="page">
                <ul>
                    <li><a href="#" class="btn pagebtn">이전</a></li>
                    <li><a href="#" class="pagebtn" style="background-color: #40A2D8; color: #F0EDCF;">1</a></li>
                    <li><a href="#" class="pagebtn">2</a></li>
                    <li><a href="#" class="btn pagebtn">다음</a></li>
                </ul>
            </div>
        </div>   
    </div>
</body>
</html>