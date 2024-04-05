<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp" %>
    <div class="col-lg-7">
        <div class="p-5">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">게시판 수정 페이지</h1>
            </div>
            <form role="form" action="/board/modify" method="post">
                <div class="form-group">
                    <label>Bno</label>
                    <input type="text" class="form-control" id="bno" name="bno" value='<c:out value="${board.bno}" />' readonly />
                </div>
                <div class="form-group">
                    <label>제목</label>
                    <input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title}" />'/>
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <textarea rows="5" class="form-control" id="content"  name="content" value='<c:out value="${board.content}" />'></textarea>
                </div>
                <div class="form-group">
                    <label>작성자</label>
                    <input type="text" class="form-control" id="writer"  name="writer" value='<c:out value="${board.writer}" />' readonly/>
                </div>

                <div class="form-group">
                    <label>작성일</label>
                    <input type="text" class="form-control" id="regdate" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" />' readonly/>
                </div>

                <button class="btn btn-primary" type="submit">
                    수정하기
                </button>
                <button class="btn btn-primary" type="submit" formaction="/board/remove" formmethod="post">
                    삭제하기
                </button>
                <button class="btn btn-default" type="button" onclick="location.href='/'">
                    목록
                </button>
            </form>
        </div>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>