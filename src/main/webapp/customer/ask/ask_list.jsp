<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 문의사항</title>
<link href="<%=request.getContextPath() %>/resources/css/common/page.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/common/board1.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> 문의사항 </h1>
			<hr>
			<div class="board">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>문의상태</th>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="<%=request.getContextPath() %>/ask_detail.do">회원가입은 어떻게 하는 건가요?</a></td>
						<td>홍길동</td>
						<td>2022-01-22</td>
						<td>답변대기</td>
					</tr>
					<tr align="center">
						<td colspan="5"><a href="<%=request.getContextPath() %>/ask_add.do">문의하기</a></td>
					</tr>
				</table>
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
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>