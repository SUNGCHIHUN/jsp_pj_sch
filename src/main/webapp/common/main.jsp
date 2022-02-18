<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 Drink Store</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id="container">
		<div id="section">
			<div class="banner">
				<a href="${path}/stock_list.ad"><h3>관리자 페이지</h3></a>
				<a href="${path}/product_list.do"><img src="${path}/resources/images/mainImage/banner2.png" alt="배너 이미지"></a>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>