<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="header">
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
		    <div class="navbar-header">
		    	<a class="navbar-brand" href="${pageContext.request.contextPath }/main.do">Person</a>
		    </div>
		    <div class="collapse navbar-collapse">
		       <c:if test="${empty userId}">
					<ul class="nav navbar-nav navbar-right">
				      <li><a href="${pageContext.request.contextPath }/login.do">로그인</a></li>
				      <li><a href="${pageContext.request.contextPath }/common.do?page=login/signUp">회원가입</a></li>
					  <li><a href="${pageContext.request.contextPath }/common.do?page=login/idCheck">아이디 / 비밀번호 찾기</a></li>
				    </ul>
			    </c:if>
				<c:if test="${not empty userId}">
					<ul class="nav navbar-nav navbar-right">
				      <li><a href="${pageContext.request.contextPath}/mypage.do"><span>${userNm}님 환영합니다.</span></a></li>
				      <li><a href="${pageContext.request.contextPath}/login.do?method=logout">로그아웃</a></li>
				    </ul>
			    </c:if>
			</div>
		</div>
	</div>
</div> 
