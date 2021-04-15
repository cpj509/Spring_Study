<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="bno" value="${vo.bno }"/>
	<form action="register" method="post">
		<table border="1">
			<tr>
				<td>제목</td><td><input type="text" name="title" value="${vo.title }"/></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="content">${vo.content }</textarea>	</td>		
			</tr>
			<tr>
				<td>작성자</td><td><input type="text" name="writer" value="${vo.writer }"/></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
</body>
</html>