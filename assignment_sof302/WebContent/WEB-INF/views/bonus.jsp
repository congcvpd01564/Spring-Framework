<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">
<link rel="shortcut icon" href="#">
<!--Pemanggilan gambar favicon-->
<link rel="shortcut icon"
	href='<c:url value="/resources/"/>/stylesheet/img/devil-icon.png'>
<!--Pemanggilan gambar favicon-->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/"/>/mos-style.css'>
<!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">
<title>Bonus</title>
</head>
<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<spring:message code="lang.button.admin"/><br> <a href="bonus.htm?lang=en">English</a> | 
					<a href="bonus.htm?lang=vi">Vietnamese</a> | <a href="login.htm"><spring:message code="lang.button.login"/></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3><spring:message code="lang.bonus.title1"/></h3>
			<table class="data" >
				<tr class="data">
					<th class="data"><spring:message code="lang.bonus.staffid"/></th>
					<th class="data"><spring:message code="lang.bonus.bonus"/></th>
					<th class="data"><spring:message code="lang.bonus.discipline"/></th>
					<th class="data"><spring:message code="lang.bonus.total"/></th>
				</tr>
				<c:forEach var="a" items="${arrays}">
				<tr class="data">
					<td class="data">${a[0]}</td>
					<td class="data">${a[1]}</td>
					<td class="data">${a[2]}</td>
					<td class="data">${a[1]-a[2]}</td>
				</tr>
				</c:forEach>
			</table>
			<h3><spring:message code="lang.bonus.title"/></h3>
			<table class="data" >
				<tr class="data">
					<th class="data"><spring:message code="lang.bonus.iddepart"/></th>
					<th class="data"><spring:message code="lang.bonus.bonus"/></th>
					<th class="data"><spring:message code="lang.bonus.discipline"/></th>
					<th class="data"><spring:message code="lang.bonus.total"/></th>
				</tr>
				<c:forEach var="b" items="${map}">
				<tr class="data">
					<td class="data">${b[0]}</td>
					<td class="data">${b[1]}</td>
					<td class="data">${b[2]}</td>
					<td class="data">${b[1]-b[2]}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>