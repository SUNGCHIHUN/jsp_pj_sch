<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증</title>
<link href="${path}/resources/css/customer/customer_auth.css" rel="stylesheet">
<script src="${path}/resources/js/common/alert_error.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section1">
			<div class="section_menu">
				<ul>
					<li><a href="${path}/customer_auth.do"><b>회원정보</b></a></li>
					<li><a href="${path}/order_list.do">주문목록</a></li>
				</ul>
			</div>
		</div>	
		<div id="section2">
			
			<%-- 로그인을 하지 않은 경우 --%>
			<c:if test="${sessionId == ''}">
				<script>
					errorAlert(needLoginError);
					window.location="${path}/login.do";
				</script>
			</c:if>
			
			<%-- 로그인을 한 경우 --%>
			<c:if test="${sessionId != ''}">
				
				<%-- 인증을 한 적이 없는 경우 --%>
				<c:if test="${authResult == 0}">
					<div class="customer_auth">
						<form action="customer_auth_action.do" method="post">
							<table>
								<tr>
									<th colspan="2"><img src="${path}/resources/images/navImage/logo.png" alt="로고"></th>
								</tr>
								<tr>
									<th colspan="2">${sessionId}님의 비밀번호를 한번 더 입력해 주세요.</th>
								</tr>
								<tr>
									<td colspan="2"><input type="password" class="inputBox" name="password" autofocus required></td>
								</tr>
								<tr>						
									<td>
										<input type="submit" class="confirmBtn"value="확인">
										<input type="button" class="cancelBtn" value="취소" onclick="history.go(-1);">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</c:if>
		
				<%-- 인증을 한 적이 있는 경우 --%>
				<c:if test="${authResult != 0}">
					<c:redirect url="customer_info.do" />
				</c:if>
			</c:if>
		</div>
	</div>	
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>