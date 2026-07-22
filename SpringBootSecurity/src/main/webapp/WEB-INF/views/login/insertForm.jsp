<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인</h1>
	<h2>
		<c:out value="${error}" />
	</h2>
	<h2>
		<c:out value="${logout}" />
	</h2>
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="">
		</div>
		<div>
			<input type="password" name="password" value="">
		</div>
		<!-- 로그인 상태유지 체크박스 -->
		<div>
			<input type="checkbox" name="remember-me"> 로그인 상태유지
		</div>
		<div>
			<input type="submit">
		</div>

		<sec:csrfInput />
	</form>
</body>
</html>