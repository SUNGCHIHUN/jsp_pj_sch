<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지모 헤더</title>
<link href="<%=request.getContextPath() %>/resources/css/common/header.css" rel="stylesheet">
</head>
<body>
<div id="header">
	<nav class="menu_bar1">
		<ul class="menu1">
			<li><a href="<%=request.getContextPath() %>/main.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/logo.png" alt="로고"></a></li>
			<li><a href="<%=request.getContextPath() %>/product_list.do">상품보기</a></li>
			<li><a href="<%=request.getContextPath() %>/notice_list.do">공지사항</a></li>
			<li><a href="<%=request.getContextPath() %>/ask_list.do">문의사항</a></li>
		</ul>
		<ul class="menu2">
			<li><a href="<%=request.getContextPath() %>/customer_info.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/user-100.png" alt="프로필"></a></li>
			<li><a href="<%=request.getContextPath() %>/cart_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/basket-100.png" alt="장바구니"></a></li>
			<li><a href="<%=request.getContextPath() %>/login.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/login-100.png" alt="로그인"></a></li>
		</ul>
	</nav>
	<nav class="menu_bar2">
		<ul class="menu3">
			<li><a href="<%=request.getContextPath() %>/product_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/vending-machine-100.png" alt="전체"></a></li>
			<li><a href="<%=request.getContextPath() %>/product_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/energy-drink-100.png" alt="드링크"></a></li>
			<li><a href="<%=request.getContextPath() %>/product_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/cold-drink-100.png" alt="탄산"></a></li>
			<li><a href="<%=request.getContextPath() %>/product_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/sparkling-water-100.png" alt="생수"></a></li>
			<li><a href="<%=request.getContextPath() %>/product_list.do"><img src="<%=request.getContextPath() %>/resources/images/navImage/coffee-100.png" alt="커피"></a></li>
		</ul>
	</nav>
</div>
</body>
</html>