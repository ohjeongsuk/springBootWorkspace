<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>글 수정 - ${boardDto.title}</title>
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateForm.css">
</head>

<body>
    <div class="notion-update-wrapper">
        <form action="/board/update" method="post">
            <input type="hidden" name="boardNo" value="${boardDTO.boardNo}">

            <div class="notion-page-header">
                <span class="notion-page-icon">📝</span>
                <input type="text" name="title" class="notion-title-input" 
                       value="${boardDTO.title}" placeholder="제목 없음" required autocomplete="off">
            </div>

            <div class="notion-properties">
                <div class="notion-property-row">
                    <div class="property-label">👤 작성자</div>
                    <div class="property-value">
                        <span class="writer-badge">${boardDTO.writer}</span>
                        <input type="text" name="writer" value="${boardDTO.writer}">
                    </div>
                </div>
                <div class="notion-property-row">
                    <div class="property-label">📅 최초작성일</div>
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
                <textarea name="content" class="notion-textarea" 
                          placeholder="자유롭게 내용을 입력하세요..." required>${boardDTO.content}</textarea>
            </div>

            <div class="notion-action-group">
                <div class="left-actions">
                    <a href="/board/select?boardNo=${boardDTO.boardNo}" class="notion-btn cancel-btn">취소</a>
                </div>
                <div class="right-actions">
                    <button type="submit" class="notion-btn submit-btn">💾 저장하기</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>