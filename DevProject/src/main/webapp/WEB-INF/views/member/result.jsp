<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Result Redirect 화면</h1>
	<p>userId = ${member.userId} </p>
	<p>password = ${member.password} </p>
<%-- 	<c:forEach  var="member" items="${list}">
	<p> userId = ${member.userId} </p>
	<p> password = ${member.password} </p>
	<p> email = ${member.email} </p>
	<hr>
	</c:forEach> --%>
</body>
</html>