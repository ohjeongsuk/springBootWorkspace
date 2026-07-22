<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 등록 : 로그인한 회원만 접근 가능</h3>
		<p>
			principal :
			<sec:authentication property="principal" />
		</p>
		<p>
			Member :
			<sec:authentication property="principal.member" />
		</p>
		<p>
			사용자이름 :
			<sec:authentication property="principal.member.userName" />
		</p>
		<p>
			사용자아이디 :
			<sec:authentication property="principal.username" />
		</p>
		<p>
			사용자 권한 리스트 :
			<sec:authentication property="principal.member.authList" />
		</p>

		<div>
			<a href="/">HOME</a>
		</div>




</body>
</html>