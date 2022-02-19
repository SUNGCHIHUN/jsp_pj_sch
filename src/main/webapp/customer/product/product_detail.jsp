<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 상품상세</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/customer/product_detail.css" rel="stylesheet">

<script src="${path}/resources/js/customer/product_detail.js"></script>
</head>
<body>
	<div id="top"></div>
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
							<img src="${path}/resources/images/product/${p_dto.product_img_name}" alt="상품 이미지">
						</td>
						<td>
							<ul>
								<li style="font-size:30px; font-weight:bold; color:blue;">치모</li>
								<li style="font-size:30px; font-weight:bold;">${p_dto.product_name}</li>
								<li style="padding:10px 0;">
									★ 5.0 <a href="#reivew"><b style="font-size: 25px;">${rlist.size()}</b></a>개의 리뷰
								</li>
								<li><hr></li>
								<li style="font-size:20px; font-weight:bold;">
									${p_dto.product_price}원
								</li>
								<li><hr></li>
								<li><b>배송안내</b></li>
								<li>1월 25일(화) 도착 예정</li>
								<li><hr></li>
								<li>
									수량선택 <input type="number" class="inputAmount" value="1"> 개
								</li>
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
				<h1 id="reivew"> 제품 리뷰</h1>
				<table>
					<tr>
						<th colspan="2" style="text-align: left; border-bottom: 1px solid black; padding-bottom: 5px;">
							REVIEW <b>(${rlist.size()})</b>
						</th>
					</tr>
					<tr>
						<td colspan="2">
							<ul>
								<li style="font-size:40px; font-weight:bold; text-align:center;">
									★ 5.0
								</li>					
								<li style="text-align: left;">
									<a style="font-weight:bold;">100%</a>가 <a style="font-weight:bold;">'아주 좋아요'</a> 라고 평가했습니다.
								</li>				
								<li style="text-align: left;">
									<a style="font-weight:bold;">0%</a>가 <a style="font-weight:bold;">'좋아요.'</a> 라고 평가했습니다.
								</li>				
								<li style="text-align: left;">
									<a style="font-weight:bold;">0%</a>가 <a style="font-weight:bold;">'보통이에요.'</a> 라고 평가했습니다.
								</li>				
								<li style="text-align: left;">
									<a style="font-weight:bold;">0%</a>가 <a style="font-weight:bold;">'그저 그래요'</a> 라고 평가했습니다.
								</li>				
								<li style="text-align: left;">
									<a style="font-weight:bold;">0%</a>가 <a style="font-weight:bold;">'별로에요 '</a> 라고 평가했습니다.
								</li>						
							</ul>
						</td>

					</tr>	
								
					<c:forEach var="review" items="${rlist}">
						<tr>
							<td style="border-right: 1px dotted gray; width:80%;">
								<ul>
									<li>
										<b>
											<c:choose>
												<c:when test="${review.value.review_star == 1}">★☆☆☆☆ 별로에요.</c:when>
												<c:when test="${review.value.review_star == 2}">★★☆☆☆ 그저 그래요.</c:when>
												<c:when test="${review.value.review_star == 3}">★★★☆☆ 보통이에요.</c:when>
												<c:when test="${review.value.review_star == 4}">★★★★☆ 좋아요.</c:when>
												<c:when test="${review.value.review_star == 5}">★★★★★ 아주 좋아요.</c:when>
												<c:otherwise>???</c:otherwise>
											</c:choose>
										</b>
									</li>
									<li style="padding:40px;">${review.value.review_contents}</li>
								</ul>
							</td>
							<td style="font-size:20px; text-align:center;">
								<b>${review.value.review_writer}</b>님<br>${review.value.review_regist_day}<br>
								<%-- 로그인한 고객과 리뷰 작성자가 동일하면 --%>
								<c:if test="${sessionId == review.value.customer_id}">
									<input type="button" value="삭제" onclick="window.location='${path}/review_delete_action.do?review_no=${review.key}&product_no=${p_dto.product_no}'">
								</c:if>
							</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td style="border-right: 1px dotted gray; width:80%;">
							<form action="${path}/review_add_action.do?product_no=${param.product_no}" method="post">
								<ul>
									<li>
										<b>별점</b> &nbsp;
										<select name="star">
											<option value="5">★★★★★</option>
											<option value="4">★★★★☆</option>
											<option value="3">★★★☆☆</option>
											<option value="2">★★☆☆☆</option>
											<option value="1">★☆☆☆☆</option>
										</select>
									</li>
									<li>
										<textarea name="review" cols="80" rows="8"></textarea>
									</li>
									<%-- 세션이 있으면 상품 리뷰 작성하기 버튼 생성 --%>
									<c:if test="${sessionId != ''}">
										<li style="text-align: right;">
											<input type="submit" class="reviewBtn" value="상품 리뷰 작성하기">
										</li>
									</c:if>
								</ul>
							</form>
						</td>
						
						<td style="font-size:20px; text-align:center;">
							<%-- 로그인한 경우 --%>
							<c:if test="${sessionId == ''}">
								<b><input type="button" class="registerBtn" value="로그인하기" onclick="window.location='${path}/login.do'"></b><br>
							</c:if>
							<c:if test="${sessionId != ''}">
								<b>${sessionName}</b>님
							</c:if>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" style="text-align:center; border-bottom:none;">
							<div id="page">
								<ul>
									<li><a href="#">◀</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">▶</a></li>
								</ul>
							</div>
						</td>
					</tr>
					<tr>
						<th colspan="2" style="text-align: right; padding: 50px; font-size: 20px;"><a href="#top">맨위로</a></th>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="../../common/footer.jsp" %>
</body>
</html>