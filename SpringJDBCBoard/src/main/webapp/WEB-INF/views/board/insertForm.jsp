<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Board</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertForm.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            var formObj = $("#boardDto");
            $("#btnInsert").on("click", function() {
                formObj.attr("action", "/board/insert");
                formObj.attr("method", "post");
                formObj.submit();
            });
            $("#btnList").on("click", function() {
                self.location = "/board/list";
            });
        });
    </script>
</head>

<body>
    <div class="notion-container">
        <!-- 📝 노션의 시그니처: 상단 대형 이모지 블록 -->
        <div class="notion-main-emoji">📝</div>
        <h2 class="notion-title">새 글 작성하기</h2>
        
        <form:form modelAttribute="boardDto" action="insert">
            
            <!-- 제목 입력 block -->
            <div class="notion-form-group">
                <label class="notion-label">📌 Title</label>
                <form:input path="title" class="notion-input" placeholder="제목을 입력하세요..."/>
                <font class="notion-error-msg"><form:errors path="title"/></font>
            </div>
            
            <!-- 작성자 입력 block -->
            <div class="notion-form-group">
                <label class="notion-label">✍️ Writer</label>
                <form:input path="writer" class="notion-input" placeholder="작성자 이름 또는 닉네임"/>
                <font class="notion-error-msg"><form:errors path="writer"/></font>
            </div>
            
            <!-- 내용 입력 block -->
            <div class="notion-form-group">
                <label class="notion-label">📄 Content</label>
                <form:textarea path="content" class="notion-input notion-textarea" placeholder="여기에 내용을 자유롭게 끄적여보세요..."/>
                <font class="notion-error-msg"><form:errors path="content"/></font>
            </div>
            
        </form:form>
        
        <!-- 하단 버튼 그룹 -->
        <div class="notion-btn-group">
            <button type="button" id="btnList" class="notion-btn">📁 List</button>
            <button type="button" id="btnInsert" class="notion-btn notion-btn-primary">✨ Insert</button>
        </div>
    </div>
</body>
</html>