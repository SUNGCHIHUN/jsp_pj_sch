<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 결제하기</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/customer/pay.css" rel="stylesheet">
</head>

<!-- 다음 우편번호 API 사용 -->
<script src="${path}/resources/js/zipcode.js" defer></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<body>
<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<h1> 주문서 작성</h1>
		</div>	
		<form action="${path}/pay_action.do" method="post">	
			<div id="section2">
				<div class="order_list">		
					<table style="text-align: center;">
						<tr>
							<td colspan="6" style="padding: 0; border: none; text-align: left;">
								<h2>주문 리스트</h2>
							</td>
						</tr>
						<tr>
							<th colspan="2" style="width:100px;">상품정보</th>
							<th>판매가</th>
							<th>수량</th>
							<th>배송비</th>
							<th>합계</th>
						</tr>
						<%-- 장바구니에서 여러 종류의 상품을 구매하는 경우 --%>
						<c:if test="${p_dto == null}">
							<c:forEach var="p_dto" items="${shelf}">
								<tr>
									<td style="width:100px;"><img src="${path}/resources/images/product/${p_dto.product_img_name}" alt="상품이미지"></td>
									<td style="width:200px;">${p_dto.product_name }</td>
									<td>${p_dto.product_price}</td>
									<td>${param.amount}</td>
									<td>${param.delivery_price} 원</td>
									<td>${(p_dto.product_price * param.amount) + param.delivery_price} 원</td>
								</tr>
							</c:forEach>		
						</c:if>
						
						<%-- 상품을 바로 구매하는 경우 --%>
						<c:if test="${p_dto != null}">
							<tr>
								<td style="width:100px;"><img src="${path}/resources/images/product/${p_dto.product_img_name}" alt="상품이미지"></td>
								<td style="width:200px;">${p_dto.product_name }</td>
								<td>${p_dto.product_price} 원</td>
								<td>${param.amount}</td>
								<td>${param.delivery_price} 원</td>
								<td>${(p_dto.product_price * param.amount) + param.delivery_price} 원</td>
							</tr>
						</c:if>
						
					</table>
				</div>
				<div class="delivery_info">
					<table>
						<tr>
							<td style="padding: 0; border: none; text-align: left;">
								<h2>배송지 정보</h2>
							</td>
						</tr>
						<tr>
							<th>받으시는 분 &nbsp; &nbsp; &nbsp; <input type="button" value="본인" onclick="getMyInfo();"></th>
							<td><input type="text" class="inputOrder" name="order"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<input type="text" class="inputZipcode" id="zipcode" name="zipcode" readonly> 
								<input type="button" value="우편번호" class="zipcodeBtn" onclick="setAddress();"><br>
								<input type="text" class="inputAddress" id="address1" name="address1" readonly><br><br>
								<input type="text" class="inputAddress" id="address2" name="address2">
							</td>
						</tr>
						<tr>
							<th>핸드폰</th>
							<td>
								<input type="text" class="inputTel" name="tel1"> - 
								<input type="text" class="inputTel" name="tel2"> - 
								<input type="text" class="inputTel" name="tel3">
							</td>
						</tr>
						<tr>
							<th>배송메시지</th>
							<td><input type="text" class="inputMsg" name="msg"></td>
						</tr>
					</table>
				</div>
				<div class="order_total" style="text-align:center;">
					<table>
						<tr>
							<td style="padding: 0; border: none; text-align: left;">
								<h2>결제예정금액</h2>
							</td>
						</tr>
						<tr>
							<th style="border-right: 1px solid gray;">총 주문금액</th>
							<th style="border-right: 1px solid gray;">배송비</th>
							<th>결제예정금액</th>
						</tr>
						<tr>
							<td style="border-right: 1px solid gray; font-size:30px; font-weight: lighter;">
								${p_dto.product_price * param.amount} 원
							</td>
							<td style="border-right: 1px solid gray; font-size:30px; font-weight: lighter;">
								${param.delivery_price} 원
							</td>
							<td style="font-size:30px; font-weight: lighter; color:blue;">
								${(p_dto.product_price * param.amount) + param.delivery_price} 원
							</td>
						</tr>
					</table>
				</div>
				<div class="payment">
					<table>
						<tr>
							<td style="padding: 0; border: none; text-align: left;">
								<h2>결제 수단</h2>
							</td>
						</tr>
						<tr>
							<td style="text-align:center; font-size: 20px;">
								<input type="radio" id="credit" name="payment" checked>
								<label for="credit">신용카드</label>
								&nbsp; &nbsp; &nbsp;
								<input type="radio" id="account" name="payment">
								<label for="account">계좌이체</label>
								&nbsp; &nbsp; &nbsp;
								<input type="radio" id="toss" name="payment">
								<label for="toss">토스</label>
							</td>
							<td style="text-align:center; width:200px; background-color: #DCDCDC;">
								<ul>
									<li style="padding-right:35px;">신용카드 최종결제 금액</li>
									<li style="padding-right:35px;"><span>56,000원</span></li>
									<li style="padding-right:35px;">
										<input type="submit" class="payBtn" value="결제하기">
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>