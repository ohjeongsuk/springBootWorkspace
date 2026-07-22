<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.DateFormat"%> 
<%@ page import="java.util.Date"%> 
<%@ page import="java.util.Locale"%> 
<%

/*scriptlet을 사용하면 자바코드를 사용할수 있음 */
	Date date = new Date();
	String serverTime2 = date.toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더내용을 가져온다 -->
	<%@ include file="./../includes/header.jsp" %>
	<p>서버에서 보내준 데이터 출력 ${serverTime}</p>
	<p>jsp 코드안에서 자바를 활용해 데이터 출력 <%=serverTime2%> </p>
	<!-- 푸터내용을 가져온다  -->
	<%@ include file="./../includes/footer.jsp" %>
	
	
</body>
</html>