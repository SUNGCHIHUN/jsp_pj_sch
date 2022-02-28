<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 - 재고목록</title>
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
			<h1>상품목록</h1>
		</div>
		
		<div id="contents">
			<!-- 왼쪽 메뉴 -->
			<%@ include file="/manager/common/left_menu.jsp" %>
			<div id="section">
				<table>
					<tr>
						<th width="10%">번호</th>
						<th colspan="2" width="30%">상품정보</th>
						<th width="10%">상품가격</th>
						<th width="10%">상품수량</th>
						<th width="10%">카테고리</th>
						<th width="10%">상태</th>
						<th width="10%">관리</th>
					</tr>
					<c:forEach var="p" items="${plist}" >
						<tr>
							<td>${p.product_no}</td>
							<td><img src="${p.product_img_name}" alt="상품이미지" width="80px" height="80px"></td>
							<td>${p.product_name}</td>
							<td>${p.product_price}</td>
							<td>${p.product_amount}</td>
							<td>
								<c:choose>
									<c:when test="${p.product_category eq 'energy'}">드링크</c:when>
									<c:when test="${p.product_category eq 'carbon'}">탄산</c:when>
									<c:when test="${p.product_category eq 'water'}">생수</c:when>
									<c:when test="${p.product_category eq 'coffee'}">커피</c:when>
									<c:otherwise> 없음</c:otherwise>
								</c:choose>
							</td>
							<td>*작업필요*</td>
							<td>
								<input type="button" value="수정"> 
								<input type="button" value="삭제">
							</td>
						</tr>
					</c:forEach>
					<%-- 페이징 처리 --%>
					<tr>
						<td colspan="8" align="center" style="border-bottom: none;">
							<%-- 이전버튼 활성화 여부 --%>
							<c:if test="${paging.startPage > 10}">
								<a href="${path}/stock_list.st?pageNum=${paging.prev}">[이전]</a>
							</c:if>
							
							<%-- 페이지 번호 처리 --%>
							<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
								<%-- 현재 페이지 번호는 눌리지 않게 처리 --%>
								<c:if test="${num == paging.currentPage}">
									<span style="font-weight: bold;">${num}</span>
								</c:if>
								
								<c:if test="${num != paging.currentPage}">
									<a href="${path}/stock_list.st?pageNum=${num}">${num}</a>
								</c:if>
								
							</c:forEach>
							
							<%-- 다음버튼 활성화 여부 --%>
							<c:if test="${paging.endPage < paging.pageCount}">
								<a href="${path}/stock_list.st?pageNum=${paging.next}">[다음]</a>
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