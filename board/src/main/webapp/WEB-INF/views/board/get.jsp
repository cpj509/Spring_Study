<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(!${empty resMsg }){
		alert('${resMsg }');
	};
</script>
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
	<input type="button" onclick="location.href='edit?bno=${vo.bno}'" value="수정"/>
	<input type="button" onclick="confirm('정말 삭제 하시겠습니까?') ? location.href='delete?bno=${vo.bno}' : false" value="삭제"/>

</body>
</html>