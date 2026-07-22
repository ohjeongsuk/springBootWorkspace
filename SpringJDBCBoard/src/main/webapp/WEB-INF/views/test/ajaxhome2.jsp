<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			// 1. 일반 POST 요청 버튼 이벤트
			$("#postBtn").on("click", function() {
				var boardNoVal = $("#boardNo").val();
				var titleVal = $("#title").val();
				var contentVal = $("#content").val();
				var writerVal = $("#writer").val();

				var boardObject = {
					boardNo : boardNoVal,
					title : titleVal,
					content : contentVal,
					writer : writerVal
				};

				$.ajax({
					type : "post",
					// 기존 "/test/gohome1" + boardNoVal 대신 경로 구분을 위해 슬래시(/) 추가
					url : "/test/gohome1/" + boardNoVal, 
					data : JSON.stringify(boardObject),
					contentType : "application/json; charset=utf-8",
					success : function(result) {
						console.log("result: " + result);
						if (result === "SUCCESS") {
							alert("SUCCESS");
						}
					} 
				}); 
			}); 

			// 2. 헤더 포함 PUT 요청 버튼 이벤트
			$("#putHeaderBtn").on("click", function() {
				var boardNoVal = $("#boardNo").val();
				var titleVal = $("#title").val();
				var contentVal = $("#content").val();
				var writerVal = $("#writer").val();

				var boardObject = {
					boardNo : boardNoVal,
					title : titleVal,
					content : contentVal,
					writer : writerVal
				};

				$.ajax({
					type : "put",
					url : "/board/update/" + boardNoVal,
					headers : {
						"X-HTTP-Method-Override" : "PUT"
					},
					data : JSON.stringify(boardObject),
					contentType : "application/json; charset=utf-8",
					success : function(result) {
						console.log("result: " + result);
						if (result === "SUCCESS") {
							alert("SUCCESS");
						}
					}
				});
			}); 

		}); // <-- 최하단에 빠져있던 $(document).ready의 닫는 괄호를 추가했습니다.
	</script>
</head>
<body>
<h1>Ajax Home</h1>
<form>
	boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
	title: <input type="text" name="title" value="" id="title"><br>
	content: <input type="text" name="content" value="" id="content"><br>
	writer: <input type="text" name="writer" value="" id="writer"><br>
</form>
<div>
	<button id="postBtn">데이터전송(post)</button>
	<button id="putHeaderBtn">수정(put with header)</button>
</div>
</body>
</html>