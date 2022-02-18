<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 문의상세</title>
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> 문의사항 </h1>
			<hr>
			<div class="board">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="2">회원가입은 어떻게 하는 건가요?</td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<td>홍길동</td>
						<td style="text-align: right;">2022-01-22</td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<br>
							회원가입을 하고 싶은데 어떻게 해야 좋을 지 모르겠습니다.
						</td>
					</tr>
					
					<tr>
						<th>답변</th>
						<td>회원가입 버튼을 누르고 가입하면 됩니다.</td>
						<td style="text-align: right;">
							<ul style="text-align: right;">
								<li>관리자</li>
								<li>(2022-01-25)</li>
							</ul>
						</td>
					</tr>

					<tr>
						<td><a href="${path}/ask_list.do">목록</a></td>
						<td colspan="2">
							<a href="${path}/ask_update.do">수정</a> &nbsp;
							<a href="${path}/ask_delete_action.do">삭제 </a>
						</td>
					</tr>
				</table>		
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>