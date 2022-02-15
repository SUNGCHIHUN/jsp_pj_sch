<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 Drink Store</title>
<link href="<%=request.getContextPath() %>/resources/css/common/main.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id="container">
		<div id="section">
			<div class="banner">
				<a href="<%=request.getContextPath() %>/manager/stock/stock_list.jsp"><h3>관리자 페이지</h3></a>
				<a href="<%=request.getContextPath() %>/customer/product/product_list.jsp"><img src="<%=request.getContextPath() %>/resources/images/mainImage/banner2.png" alt="배너 이미지"></a>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>