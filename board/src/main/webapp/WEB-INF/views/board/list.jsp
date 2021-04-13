<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: 10px auto;
		text-align: center;
		padding: 10px;
	}
	table, th, tr, td{
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>게시판</h1>
	<table>
		<tr style="background: #ccc">
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>regdate</th>
			<th>updatedate</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td><c:out value="${list.getBno() }"></c:out></td>
				<td><c:out value="${list.getTitle() }"></c:out></td>
				<td><c:out value="${list.getContent() }"></c:out></td>
				<td><c:out value="${list.getWriter() }"></c:out></td>
				<td><c:out value="${list.getRegdate() }"></c:out></td>
				<td><c:out value="${list.getUpdatedate() }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>