<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<%@ include file="../include/common.jsp"%><!-- 공통 js/css 및 contextPath  --> 
</head>
<body>
<%@ include file="../include/header.jsp"%><!-- 로그인 바   --> 
<div>
	<form action="<%=contextPath%>/login.do" method="post">
		아이디 	 :  <input type="text" name="id" /> 
		패스워드 :  <input type="password" name="pw" /> 
		<input type="submit" value="확인">
	</form>
</div>
<script type="text/javascript">
	<c:if test="${!empty message}">
		alert("${message}");
	</c:if>
</script>
</body>
</html>