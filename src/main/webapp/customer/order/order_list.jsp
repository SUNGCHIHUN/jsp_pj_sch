<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 주문목록</title>
<link href="<%=request.getContextPath() %>/resources/css/common/page.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/customer/order.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<div class="section_menu">
				<ul>
					<li><a href="../info/customer_info.jsp">회원정보</a></li>
					<li><a href="../order/order_list.jsp"><b>주문내역</b></a></li>
				</ul>
			</div>
		</div>	
		<div id="section2">
			<h3 style="text-align:center;">주문리스트</h3>
			<div class="order_search">
				<table>
					<tr>
						<td>
							<ul>
								<li><input type="date" name="start_date"></li>
								<li><input type="date" name="end_date"></li>
								<li><input type="button" value="조회" class="selectBtn" onclick="alert('주문목록 기간별 조회')"></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<div class="order_list">
				<table>
					<tr>
						<th>
							주문일자
						</th>
						<th>이미지</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>상품구매금액</th>
						<th>주문처리상태</th>
						<th>환불</th>
					</tr>
					<tr>
						<td>
							2022-01-25
						</td>
						<td><a href="../product/product_detail.html"><img src="../../resources/images/product/hot6.png" alt="상품이미지"></a></td>
						<td>핫식스</td>
						<td>1</td>
						<td>20,000</td>
						<td>
							배송완료<br>
							<input type="button" value="조회" class="selectBtn" onclick="window.open('../../manager/delivery/delivery_detail.jsp', '_blank', 'width=650,height=600')">
						</td>
						<td>
							<input type="button" value="환불" class="refundBtn" onclick="refund()">
						</td>
					</tr>
					<tr>
						<td>
							2022-01-25
						</td>
						<td><a href="../product/product_detail.html"><img src="../../resources/images/product/monster.png" alt="상품이미지"></a></td>
						<td>몬스터에너지</td>
						<td>1</td>
						<td>30,000</td>
						<td>
							주문요청<br>
							<input type="button" value="취소" class="cancelBtn" onclick="orderCancel()">
						</td>
						<td></td>
					</tr>
				</table>
			</div>
			<div id="page">
			<ul>
				<li><a href="#">◀</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">▶</a></li>
			</ul>
		</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>