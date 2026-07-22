<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="false"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>AOP 게시판 에러 처리</title> 
</head> 
<body> 
	<h1>에러가 발생하였습니다.</h1>
 	<a href="/board/list">게시판리스트로 가기</a>
 	<p>${exception.toString()}</p>
</body> 
</html> 