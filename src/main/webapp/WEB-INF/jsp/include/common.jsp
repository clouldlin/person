<%@page import="com.lin.clould.person.login.dao.vo.LoginVO"%>
<%@ taglib prefix="c" 		  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 		  uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String baseURL 		 = "http://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath();
	final String contextPath   = request.getContextPath();
	LoginVO loginVO = (LoginVO)session.getAttribute("person.sessionInfo");
	
	String userId = "";
	String userNm = "";
	if(loginVO != null){
		userId = loginVO.getId();
		userNm = loginVO.getName();
	}
%>
<c:set var="userId" value="<%=userId%>" />
<c:set var="userNm" value="<%=userNm%>" />
<link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap-theme.css'/>">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="<c:url value='/bootstrap/js/bootstrap.js'/>"></script> 


