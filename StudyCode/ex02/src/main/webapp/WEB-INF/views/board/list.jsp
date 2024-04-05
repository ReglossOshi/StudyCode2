<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="../includes/header.jsp" %>

<%--
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.memberVO.korName" var="name" />
</sec:authorize>
--%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%--<c:out value="${name}" />--%>님 환영합니다!</span>

                                <!--
                                <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                                -->
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/member">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <!--
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                -->
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </ul>
				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">게시판 목록<button  class='btn btn-primary' onclick="location.href='/board/register'" style="margin-left:20px;">등록</button></h1>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>#번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>수정일</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									    <c:forEach items="${boardList}" var="board">
											<tr>
												<td><a href='/board/get?bno=<c:out value="${board.bno}" />'><c:out value="${board.bno}" /></a></td>
												<td><c:out value="${board.title}" /></td>
												<td><c:out value="${board.writer}" /></td>
												<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
												<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
												<td><c:out value="${board.views}" /></td>
											</tr>
									    </c:forEach>
                                    </tbody>
								</table>

								<div style="display: flex; align-items: center; justify-content: center;">

                                    <div>
                                        <form id='searchForm' action='/' method='get'>
                                            <select name='type'>
                                                <option value="" <c:out value="${criteria.type == null?'selected':''}" />>--</option>
                                                <option value="T" <c:out value="${criteria.type eq 'T'?'selected':''}" />>제목</option>
                                                <option value="C" <c:out value="${criteria.type eq 'C'?'selected':''}" />>내용</option>
                                                <option value="W" <c:out value="${criteria.type eq 'W'?'selected':''}" />>작성자</option>
                                                <option value="TC" <c:out value="${criteria.type eq 'TC'?'selected':''}" />>제목 or 내용</option>
                                                <option value="CW" <c:out value="${criteria.type eq 'CW'?'selected':''}" />>내용 or 작성자</option>
                                                <option value="TW" <c:out value="${criteria.type eq 'TW'?'selected':''}" />>제목 or 작성자</option>
                                                <option value="TWC" <c:out value="${criteria.type eq 'TWC'?'selected':''}" />>제목 or 내용 or 작성자</option>
                                            </select>
                                            <input type='text' placeholder="검색" name='keyword' value='<c:out value="${criteria.keyword}" />'/>
                                            <button class='btn btn-primary'>Search</button>
                                        </form>
                                    </div>
                                </div>
							</div>
						</div>
					</div>

				</div>

			</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalLabel">Modal title</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
      </div>
      <div class="modal-body">처리가 완료되었습니다.</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

	$(document).ready(
		function() {
			var result = '<c:out value="${result}"/>';
			checkModal(result);
            history.replaceState({},null,null);



			function checkModal(result) {
				if (result === '' || history.state) {
					return;
				}

				if (parseInt(result) > 0) {
					$(".modal-body").html(
							"게시글 " + parseInt(result)
									+ " 번이 등록되었습니다.");
				}
                $("#myModal").modal("show");
			}
		}
	);
</script>

<%@ include file="../includes/footer.jsp" %>

