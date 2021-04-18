<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to our-site</title>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<%-- <%@ page include file="menu.jsp" %> --%>
	<jsp:include page="menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>Welcome to World Job Friends</h1>
		</div>
		<div class="mainimg">
			<img src="resources/images/friends.png">
			<p>
			<%
				Date day = new Date();
				int hour = day.getHours();
				int minute = day.getMinutes();
				
				
				String ct = hour + "시 " + minute + "분";
				
				out.println("현재 접속 시각 : " + ct);
				response.setIntHeader("Refresh", 60);
				// 5초에 한번씩 새로 고침
			%>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>