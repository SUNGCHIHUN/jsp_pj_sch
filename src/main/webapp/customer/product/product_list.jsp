<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
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
	<%@ include file="../../common/header.jsp" %>
<div id="container">
		<div id="section1">
			<h1> 전체 </h1>
		</div>	
		<div id="section2">
			<div class="search">
				<input type="search" placeholder="음료 이름을 입력해보세요!">
				<a href="#"><img src="${path}/resources/images/upload/search.png" alt="검색" onclick="location.href='product_search_action.html'"></a>
			</div>
			<div class="product">
				<c:forEach var="p_dto" items="${plist}">
					<ul>
						<li><a href="${path}/product_detail.do"><img src="${path}/resources/images/product/${p_dto.value.product_img_name}" alt="상품 이미지"></a></li>
						<li>${p_dto.value.product_name} </li>
						<li>${p_dto.value.product_price} 원</li>
						<li>리뷰 0</li>
					</ul>
				</c:forEach>
			</div>
		</div>
		<div id="page">
			<ul>
				<li><a href="#">◀</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">▶</a></li>
			</ul>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>