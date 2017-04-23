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
<script type="text/javascript" src='<c:url value="/resources/"/>/form.js'></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/"/>/mos-style.css'>
<!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">
<title>Depart Management</title>
</head>
<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<spring:message code="lang.button.admin"/><br> <a href="depart.htm?lang=en">English</a> | 
					<a href="depart.htm?lang=vi">Vietnamese</a> | <a href="login.htm"><spring:message code="lang.button.login"/></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3 style="color: red;">${message}</h3>
			<frm:form action="depart.htm" modelAttribute="depart" 
			name="depart" onsubmit="return checkDepart()">
				<table width="40%">
					<tr>
						<td><b><spring:message code="lang.depart.id"/></b></td>
						<td>
						<c:if test="${not empty editMode }"><frm:input path="id" name ="id" readonly="true"/></c:if>
						<c:if test="${empty editMode }"><frm:input path="id" name ="id"/></c:if>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.depart.name"/></b></td>
						<td><frm:input path="name" name="name"/></td>
					</tr>
					<tr>
						<td colspan="2" >
							<input type="submit" class="button" value="<spring:message code="lang.button.insert"/>" name="btnInsert" />
							<input type="submit" class="button" value="<spring:message code="lang.button.update"/>" name="btnUpdate" />
							<input type="submit" class="button" value="<spring:message code="lang.button.delete"/>" name ="btnDelete" />
							<input type="reset" class="button" value="<spring:message code="lang.button.reset"/>">
						</td>
					</tr>
				</table>
			</frm:form>
			<h3><spring:message code="lang.depart.title"/></h3>
			<table class="data" >
				<tr class="data">
					<th class="data"><spring:message code="lang.depart.id"/></th>
					<th class="data"><spring:message code="lang.depart.name"/></th>
					<th class="data" width="75px"></th>
				</tr>
				<c:forEach var="d" items="${departs}">
				<tr class="data">
					<td class="data">${d.id}</td>
					<td class="data">${d.name }</td>
					<td class="data" width="75px">
						<center>
							<a href="depart.htm?linkEdit&id=${d.id}"><spring:message code="lang.button.edit"/></a>
						</center>
					</td>
				</tr>
				</c:forEach>

			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>