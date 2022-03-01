<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 장바구니</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/customer/cart.css" rel="stylesheet">
<script>

	setTotal();
	
	function setTotal() {
		$(function() {
			
			var totalPrice = 0;
			var freePrice = 0;
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
			$(".free_price").html(freePrice.toLocaleString() + "원");
			$(".progress_price").attr("value", totalPrice);
			$(".delivery_price").html(deliveryPrice.toLocaleString() + "원");
			$(".final_total_price").html(finalTotalPrice.toLocaleString() + "원");
			
		});
	}
	
	// 수정 버튼
	function modifyAmount(shelf_no) {
		var amount = $("#amount"+ shelf_no).val();
		location.href="${path}/cart_update_action.do?shelf_no="+ shelf_no +"&amount=" + amount;
		setTotal();
	}
	
	// 삭제 버튼
	function deleteCartItem(shelf_no) {
		location.href="${path}/cart_delete_action.do?shelf_no=" + shelf_no;
		setTotal();
	}
	
	// 전체 삭제 버튼
	function deleteCartAll() {
		location.href="${path}/cart_delete_all_action.do";
		setTotal();
	}
	
</script>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<h1 style="padding: 20px 0;"> 장바구니에 들어 있는 제품입니다.</h1>
		</div>
		<div id="section2">
			<form name="cart_list" action="${path}/pay.do" method="post" onsubmit="pay();">
				<input type="hidden" name="buy_state" value="2"> 
				<div class="cart_list">
					<table>
						<tr>
							<td colspan="8" style="border: none;">
								<ul>
									<li style="text-align:left; font-size:20px; font-weight:bold;">무료배송까지 남은 금액은 <span class="free_price"></span> 입니다.</li>
									<li><progress class="progress_price" value="${shelf.product_price * shelf.amount}" max=100000></progress></li>
								</ul>
							</td>
						</tr>
						<tr>
							<th><input type="checkbox" class="cart_all_check" name="cart_box1" checked></th>
							<th colspan="2">상품정보</th>
							<th>판매가</th>
							<th>수량</th>
							<th>합계</th>
							<th>선택</th>
						</tr>
						<c:set var="total" value="0" />
						<c:forEach var="shelf" items="${slist}" varStatus="status">
							<tr>
								<td class="cart_info_td">
									<input type="checkbox" name="cart_box2" checked>
									<input type="hidden" class="shelf_no" value="${shelf.shelf_no}">
									<input type="hidden" class="customer_id" value="${shelf.customer_id}">
									<input type="hidden" class="product_img_name" value="${shelf.product_img_name}">
									<input type="hidden" class="product_name" value="${shelf.product_name}">
									<input type="hidden" class="product_price" value="${shelf.product_price}">
									<input type="hidden" class="amount" value="${shelf.amount}">
									<input type="hidden" class="total_price" value="${shelf.product_price * shelf.amount}">
									<input type="hidden" class="delivery_price" value="${shelf.amount}">
									<input type="hidden" class="final_total_price" value="${shelf.amount}">
								</td>
								<td><img src="${shelf.product_img_name}" alt="상품이미지"></td>
								<td>${shelf.product_name}</td>
								<td>
									<fmt:formatNumber value="${shelf.product_price}" pattern="#,### 원" />
								</td>
								<td>
									<ul style="margin-right: 30px;">
										<li><input type="number" id="amount${shelf.shelf_no}" class="inputAmount" value="${shelf.amount}" min=0 max=9999></li>
										<li>
											<input type="button" id="modifyBtn" class="modifyBtn" value="변경" onclick="modifyAmount('${shelf.shelf_no}');">
										</li>
									</ul>
								</td>
								<td>
									<fmt:formatNumber value="${shelf.product_price * shelf.amount}" pattern="#,### 원" />
								</td>
								<td><input type="button" id="deleteBtn" class="deleteBtn" value="삭제" onclick="deleteCartItem('${shelf.shelf_no}');"></td>
							</tr>
							
							
						</c:forEach>
						<%-- 장바구니에 상품이 있는 경우에만 전체삭제 버튼 표시 --%>
						<c:if test="${slist.size() != 0}">
							<tr>
								<td colspan="7" style="text-align: right; padding-right: 10px; border-bottom: none;">
									<input type="button" id="deleteAllBtn" class="deleteBtn" value="전체삭제" onclick="deleteCartAll();">
								</td>
							</tr>
						</c:if>
						<%-- 장바구니에 상품이 없는 경우 메세지 출력 --%>
						<c:if test="${slist.size() == 0}">
							<tr>
								<td colspan="7" style="height: 200px;">장바구니에 담긴 상품이 없습니다.</td>
							</tr>
						</c:if>
							
					</table>
				</div>
				<div class="cart_total">
					<table>
						<tr>
							<th style="border-right: 1px solid gray;">총 상품금액</th>
							<th style="border-right: 1px solid gray;">배송비</th>
							<th>결제예정금액</th>
						</tr>
						<tr>
							<td style="border-right: 1px solid gray;" class="total_price"></td>
							<td style="border-right: 1px solid gray;" class="delivery_price"></td>
							<td class="final_total_price"></td>
						</tr>
						<%-- 장바구니에 상품이 있는 경우만 결제하기 버튼 표시 --%>
						<c:if test="${slist.size() != 0}">
							<tr>
								<td colspan="3" style="border-bottom: none; padding-top: 50px;">
									<input type="submit" id="payBtn" class="payBtn" value="결제하기">
								</td>
							</tr>
						</c:if>
					</table>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>