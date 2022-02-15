<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 공지사항</title>
<link href="../../resources/css/common/page.css" rel="stylesheet">
<link href="../../resources/css/common/board1.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> 공지사항 </h1>
			<hr>
			<div class="board">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>파일</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="../notice/notice_detail.jsp">[공지] 홈페이지 리뉴얼 안내 (2022년 1월 22일부)</a></td>
						<td><img src="#" alt="파일"></td>
						<td>관리자</td>
						<td>2022-01-22</td>
						<td>747</td>
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