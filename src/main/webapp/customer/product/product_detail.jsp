<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 상품상세</title>
<link href="<%=request.getContextPath() %>/resources/css/common/main.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/common/page.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/customer/product_detail.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/resources/js/customer/product_detail.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<h1> 드링크 </h1>
		</div>	
		
		<div id="section2">
			<div class="product_detail">
				<table>
					<tr>
						<td>
							<img src="<%=request.getContextPath() %>/resources/images/product/hot6.png" alt="상품 이미지">
						</td>
						<td>
							<ul>
								<li style="font-size:30px; font-weight:bold; color:blue;">치모</li>
								<li style="font-size:30px; font-weight:bold;">핫식스</li>
								<li style="padding:10px 0;">★ 5.0 1개의 리뷰</li>
								<li><hr></li>
								<li style="font-size:20px; font-weight:bold;">20,000원</li>
								<li><hr></li>
								<li><b>배송안내</b></li>
								<li>1월 25일(화) 도착 예정</li>
								<li><hr></li>
								<li style="text-align:center;">
									<input type="button" class="cartBtn" value="장바구니 담기" onclick="addCart()">
									<input type="button" class="buyBtn" value="구매하기" onclick="pay()">
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>

			<div class="review">
				<h1> 제품 리뷰</h1>
				<table>
					<tr>
						<th colspan="2" style="text-align:left; border-bottom: 1px solid black; padding-bottom: 5px;">REVIEW <b>(1)</b></th>
					</tr>
					<tr>
						<td colspan="2">
							<ul>
								<li style="font-size:40px; font-weight:bold; text-align:center;">★ 5.0</li>						
								<li style="text-align:center;"><a style="font-weight:bold;">100%</a>가 <a style="font-weight:bold;">'아주 좋아요'</a> 라고 평가했습니다. |					
								<a style="font-weight:bold;">0%</a>가 <a style="font-weight:bold;">'별로에요 '</a> 라고 평가했습니다.</li>						
							</ul>
						</td>

					</tr>				

					<tr>
						<td style="border-right: 1px dotted gray; width:80%;">
							<ul>
								<li><b>★★★★★ 아주 좋아요</b></li>
								<li style="padding:40px;">잠이 안와요!</li>
							</ul>
						</td>
						<td style="font-size:20px; text-align:center;"><b>홍길동</b><br>(2022-01-25)</td>
					</tr>
					
					<tr>
						<td style="border-right: 1px dotted gray; width:80%;">
							<ul>
								<li>
									<b>별점</b> &nbsp;
									<select name="star">
										<option value="star5">★★★★★</option>
										<option value="star4">★★★★☆</option>
										<option value="star3">★★★☆☆</option>
										<option value="star2">★★☆☆☆</option>
										<option value="star1">★☆☆☆☆</option>
									</select>
								</li>
								<li>
									<textarea name="review" cols="80" rows="8"></textarea>
								</li>
							</ul>
						</td>
						<td style="font-size:20px; text-align:center;"><b>홍길동</b><br>(2022-01-25)</td>
					</tr>
					
					<tr>
						<td colspan="2" style="text-align:center; border-bottom:none;"><input type="button" class="reviewBtn" value="상품 리뷰 작성하기" onclick="addReview()"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="../../common/footer.jsp" %>
</body>
</html>