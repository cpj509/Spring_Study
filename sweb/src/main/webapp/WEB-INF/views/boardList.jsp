<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<c:if test="${alert == 'update' }">
		<script type="text/javascript">
			alert("게시글이 수정되었습니다.");
			//location.href = "boardList.jsp";
		</script>
	</c:if>
	<jsp:include page="menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>게시판 목록</h1>
		</div>
		<table id="table3">
			<tr class="thead">
				<td>번호</td><td>글제목</td><td>작성자</td><td>등록일</td><td>조회수</td>
		    </tr>
		    <c:forEach var="board" items="${boardList}">
		    <tr>
		    	<td>${board.bnum}</td>
		    	<td><a href="boardView.do?bnum=${board.bnum}">${board.title}</a></td>
		    	<td>${board.memberId}</td>
		    	<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd hh:mm"/> </td>
		    	<td><fmt:formatNumber value="${board.hit}"/></td>
		    </tr>
		    </c:forEach>
		    <tr>
		    	<td colspan="5">
		    		<a href="boardWriteForm.do"><input type="submit" value="글쓰기"></a>
		    	</td>
		    </tr>
		</table>
	</div>
</body>
</html>