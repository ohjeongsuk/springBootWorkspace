<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>글 수정 - ${boardDTO.title}</title>
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateForm.css">
</head>

<body>
    <div class="notion-update-wrapper">
        <form action="/board/update" method="post">
            <%-- 서버로 넘겨줄 필수 글번호 (hidden) --%>
            <input type="hidden" name="boardNo" value="${boardDTO.boardNo}">

            <%-- 제목 입력 영역 --%>
            <div class="notion-page-header">
                <span class="notion-page-icon">📝</span>
                <input type="text" name="title" class="notion-title-input" 
                       value="${boardDTO.title}" placeholder="제목 없음" required autocomplete="off">
            </div>

            <%-- 속성 영역 --%>
            <div class="notion-properties">
                <%-- 변경된 작성자 영역: text 타입으로 바꾸어 수정이 가능하게 만듭니다 --%>
                <div class="notion-property-row">
                    <div class="property-label">👤 작성자</div>
                    <div class="property-value">
                        <input type="text" name="writer" class="notion-writer-input" 
                               value="${boardDTO.writer}" required autocomplete="off" placeholder="작성자 이름">
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

            <%-- 본문 내용 입력 영역 --%>
            <div class="notion-content-area">
                <textarea name="content" class="notion-textarea" 
                          placeholder="자유롭게 내용을 입력하세요..." required>${boardDTO.content}</textarea>
            </div>

            <%-- 하단 버튼 컨트롤 영역 --%>
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