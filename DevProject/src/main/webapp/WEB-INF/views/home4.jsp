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
	<h1>Home4</h1>
	<p>서버에서 보내준 데이터 출력 ${serverTime}</p>
	<h2>나의 취미를 배열로 출력합니다</h2>
	<c:forEach var="data" items="${hobbyArray}">
		<c:out value="${data}" />
		<hr>
	</c:forEach>

	<h2>나의 공부를 리스트로 출력합니다</h2>
	<c:forEach var="data" items="${list}">
		<c:out value="${data}" />
		<hr>
	</c:forEach>

	<h2>나의 공부를 맵으로 테이블화해서 출력합니다</h2>
	<table border="1">
		<tr>
			<td>\${map["data1"]}</td>
			<td>${map["data1"]}</td>
		</tr>
		<tr>
			<td>\${map["data2"]}</td>
			<td>${map["data2"]}</td>
		</tr>
		<tr>
			<td>\${map["data3"]}</td>
			<td>${map["data3"]}</td>
		</tr>
		<tr>
			<td>\${map["data4"]}</td>
			<td>${map["data4"]}</td>
		</tr>
		<tr>
			<td>\${empty map}</td>
			<td>${empty map}</td>
		</tr>
	</table>
	<hr>
	<h2>문자열 분리 방법: String tokenizer 방식</h2>
	<c:forTokens var="hobby" items="${hobbyString}" delims=",">
		<p>${hobby}</p>
	</c:forTokens>
	
	
</body>
</html>