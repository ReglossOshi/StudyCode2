<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link href="/resources/css/default/fullpage/jquery.fullpage.css" rel="stylesheet" />
<script src="/resources/js/default/fullpage/jquery.fullpage.js"></script>

<style>
    .rwd-table{
        margin:0;
        padding:0;
        text-align:left;
    }
    .containerdiv{
        display:flex;
        flex-direction:column;
        justify-content:center;
        align-items:center;
        padding:30px;
        border:1px solid rgba(0,0,0,0.18);
        background-color:white;
        border-radius:20px;
        width:80%;
        height:auto;
    }
    .containerGoods{
        display:flex;
        justify-content:center;
        margin:10px;
        height:auto;
    }

    .goodstitle{
        display:flex;
        justify-content:space-between;
        align-items:center;
        width:100%;
        margin-bottom:20px;
    }
    .name{
    }

    .goodsfooter{
        display:flex;
        justify-content:center;
        align-items:center;
        margin-top:50px;
    }
    .table-height{
        height:auto;
    }

    .goods-btn{
        width:100%;
        display:flex;
        justify-content:flex-end;
    }
    .goods-modal{
        height:500px;
    }
    .select-div{
        display:flex;
        justify-content:center;
        align-items:center;
    }
    .inputDivBox{
        margin:0;
        padding:0;
    }
</style>

<div class="fullpage">
    <div class="section">
        <div>
            <div class="containerGoods">
                <div class="containerdiv">
                    <div class="goodscontents">
                    <div class="goodstitle">
                        <h1>제품 관리</h1>
                        <div class="select-div">
                            <div class = "inputDivBox">
                            	<input class = "inputBox" type="text" required>
                            	<label class = "inputLabelTag">Name</label>
                            	<span class = "inputSpanTag"></span>
                            </div>
                            <button>검색</button>
                        </div>
                    </div>
                    <div class="table-height">
                                <table class="rwd-table">
                                            <tbody>
                                                <tr>
                                                    <th>제품 번호</th>
                                                    <th>제품 이름</th>
                                                    <th>제품 수량</th>
                                                    <th>제품 가격</th>
                                                    <th>제품 단위</th>
                                                </tr>

                                                <c:forEach items="${goodslist}" var="goods">
                                                    <tr>
                                                       <td><c:out value="${goods.finishedgoods_id}" /></td>
                                                       <td><c:out value="${goods.finishedgoods_name}" /></td>
                                                       <td><c:out value="${goods.finishedgoods_quantity}" /></td>
                                                       <td><c:out value="${goods.finishedgoods_price}" /></td>
                                                       <td><c:out value="${goods.quantity_units}" /></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                    </div>
                            <div class="goodsfooter">
                                <div class="pagination__wrapper">
                                    <ul class="pagination">
                                        <li class="pagelist"><button class="pagebtn prev">&#10094;</button></li><!--이전버튼-->

                                        <li class="pagelist">
                                            <button class="pagebtn pagenum active">1</button><!--현재 위치-->
                                        </li>
                                        <li class="pagelist">
                                            <button class="pagebtn pagenum">2</button>
                                        </li>
                                        <li class="pagelist">
                                            <button class="pagebtn pagenum">3</button>
                                        </li>

                                        <li class="pagelist"><button class="pagebtn next" title="next page">&#10095;</button></li><!--다음버튼-->
                                    </ul>
                                </div>
                            </div>
                    </div>
                    <div class="goods-btn">
                    <button class="btn btn-sm btn-info ml-2 mt-2 modalBtn" id="testModal">추가</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div>
            컨텐츠 작성
        </div>
    </div>
    <div class="section">
        <div>
            컨텐츠 작성
        </div>
    </div>
</div>

<!-- Modal 공간 -->
<div class="modal fade" id="modalArea" tabindex="-1" data-bs-backdrop = "static" aria-labelledby="modalArea" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5>제품 추가</h5>
            </div>
     <!-- Modal body -->
            <div class="modal-body">
                <div class="row">
                    <div class="goods-modal">

                    </div>
                </div>
            </div>
            <!-- Modal footer -->
            <div class="footer">
                <div class="float-right" style="text-align: right;">
                    <!-- 종료 버튼 -->
                    <!--
                        btn : [bootstrap] 부트 스트랩 버튼 사용
                        mr-2 : [bootstrap] margin right를 2만큼
                        bm-2 : [bootstrap] margin bottom을 2만큼
                    -->
                    <button type="button" class="btn mr-2 mb-2" id="closeBtn">닫기</button>
                </div>
            </div>
        </div>
    </div>
</div>



<script>
document.title="완제품 관리";
$(function() {
    var page = $('.fullpage').fullpage({

        // 1. 네비게이션 보이기
        navigation : true,

        // 2. 네비게이션 위치 지정
        navigationPosition : 'right',

        // 3. 각 섹션의 배경색상 지정 (6자의 핵사코드 작성가능)
        sectionsColor : ['pink', 'white', 'white'],
    });
})


let  pagenumer = document.querySelectorAll('.pagenum');
pagenumer.forEach((target) => target.addEventListener("click", function(){
    pagenumer.forEach((e)=>{
        e.classList.remove('active');
    })
        target.classList.add('active');
    })
);
</script>

<%@ include file="../includes/footer.jsp" %>

