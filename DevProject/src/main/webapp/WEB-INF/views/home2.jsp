<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World 2</h1>
	<p>서버에서 보내준 데이터 출력 ${serverTime}</p>
	<p>서버에서 보내준 데이터 출력 <c:out value="${serverTime}" /></p>
	<p>
		member.userId :	<c:out value="${member.userId}" />
	</p>
	<p>member.password : ${member.password}.</p>
	<p>member.userName : ${member.userName}.</p>
	<p>member.email : ${member.email}.</p>
	<p>member.dateOfBirth : ${member.dateOfBirth}.</p>
</body>
</html>