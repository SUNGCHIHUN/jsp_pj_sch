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
<script>
	setTotal();
	
	$(function() {
		$(".selectCustomerAddressBtn").click(function() {
			// 비동기로 고객 주소 가져오기
			$.ajax({
				type: "POST",
				url: "${path}/select_customer_address.do",
				success: function(result) {
					$(".delivery_info").html(result);
				},
				error: function(request, status, error) {
					console.log("code : " + request.readyState);
					console.log("code : " + error);
				}
			});
		});
		
		$("input[name='payment']").change(function() {
			$("input[name='payment']").each(function(i, o) {
				var checked = $(this).prop("checked");
				console.log("checked : " + checked);

				if (checked) {
					var value = $("input[name='payment']:checked").val();
					$("#payment").text(value);
				}
			});
		});
	});
	
	function setTotal() {
		$(function() {
			
			var totalPrice = 0;
			var deliveryPrice = 0;
			var finalTotalPrice = 0;
			
			$(".cart_info_td").each(function(index, element) {
					
				// 총 가격 계산
				totalPrice += (parseInt($(element).find(".product_price").val() *
							   parseInt($(element).find(".amount").val())));
				console.log(totalPrice);
				
			});
			
			// 배송비 결정
			if(totalPrice >= 100000) {
				deliveryPrice = 0;
				
			} else if(totalPrice == 0) {
				deliveryPrice = 0;
				
			} else {
				deliveryPrice = 3000;
			}
			
			// 무료배송까지 남은 금액
			freePrice = 100000 - totalPrice;
			if (freePrice < 0) freePrice = 0;
			
			// 최종 금액
			finalTotalPrice = totalPrice + deliveryPrice;
			
			// 값 대입
			// toLocaleString ==> 통화형식으로 출력 $ 원...
			$(".total_price").html(totalPrice.toLocaleString() + "원");
			$(".delivery_price").html(deliveryPrice.toLocaleString() + "원");
			$(".final_total_price").html("<span>" + finalTotalPrice.toLocaleString() + "원</span>");
			
		});
	}
</script>
<body>
<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<h1> 주문서 작성</h1>
		</div>	
		<form action="${path}/pay_action.do" method="post">
			<input type="hidden" name="slist" value="${slist}">
			<div id="section2">
				<div class="order_list">		
					<table style="text-align: center;">
						<tr>
							<td colspan="6" style="padding: 0; border: none; text-align: left;">
								<h2>주문 리스트</h2>
							</td>
						</tr>
						<tr>
							<th colspan="3" style="width:100px;">상품정보</th>
							<th>판매가</th>
							<th>수량</th>
							<th>합계</th>
						</tr>
						<%-- 장바구니에서 여러 종류의 상품을 구매하는 경우 --%>
						<c:if test="${slist != null}">
							<c:forEach var="shelf" items="${slist}">
								<tr>
									<td class="cart_info_td">
										<input type="hidden" class="product_price" value="${shelf.product_price}">
										<input type="hidden" class="amount" value="${shelf.amount}">
										<input type="hidden" class="total_price" value="${shelf.product_price * shelf.amount}">
										<input type="hidden" class="delivery_price" value="${shelf.amount}">
										<input type="hidden" class="final_total_price" value="${shelf.amount}">
									</td>
									<td style="width:100px;"><img src="${shelf.product_img_name}" alt="상품이미지"></td>
									<td style="width:200px;">${shelf.product_name}</td>
									<td>
										<fmt:formatNumber value="${shelf.product_price}" pattern="#,### 원" />
										
									</td>
									<td>${shelf.amount}</td>
									<td>
										<fmt:formatNumber value="${(shelf.product_price * shelf.amount) + param.delivery_price}" pattern="#,### 원" />
									</td>
								</tr>
							</c:forEach>		
						</c:if>
						
						<%-- 상품을 바로 구매하는 경우 --%>
						<c:if test="${p_dto != null}">
							<tr>
								
								<td style="width:100px;"><img src="${path}/resources/images/product/${p_dto.product_img_name}" alt="상품이미지"></td>
								<td style="width:200px;">${p_dto.product_name }</td>
								<td> 
									<fmt:formatNumber value="${p_dto.product_price}" pattern="#,### 원" />
								</td>
								<td>${param.amount}</td>
								<td>
									<fmt:formatNumber value="${(p_dto.product_price * param.amount) + param.delivery_price}" pattern="#,### 원" />
								</td>
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
							<th>받으시는 분 &nbsp; &nbsp; &nbsp; <input type="button" class="selectCustomerAddressBtn" value="본인"></th>
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
							<td><input type="text" class="inputMsg" name="msg" value="안전하게 와주세요.!"></td>
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
							<td style="border-right: 1px solid gray; text-align: center;" class="total_price"></td>
							<td style="border-right: 1px solid gray; text-align: center;" class="delivery_price"></td>
							<td class="final_total_price" style="text-align: center;"></td>

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
								<input type="radio" id="credit" name="payment" value="신용카드" checked>
								<label for="credit">신용카드</label>
								&nbsp; &nbsp; &nbsp;
								<input type="radio" id="account" name="payment" value="계좌이체">
								<label for="account">계좌이체</label>
								&nbsp; &nbsp; &nbsp;
								<input type="radio" id="toss" name="payment" value="토스">
								<label for="toss">토스</label>
							</td>
							<td style="text-align:center; width:200px; background-color: #DCDCDC;">
								<ul>
									<li style="padding-right:35px;"><span id="payment">신용카드</span> 최종결제 금액</li>
									<li style="padding-right:35px;" class="final_total_price" style="text-align: center;"></li>
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