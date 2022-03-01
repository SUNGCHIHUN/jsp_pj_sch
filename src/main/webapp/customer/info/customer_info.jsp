<%@page import="pj.mvc.jsp.dto.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<%@ page import="pj.mvc.jsp.dto.CustomerDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 회원정보</title>
<link href="${path}/resources/css/common/main.css" rel="stylesheet">
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/customer/customer_Info.css" rel="stylesheet">

<!-- 다음 우편번호 API 사용 -->
<script src="${path}/resources/js/zipcode.js" defer></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${path}/resources/js/customer/register.js" defer></script>

</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<div class="section_menu">
				<ul>
					<li><b><a href="${path}/customer_auth.do">회원정보</a></b></li>
					<li><a href="${path}/order_list.do">주문내역</a></li>
				</ul>
			</div>
		</div>	
		<div id="section2">
			<div class="right">
				<div class="customer_info">
					<form action="${path}/update_customer_action.do" method="post">
						<table>
							<tr>
								<th>아이디</th>
								<td><input type="text" class="inputBox" name="id" value="${dto.customer_id}" readonly></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" class="inputBox" name="password" value="${dto.customer_password}"></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" class="inputBox" name="name" value="${dto.customer_name}"></td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									<input type="text" id="zipcode" class="inputZipcode" name="zipcode" min=0 max=99999 value="${dto.zipcode}" readonly>
									<input type="button" value="우편번호" class="zipcodeBtn" onclick="setAddress();"><br>
									<input type="text" id="address1" class="inputBox" name="address1" value="zipcode 생성 예정" readonly><br>
									<input type="text" id="address2" class="inputBox" name="address2" value="${dto.customer_address}">
								</td>
							</tr>
							<tr>
								<th>핸드폰</th>
								<td>
									<c:set var="telArr" value="${fn:split(dto.customer_tel,'-')}" />
									<input type="text" class="inputTel" name="tel1" value="${telArr[0]}">
									-
									<input type="text" class="inputTel" name="tel2" value="${telArr[1]}">
									-
									<input type="text" class="inputTel" name="tel3" value="${telArr[2]}">
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>
									<%
										String[] email = ((CustomerDTO)request.getAttribute("dto")).getCustomer_email().split("@");
									%>
									<c:set var="emailArr" value="${fn:split(dto.customer_email, '@')}" />
									<input type="text" class="inputEmail" name="email1" value="${emailArr[0]}">
									@
									<input type="text" class="inputEmail" name="email2" value="${emailArr[1]}">
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
										<input type="submit" class="modifyBtn" value="회원정보수정">
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" class="dropBtn" value="탈퇴" onclick="deleteCustomer('${path}')">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>