<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="./include/header.jsp"%>

<title>Home</title>
</head>

<body>
	<%@include file="./include/nav.jsp"%>

	<h1>Home!</h1>

	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm" />">로그인</a>
		</p>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
	</sec:authorize>
	<div>
		<h3>
			[<a href="<c:url value="/intro/introduction" />">소개 페이지</a>] [<a
				href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
		</h3>
	</div>

</body>
<%@include file="./include/footer.jsp"%>
</html>
