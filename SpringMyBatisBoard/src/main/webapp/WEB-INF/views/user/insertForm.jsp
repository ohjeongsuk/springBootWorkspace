<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Board</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/insertForm.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/user/insert");
			formObj.attr("method", "post");
			formObj.submit();
		});
	});
</script>
</head>
<body>
	<h3>회원 등록</h3>
	<form:form modelAttribute="member" action="/user/insert" method="post">
		<table>
			<tr>
				<td>userId</td>
				<td><form:input path="userId" /></td>
				<td><font color="red"><form:errors path="userId" /></font></td>
			</tr>
			<tr>
				<td>userPw</td>
				<td><form:input path="userPw" /></td>
				<td><font color="red"><form:errors path="userPw" /></font></td>
			</tr>
			<tr>
				<td>userName</td>
				<td><form:input path="userName" /></td>
				<td><font color="red"><form:errors path="userName" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">등록</button>
	</div>
</body>
</html>