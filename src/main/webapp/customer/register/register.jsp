<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 회원가입</title>
<link href="<%=request.getContextPath() %>/resources/css/common/header.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/common/footer.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/common/main.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/customer/register.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/resources/js/customer/register.js" defer ></script>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<div class="register">
				<form action="<%=request.getContextPath() %>/register_action.do" name="register_form" method="post" onsubmit="return registerCheck()">
					<input type="hidden" name="hiddenIdCheck" value=0>
					<table>
						<tr>
							<th colspan="2"><img src="<%=request.getContextPath() %>/resources/images/navImage/logo.png" alt="로고"></th>
						</tr>
						<tr>
							<th> 아이디 </th>
							<td>
								<!-- 중복체크 완료 후 아이디 값을 변경하는 경우 다시 중복체크 안한 상태로 설정하기 위한 onkeydown="inputIdCheck()" -->
								<input type="text" class="inputBox" name="id" placeholder="아이디" autofocus onkeydown="inputIdCheck()">
								<input type="button" class="idCheckBtn" name="idCheckBtn" value="중복확인" onclick="idCheck();">
							</td>
						</tr>
						<tr>
							<th> 비밀번호 </th>
							<td><input type="password" class="inputBox" name="password" placeholder="비밀번호"></td>
						</tr>
						<tr>
							<th> 비밀번호 확인 </th>
							<td><input type="password" class="inputBox" name="rePassword" placeholder="비밀번호 확인"></td>
						</tr>
						<tr>
							<th> 이름 </th>
							<td><input type="text" class="inputBox" name="name" placeholder="이름"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<input type="number" id="zipcode" class="inputZipcode" name="zipcode" min=0 max=99999 value="63309" disabled>
								&nbsp; <input type="button" value="우편번호" onclick="setAddress();"><br>
								<input type="text" id="address1" class="inputBox" name="address1" value="제주특별자치도 제주시 아라동 첨단로 242" disabled><br>
								<input type="text" id="address2" class="inputBox" name="address2" value="스페이스닷원">
							</td>
						</tr>
						<tr>
							<th> 생년월일 </th>
							<td><input type="date" class="inputBox" name="birthday"></td>
						</tr>
						<tr>
							<th> 핸드폰 </th>
							<td>
								<input type="text" class="inputTel" name="tel1"> -
								<input type="text" class="inputTel" name="tel2"> -
								<input type="text" class="inputTel" name="tel3">								
							</td>
						</tr>
						<tr>
							<th> 이메일 </th>
							<td>
								<input type="text" class="inputEmail" name="email1"> @
								<input type="text" class="inputEmail" name="email2">
								<select name="email3" class="selectBox" onchange="selectEmail()">
									<option value="0">직접입력</option>
									<option value="naver.com">네이버</option>
									<option value="gmail.com">구글</option>
									<option value="hanmail.net">다음</option>
									<option value="nate.com">네이트</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td colspan="2">
								<input type="submit" class="registerBtn" value="회원가입">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>