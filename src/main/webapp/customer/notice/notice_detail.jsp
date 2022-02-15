<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 공지사항</title>
<link href="../../resources/css/common/board2.css" rel="stylesheet">
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
						<th>제목 </th>
						<td>[공지] 홈페이지 리뉴얼 안내 (2022년 1월 22일부)</td>
						<td>조회수 : 747</td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<td>관리자</td>
						<td>2022-01-22</td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<p>
								보다 나은 서비스 제공을 위해 202년 01월 22일(토)부로 홈페이지를 개편하였습니다. (베타버전)<br>
								- 전체적인 기능은 동일하며 문의사항 게시판 추가<br>
								- 많은 이용바랍니다. 감사합니다.<br>
							</p>
						</td>
					</tr>
					
					<tr>
						<th>파일</th>
						<td colspan="2">
							file.txt <input type="button" value="다운로드" onclick="alert('파일 다운로드')">
						</td>
					</tr>
					
					<tr>
						<td colspan="3" style="text-align:left; padding-left:40px;"><a href="notice_list.jsp">목록</a></td>
					</tr>
				</table>
				
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>