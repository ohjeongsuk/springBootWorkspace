<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 회원</title>
</head>
<body>
	<h3>회원 목록</h3>
	<a href="/user/insertForm">New</a>

	<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="80">USERID</th>
			<th align="center" width="50">USERPW</th>
			<th align="center" width="50">USERNAME</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td align="center">${member.userNo}</td>
				<td align="center"><a href='/user/selectMember?userNo=${member.userNo}'>${member.userId}</a></td>
				<td align="left">${member.userPw}</td>
				<td align="right">${member.userName}</td>
				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${member.regDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
