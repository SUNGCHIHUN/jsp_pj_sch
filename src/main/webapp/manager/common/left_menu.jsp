<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>left_menu.jsp</title>
<link rel="stylesheet" href="${path}/resources/css/manager/left_menu.css">
</head>
<body>
	<div class="left_menu">
		<div class="title">
			<h2>관리자 메뉴</h2>
			<div class="line"></div>
		</div>
		<div class="menu">
			<ul>
				<li>재고관리</li>
				<li><a href="${path}/stock_list.st">상품목록</a></li>
				<li><a href="${path}/stock_add.st">상품등록</a></li>
			</ul>
			<ul>
				<li>주문관리</li>
				<li><a href="order_list.ad">주문</a></li>
				<li><a href="delivery_list.ad">배송</a></li>
				<li><a href="refund_list.ad">환불</a></li>
			</ul>
			<ul>
				<li>회원관리</li>
				<li><a href="customer_list.ad">회원목록</a></li>
			</ul>
			<ul>
				<li>게시판</li>
				<li><a href="${path}/board_list.do">공지사항</a></li>
				<li><a href="${path}/board_list.do">문의사항</a></li>
			</ul>
			<ul>
				<li>리뷰관리</li>
				<li><a href="#">리뷰</a></li>
			</ul>
			<ul>
				<li>매출관리</li>
				<li><a href="#">결산</a></li>
			</ul>
			<ul>
				<li>세션</li>
				<li><a href="${path}/logout_action.do">로그아웃</a></li>
			</ul>
		</div>
	</div>
</body>
</html>