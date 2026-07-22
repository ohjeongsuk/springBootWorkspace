<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Board</title>

<link rel="stylesheet" href="https://rsms.me/inter/inter.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/listForm.css">
</head>

<body>
	<div class="notion-list-wrapper">

		<div class="notion-header">
			<div class="notion-title-area">
				<span class="notion-title-icon"></span>
				<h1 class="notion-title">자유 게시판</h1>
			</div>
			<a href="/board/insertForm" class="notion-write-btn"> 새 글 작성</a>
			<div>
				<span class="title-text">${msg}</span>
			</div>
		</div>

		<div class="notion-table-container">
			<table class="notion-table">
				<thead>
					<tr>
						<th class="col-no">번호</th>
						<th class="col-title">제목</th>
						<th class="col-writer">작성자</th>
						<th class="col-writer">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty list}">
						<tr>
							<td colspan="4" class="notion-empty-row">등록된 게시글이 없습니다.</td>
						</tr>
					</c:if>

					<c:forEach var="board" items="${list}">
						<tr
							onclick="location.href='/board/select?boardNo=${board.boardNo}'">
							<td class="col-no">${board.boardNo}</td>
							<td class="col-title"><span class="title-text">${board.title}</span>
							</td>
							<td class="col-writer"><span class="writer-badge">${board.writer}</span>
							</td>
							<td class="col-writer"><fmt:formatDate
									pattern="yyyy-MM-dd HH:mm" value="${board.regDate}" /></td>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>