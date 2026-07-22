<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Board</title>
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/selectForm.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
</head>

<body>
    <div class="notion-detail-wrapper">

        <div class="notion-page-header">
            <span class="notion-page-icon">📄</span>
            <h1 class="notion-page-title">${boardDTO.title}</h1>
        </div>

        <div class="notion-properties">
            <div class="notion-property-row">
                <div class="property-label">👤 작성자</div>
                <div class="property-value">
                    <span class="writer-badge">${boardDTO.writer}</span>
                </div>
            </div>
            <div class="notion-property-row">
                <div class="property-label">📅 작성일</div>
                <div class="property-value">
                    <span class="date-text">
                        <fmt:formatDate value="${boardDTO.regDate}" pattern="yyyy-MM-dd HH:mm"/>
                    </span>
                </div>
            </div>
            <div class="notion-property-row">
                <div class="property-label">🔢 글번호</div>
                <div class="property-value-no">${boardDTO.boardNo}</div>
            </div>
        </div>

        <div class="notion-content-area">
            ${boardDTO.content}
        </div>

        <div class="notion-action-group">
            <div class="left-actions">
                <a href="/board/list" class="notion-btn">📁 목록으로</a>
            </div>
            <div class="right-actions">
                <a href="/board/updateForm?boardNo=${boardDTO.boardNo}" class="notion-btn edit-btn">✍️ 수정</a>
                <a href="/board/delete?boardNo=${boardDTO.boardNo}" class="notion-btn delete-btn" onclick="return confirm('정말 삭제하시겠습니까?');">🗑️ 삭제</a>
            </div>
        </div>

    </div>
</body>
</html>