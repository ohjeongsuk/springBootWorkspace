<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문제점이 발생했습니다. 빨리 조치를 취하도록 하겠습니다.!</h1>
	<a href="/board/list">게시판리스트로 가기</a>
	<p>${exception.toString()} </p> 
</body>
</html>