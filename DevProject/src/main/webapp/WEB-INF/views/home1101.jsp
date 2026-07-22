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
	<h1>Home1101</h1>
	<c:redirect url="http://localhost:8080/list" />
	<p>서버에서 보내준 데이터 출력 ${serverTime}</p>
	<p>서버에서 보내준 데이터 출력 <c:out value="${serverTime}" /></p>
	
</body>
</html>