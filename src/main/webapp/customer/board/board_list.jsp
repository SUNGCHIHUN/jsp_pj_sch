<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ko_category}</title>
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/common/board1.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> ${ko_category} </h1>
			<hr>
			<div class="board">	
				<table>
					<caption style="padding-bottom: 10px;">${blist.size()}건</caption>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>파일</th>
						<th>작성자</th>
						<th>등록일</th>
						<%-- 공지사항인 경우 조회수 표시 --%>
						<c:if test="${ko_category == '공지사항'}">
							<th>조회수</th>							
						</c:if>
						<%-- 문의사항인 경우 답변상태 표시 --%>
						<c:if test="${ko_category == '문의사항'}">
							<th>문의상태</th>
						</c:if>
					</tr>
					<c:forEach var="board" items="${blist}" varStatus="status">
						<%-- 게시글이 없으면 --%>
						<c:if test="${blist.isEmpty()}">
							<tr>
								<td colspan="6">
									<div class="discription">
										<h2>현재 게시글이 존재하지 않습니다.</h2>
									</div>
								</td>
							</tr>
						</c:if>
						<tr>
							<td>${status.count}</td>
							<td><a href="${path}/board_detail.do?board_no=${board.value.board_no}">${board.value.board_title}</a></td>
							<td><img src="#" alt="파일"></td>
							<td>${board.value.board_writer}</td>
							<td>${board.value.board_regist_day}</td>
							<%-- 공지사항인 경우 조회수 표시 --%>
							<c:if test="${board.value.board_category == 'notice'}">
								<td>${board.value.board_hits}</td>							
							</c:if>
							<%-- 문의사항인 경우 문의상태 표시 --%>
							<c:if test="${board.value.board_category == 'ask'}">
								<td>${board.value.board_state}</td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<td width="10%"></td>
						<td colspan="4" width="80%" style="border-bottom: none;">
							<div id="page">
								<ul>
									<li><a href="#">◀</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">▶</a></li>
								</ul>
							</div>
						</td>
						<td width="10%">
							<%-- 문의사항에서 세션이 존재하면 --%>
							<c:if test="${ko_category == '문의사항'}">
								<div class="addBtn">
									<input type="button" value="등록" onclick="window.location='board_add.do?board_category=${board_category}&ko_category=${ko_category}'">
								</div>
							</c:if>
						</td>
					</tr>
					
					
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>