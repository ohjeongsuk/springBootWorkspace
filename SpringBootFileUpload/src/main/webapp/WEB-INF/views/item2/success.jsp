<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" session="false"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>게시판</title> 
<link rel="stylesheet" href="https://rsms.me/inter/inter.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateForm.css">
</head> 
<body> 
    <div class="notion-update-wrapper notion-msg-wrapper"> 
    
    		<div class="notion-callout">
			<span class="notion-callout-emoji">🔔</span>
			<div class="notion-callout-text">성공했습니다</div>
		</div>
        <div class="notion-action-group msg-action">
            <a href="/item2/list" class="notion-btn submit-btn return-list-btn">
                📋 상품리스트로 돌아가기
            </a>
        </div>
        
    </div> 
</body> 
</html>