<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 로그인</title>
<link href="<%=request.getContextPath() %>/resources/css/common/login.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<div class="login">
				<form action="login.do" method="post">
					<table>
						<tr>
							<th><img src="<%=request.getContextPath() %>/resources/images/navImage/logo.png" alt="로고"></th>
						</tr>
						<tr>
							<td><input type="text" class="inputId" name="userId" placeholder="아이디" autofocus required></td>
						</tr>
						<tr>
							<td><input type="password" class="inputPassword" name="userPassword" placeholder="비밀번호" required></td>
						</tr>
						<tr>
							<td><input type="submit" class="loginBtn" value="로그인"></td>
						</tr>
						<tr>
							<td><input type="button" class="registerBtn" value="회원가입" onclick="location.href='<%=request.getContextPath() %>/register.do'"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>