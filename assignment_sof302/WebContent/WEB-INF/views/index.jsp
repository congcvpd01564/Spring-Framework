<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript"
	src='<c:url value="/resources/"/>/form.js'></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/"/>/mos-style.css'>
<!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">
<title>Home</title>
</head>
<body>

	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<spring:message code="lang.button.admin" />
				<br> <a href="index.htm?lang=en">English</a> | <a
					href="index.htm?lang=vi">Vietnamese</a> | <a href="login.htm"><spring:message
						code="lang.button.login" /></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>${message}</h3>
			<div class="informasi"><spring:message code="lang.index.title" /></div>

			<table class="data">
				<tr class="data">
					<th class="data"><spring:message code="lang.index.photo" /></th>
					<th class="data"><spring:message code="lang.index.idstaff" /></th>
					<th class="data"><spring:message code="lang.index.name" /></th>
					<th class="data"><spring:message code="lang.index.departname" /></th>
					<th class="data"><spring:message code="lang.index.bonus" /></th>
				</tr>
				<c:forEach var="a" items="${arr}">
					<tr class="data">
						<td class="data"><img src="<c:url value="/resources/img/${a[0]}"/>" with =50px height = "50px" ></td>
						<td class="data">${a[1]}</td>
						<td class="data">${a[2]}</td>
						<td class="data">${a[3]}</td>
						<td class="data">${a[4]}</td>
					</tr>
				</c:forEach>
			</table>
			<form action="send.htm" method="post">
				<p>
					<input name="from" class="sedang" placeholder="From">
				</p>
				<p>
					<input name="to" class="sedang" placeholder="To">
				</p>
				<p>
					<input name="subject" class="sedang" placeholder="Subject">
				</p>
				<p>
					<textarea name="body" class="sedang" placeholder="Body" rows="3"
						cols="20"></textarea>
				</p>
				<input type="submit" class="button" value="Send">
			</form>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>