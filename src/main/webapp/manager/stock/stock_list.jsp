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
						<th width="10%">주문일자</th>
						<th colspan="2" width="30%">상품정보</th>
						<th width="10%">상품가격</th>
						<th width="10%">상품수량</th>
						<th width="10%">주문자명</th>
						<th width="10%">주문상태</th>
						<th width="10%">관리</th>
					</tr>
					<tr>
						<td>1</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
						<td>3</td>
					</tr>
				</table>
				<ul class="page">
					<li>◀</li>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>▶</li>
				</ul>
			</div>
		</div>
	</div>	
	<!-- footer -->
	<%@ include file="/manager/common/footer.jsp" %>
</body>
</html>