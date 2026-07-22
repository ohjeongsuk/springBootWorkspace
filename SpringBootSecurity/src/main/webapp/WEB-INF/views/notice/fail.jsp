<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="https://rsms.me/inter/inter.css">
<style>
@charset "UTF-8";
/* 노션 라이트모드 디자인 시스템 변수 정의 */
:root {
	--notion-bg: #ffffff;
	--notion-text: #37352f;
	--notion-text-light: #787774;
	--notion-border: rgba(55, 53, 47, 0.16);
	--notion-bg-hover: rgba(55, 53, 47, 0.08);
	--notion-callout-bg: rgba(235, 236, 235, 0.3); /* 노션 가벼운 회색 콜아웃 배경 */
}

body {
	font-family: 'Inter', -apple-system, BlinkMacSystemFont, "Segoe UI",
		Helvetica, Arial, sans-serif;
	background-color: var(--notion-bg);
	color: var(--notion-text);
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh; /* 화면 정중앙 배치 */
}

.notion-result-wrapper {
	width: 100%;
	max-width: 520px;
	padding: 0 20px;
	box-sizing: border-box;
}

/* 💡 노션의 시그니처 콜아웃 블록 스타일 */
.notion-callout-block {
	display: flex;
	align-items: flex-start;
	gap: 14px;
	padding: 16px 20px;
	background-color: var(--notion-callout-bg);
	border-radius: 4px;
	border: 1px solid transparent;
	margin-bottom: 28px;
}

.notion-callout-icon {
	font-size: 22px;
	line-height: 1.2;
	user-select: none;
}

.notion-callout-content {
	font-size: 15px;
	font-weight: 500;
	line-height: 1.6;
	color: var(--notion-text);
}

/* 📁 노션 스타일의 미니멀한 링크 버튼 */
.notion-back-link {
	display: inline-flex;
	align-items: center;
	justify-content: center;
	gap: 6px;
	height: 36px;
	padding: 0 14px;
	font-size: 14px;
	font-weight: 500;
	color: var(--notion-text);
	text-decoration: none;
	border: 1px solid var(--notion-border);
	border-radius: 4px;
	background-color: transparent;
	transition: background 0.1s ease-in 0s;
}

.notion-back-link:hover {
	background-color: var(--notion-bg-hover);
}
</style>
</head>
<body>

	<div class="notion-result-container">

		<div class="notion-callout">
			<span class="notion-callout-emoji">🔔</span>
			<div class="notion-callout-text">
				실패하였습니다.</div>
		</div>

		<a href="/user/list" class="notion-link-btn">📁사용자리스트로가기</a>

	</div>

</body>
</html>