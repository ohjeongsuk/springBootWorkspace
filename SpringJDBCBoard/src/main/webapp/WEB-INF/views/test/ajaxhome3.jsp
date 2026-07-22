<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    // 🛠️ 수정 포인트: 문서가 준비되었을 때 실행되도록 감싸줍니다.
    $(document).ready(function() {

        $("#putBtn").on("click", function() {
            var boardDTOArray = [ {
                boardNo : "01",
                title : "pw01"
            }, {
                boardNo : "02",
                title : "pw02"
            } ];

            $.ajax({
                type : "post",
                url : "/test/gohome1", 
                data : JSON.stringify(boardDTOArray),
                contentType : "application/json; charset=utf-8",
                success : function(result) {
                    console.log("result: " + result);
                    if (result === "SUCCESS") {
                        alert("SUCCESS");
                    }
                }
            });
        });

    }); // 깔끔하게 매칭 완료
</script>
</head>
<body>
    <h1>AjaxHome</h1>

    <div>
        <button id="putBtn">데이터전송(post): BoardDTO 객체 배열 전송</button>
    </div>
</body>
</html>