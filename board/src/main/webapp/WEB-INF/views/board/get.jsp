<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>제목</td><td>${vo.title }</td>
		</tr>
		<tr>
			<td>내용</td><td>${vo.content }	</td>		
		</tr>
		<tr>
			<td>작성자</td><td>${vo.writer }</td>
		</tr>
	</table>
</body>
</html>