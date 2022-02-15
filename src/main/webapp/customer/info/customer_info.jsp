<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 회원정보</title>
<link href="../../resources/css/common/main.css" rel="stylesheet">
<link href="../../resources/css/common/page.css" rel="stylesheet">
<link href="../../resources/css/customer/customerInfo.css" rel="stylesheet">

<!-- 다음 우편번호 API 사용 -->
<script src="../../resources/js/zipcode.js" defer></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<div class="section_menu">
				<ul>
					<li><a href="../info/customer_info.jsp"><b>회원정보</b></a></li>
					<li><a href="../order/order_list.jsp">주문목록</a></li>
				</ul>
			</div>
		</div>	
		<div id="section2">
			<div class="right">
				<div class="customer_info">
					<table>
						<tr>
							<th>아이디</th>
							<td><input type="text" class="inputBox" name="id" value="hong" readonly></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" class="inputBox" name="password" value="hong1234"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" class="inputBox" name="name" value="홍길동"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<input type="number" id="zipcode" class="inputZipcode" name="zipcode" min=0 max=99999 value="63309" disabled>
								<input type="button" value="우편번호" onclick="setAddress();"><br>
								<input type="text" id="address1" class="inputBox" name="address1" value="제주특별자치도 제주시 아라동 첨단로 242" disabled><br>
								<input type="text" id="address2" class="inputBox" name="address2" value="스페이스닷원">
							</td>
						</tr>
						<tr>
							<th>핸드폰</th>
							<td>
								<input type="number" class="inputTel" name="tel1" value="010">
								-
								<input type="number" class="inputTel" name="tel2" value="1111">
								-
								<input type="number" class="inputTel" name="tel3" value="2222">
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" class="inputEmail" name="email1" value="hgd">
								@
								<input type="text" class="inputEmail" name="email1" value="gmail.com">
								<select name="email3" class="selectBox">
									<option selected>직접입력</option>
									<option value="gmail.com">구글</option>
									<option value="naver.com">네이버</option>
									<option value="hanmail.net">다음</option>
									<option value="nate.com">네이트</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div align="center">
									<input type="button" class="modifyBtn" value="회원정보수정" onclick="updateCustomer()'">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" class="dropBtn" value="탈퇴" onclick="deleteCustomer()">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>