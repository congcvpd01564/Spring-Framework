<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src='<c:url value="/resources/"/>/form.js'></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/"/>/mos-style.css'> <!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">

<style type="text/css">
.err{
	color:red;
	font-style: italic;
}
</style>

<title>Login</title>
</head>
<body>
<div id="header">
	<div class="inHeaderLogin"></div>
</div>
<div id="loginForm">
	<div class="headLoginForm">
	<spring:message code="lang.login.title"/>
	
	</div>
	<div class="fieldLogin">
	<p>${message}</p>
	<frm:form action="login.htm" modelAttribute="login" method="post"
	name="login" onsubmit="return checkLogin()">
		<label><spring:message code="lang.login.username"/><span class="err" id="error_username"></span></label><br>
		<frm:input path="username" name ="username"/><br><br>
		<label><spring:message code="lang.login.password"/><span class="err" id="error_password"></span></label><br>
		<frm:password path="password" name="password"/><br><br>
		<input type="submit" value="<spring:message code="lang.login.button"/>" class="button"/>
		<a href="login.htm?lang=en">English</a> |
		<a href="login.htm?lang=vi">Vietnamese</a><br><br>
		<label></label>
		
	</frm:form>		
	</div>
</div>
</body>
</html>