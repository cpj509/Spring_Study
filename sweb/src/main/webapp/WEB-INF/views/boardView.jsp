<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 양식</title>
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="resources/js/check.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>글 상세 보기</h1>
		</div>
		<div>
			<form action="boardUpdate.do?bnum=${board.bnum}" method="post">
				<table id="table3">
					<tr>
					    <td>글 제목</td>
						<td><input name="title" type="text" value="${board.title }" /></td>
					</tr>
					<tr>
					    <td>작성자</td>
						<td>${board.memberId }</td>
					</tr>
					<tr>
					    <td>글 내용</td>
						<td><textarea name="content">${board.content}</textarea></td>
					</tr>
					<tr>
					    <td>등록일</td>
						<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd hh:mm"/> </td>
					</tr>
					<tr>
					    <td>조회수</td>
						<td><fmt:formatNumber value="${board.hit}"/></td>
					</tr>		
					<tr>
						<td colspan="2">
							<a href="boardList.do"><input type="button" value="목록"></a>
							<c:if test="${sessionId eq board.memberId}">	
								<input type="submit" value="수정">
								<a onclick="return confirm('정말로 삭제하시겠습니까?')"
								   href="boardDelete.do?bnum=${board.bnum}">
								   <input type="button" value="삭제">
								</a>
							</c:if>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>