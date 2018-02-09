<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="../include/header.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<%@include file="../include/nav.jsp"%>
<h1>관리자 홈 화면!</h1>

<h3>[<a href="<c:url value="/home" />">홈</a>]</h3>

</body>
<%@include file="../include/footer.jsp"%>
</html>
