<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 문의 간편등록</title>
<link href="<%=request.getContextPath() %>/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<div id="section">
			<h1 align="center"> 문의사항 등록 </h1>
			<hr>
			<div class="board">
				<table style="width:600px;">
					<tr>
						<th> 제목 </th>
						<td colspan="2"><input type="text" class="inputTitle2"></td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<td>홍길동 </td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<textarea name="content" cols="66" rows="20"></textarea>
						</td>
					</tr>
					<tr style="text-decoration: none;">
						<td colspan="3">
							<a href="javascript:alert('등록되었습니다.')">등록</a> &nbsp;
							<a href="javascript:window.close();">취소</a>
						</td>	
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>