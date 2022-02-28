<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 - 재고등록</title>
<link rel="stylesheet" href="${path}/resources/css/manager/main.css">
<link rel="stylesheet" href="${path}/resources/css/manager/stock_detail.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/manager/common/header.jsp" %>
	<div id="container">
		<!-- 메뉴이름 -->
		<div id="title">
			<h1>상품등록</h1>
		</div>
		
		<div id="contents">
		<!-- 왼쪽 메뉴 -->
		<%@ include file="/manager/common/left_menu.jsp" %>
			<!-- 오른쪽 컨텐츠 -->
			<div id="section">
				<form action="${path}/stock_add_action.st" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<th>상품명</th>
							<td><input type="text" class="inputBox" name="p_name"></td>
						</tr>
						<tr>
							<th>카테고리</th>
							<td>
								<select class="category" name="p_category">
									<option value="">없음</option>
									<option value="energy">드링크</option>
									<option value="carbon">탄산</option>
									<option value="water">생수</option>
									<option value="coffee">커피</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>상품가격</th>
							<td><input type="number" class="inputBox" name="p_price"></td>
						</tr>
						<tr>
							<th>상품수량</th>
							<td><input type="number" class="inputBox" name="p_amount"></td>
						</tr>
						<tr>
							<th>상품이미지</th>
							<td><input type="file" name="p_file" accept="image/*"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="insertBtn" value="등록">
								<input type="button" class="cancelBtn" value="취소" onclick="history.go(-1);">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>	
	<!-- footer -->
	<%@ include file="/manager/common/footer.jsp" %>
</body>
</html>