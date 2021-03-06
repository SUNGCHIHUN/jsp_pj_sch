<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 상품보기</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/customer/product.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/header.jsp" %>
<div id="container">
		<div id="section1">
			<h1> ${ko_category} </h1>
		</div>	
		<div id="section2">
			<div class="search">
				<input type="search" placeholder="음료 이름을 입력해보세요!">
				<a href="#"><img src="${path}/resources/images/navImage/search-48.png" alt="검색" onclick="location.href='product_search_action.html'"></a>
			</div>
			<div class="product">
				<c:if test="${plist.isEmpty()}">
					<div class="discription">
						<h2>현재 상품이 존재하지 않습니다.</h2>
					</div>
				</c:if>
				<c:forEach var="p_dto" items="${plist}">
					<ul>
						<li><a href="${path}/product_detail.do?product_no=${p_dto.product_no}"><img src="${p_dto.product_img_name}" alt="상품 이미지" width="300px" height="300px;"></a></li>
						<li>${p_dto.product_name} </li>
						<li>${p_dto.product_price} 원</li>
						<li>리뷰 0</li>
					</ul>
				</c:forEach>
			</div>
		</div>
		<%-- 페이징 처리 --%>
		<div id="page">
			<%-- 이전버튼 활성화 여부 --%>
			<c:if test="${paging.startPage > 10}">
				<a href="${path}/product_list.do?pageNum=${paging.prev}">[이전]</a>
			</c:if>
			
			<%-- 페이지 번호 처리 --%>
			<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
				<%-- 현재 페이지 번호는 눌리지 않게 처리 --%>
				<c:if test="${num == paging.currentPage}">
					<span style="font-weight: bold;">${num}</span>
				</c:if>
				
				<c:if test="${num != paging.currentPage}">
					<a href="${path}/product_list.do?pageNum=${num}">${num}</a>
				</c:if>
			</c:forEach>
			
			<%-- 다음버튼 활성화 여부 --%>
			<c:if test="${paging.endPage < paging.pageCount}">
				<a href="${path}/product_list.do?pageNum=${paging.next}">[다음]</a>
			</c:if>
		</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>