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
				<form action="<%=request.getContextPath() %>/login_action.do" method="post">
					<table>
						<tr>
							<th colspan="2"><img src="<%=request.getContextPath() %>/resources/images/navImage/logo.png" alt="로고"></th>
						</tr>
						
						<tr>
							<th colspan="2" align="center" style="padding: 10px;">
							<% 	
								// 로그인 실패
								if ((Integer)request.getAttribute("loginResult") == 0) {
									out.print("아이디 또는 비밀번호가 일치하지 않습니다.");
								} else if((Integer)request.getAttribute("loginResult") == 2) {
									out.print("CIMO 스토어에 오신 것을 환영합니다!");
								}
							%>
							</th>
						</tr>
						<tr>
							<td colspan="2"><input type="text" class="inputId" name="id" placeholder="아이디" autofocus required></td>
						</tr>
						<tr>
							<td colspan="2"><input type="password" class="inputPassword" name="password" placeholder="비밀번호" required></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="loginBtn" value="로그인"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="button" class="registerBtn" value="회원가입" onclick="location.href='<%=request.getContextPath() %>/register.do'"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>