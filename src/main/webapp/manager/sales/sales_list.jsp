<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 결산</title>
<link rel="stylesheet" href="${path}/resources/css/manager/main.css">
<link rel="stylesheet" href="${path}/resources/css/manager/board_list.css">
<link rel="stylesheet" href="${path}/resources/css/manager/page.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/manager/common/header.jsp" %>
	<div id="container">
		<!-- 메뉴이름 -->
		<div id="title">
			<h1>결산</h1>
		</div>
		
		<div id="contents">
			<!-- 왼쪽 메뉴 -->
			<%@ include file="/manager/common/left_menu.jsp" %>
			<div id="section">
				<table>
					<tr>
						<th width="5%">번호</th>
						<th width="10%">날짜</th>
						<th width="10%">상품가격총합계</th>
						<th width="10%">배송비 합계</th>
					</tr>
					<c:forEach var="s" items="${slist}" varStatus="status">
						<tr>
							<td id="btn_td">
								<input type="button" name="btnDelete" value="삭제" onclick="deleteReview(${r.review_no})">
							</td>
						</tr>
					</c:forEach>
					<%-- 페이징 처리 --%>
					<tr>
						<td colspan="8" align="center" style="border-bottom: none;">
							<%-- 이전버튼 활성화 여부 --%>
							<c:if test="${paging.startPage > 10}">
								<a href="${path}/review_list.ad?pageNum=${paging.prev}">[이전]</a>
							</c:if>
							
							<%-- 페이지 번호 처리 --%>
							<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
								<%-- 현재 페이지 번호는 눌리지 않게 처리 --%>
								<c:if test="${num == paging.currentPage}">
									<span style="font-weight: bold;">${num}</span>
								</c:if>
								
								<c:if test="${num != paging.currentPage}">
									<a href="${path}/review_list.ad?pageNum=${num}">${num}</a>
								</c:if>
								
							</c:forEach>
							
							<%-- 다음버튼 활성화 여부 --%>
							<c:if test="${paging.endPage < paging.pageCount}">
								<a href="${path}/review_list.ad?pageNum=${paging.next}">[다음]</a>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>	
	<!-- footer -->
	<%@ include file="/manager/common/footer.jsp" %>
</body>
</html>