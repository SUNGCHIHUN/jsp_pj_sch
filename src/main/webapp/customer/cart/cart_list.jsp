<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 장바구니</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/customer/cart.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<h1 style="padding: 20px 0;"> 장바구니에 들어 있는 제품입니다.</h1>
		</div>	
		<div id="section2">
			<div class="cart_list">
				<table>
					<tr>
						<td colspan="8" style="border: none;">
							<ul>
								<li style="text-align:left; font-size:20px; font-weight:bold;">무료배송까지 남은 금액은 50,000원</li>
								<li><progress value="50000" max=100000></progress></li>
							</ul>
						</td>
					</tr>
					<tr>
						<th><input type="checkbox" name="cart"></th>
						<th colspan="2">상품정보</th>
						<th>판매가</th>
						<th>수량</th>
						<th>배송비</th>
						<th>합계</th>
						<th>선택</th>
					</tr>
					<tr>
						<td><input type="checkbox" name="cart"></td>
						<td><img src="${path}/resources/images/product/hot6.png" alt="상품이미지"></td>
						<td>핫식스</td>
						<td>20,000원</td>
						<td>
							<ul>
								<li><input type="number" value="1" min=0 max=99></li>
								<li><input type="button" class="modifyBtn" value="변경" onclick="updateAmount()"></li>
							</ul>
						</td>
						<td>3,000원</td>
						<td>23,000원</td>
						<td><input type="button" class="deleteBtn" value="삭제" onclick="deleteCartItem()"></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="cart"></td>
						<td><img src="${path}/resources/images/product/monster.png" alt="상품이미지"></td>
						<td>몬스터에너지</td>
						<td>30,000원</td>
						<td>
							<ul>
								<li><input type="number" value="1" min=0 max=99></li>
								<li><input type="button" class="modifyBtn" value="변경" onclick="updateAmount()"></li>
							</ul>
						</td>
						<td>3,000원</td>
						<td>33,000원</td>
						<td><input type="button" class="deleteBtn" value="삭제" onclick="deleteCartItem()"></td>
					</tr>
				</table>
			</div>
			<div class="cart_total">
				<table>
					<tr>
						<th style="border-right: 1px solid gray;">총 상품금액</th>
						<th style="border-right: 1px solid gray;">총 배송비</th>
						<th>결제예정금액</th>
					</tr>
					<tr>
						<td style="border-right: 1px solid gray;">50,000원</td>
						<td style="border-right: 1px solid gray;">6,000원</td>
						<td>56,000원</td>
					</tr>
					<tr>
						<td colspan="3" style="border-bottom: none; padding-top: 50px;">
							<input type="button" class="payBtn" value="결제하기" onclick="payList()">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>