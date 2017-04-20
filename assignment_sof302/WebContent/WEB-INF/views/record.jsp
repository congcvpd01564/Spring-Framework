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
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/"/>/mos-style.css'>
<script type="text/javascript" src='<c:url value="/resources/"/>/form.js'></script>
<!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">
<title>Record Management</title>
</head>
<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<spring:message code="lang.button.admin"/><br> <a href="record.htm?lang=en">English</a> | 
					<a href="record.htm?lang=vi">Vietnamese</a> | <a href="login.htm"><spring:message code="lang.button.login"/></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">		
			<h3 style="color: red;">${message}</h3>
			<frm:form action="record.htm" method="post" modelAttribute="record" 
			name="record" onsubmit="return checkRecord()">
				<table width="40%">
					<tr>
						<td><b><spring:message code="lang.record.staffname"/></b></td>
						<td>
							<frm:select path="staff.id" items="${staffs }" 
								itemLabel="name" itemValue="id"></frm:select>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.record.id"/></b></td>
						<td>
						<c:if test="${not empty editMode }"><frm:input path="id" name ="id" readonly="true"/></c:if>
						<c:if test="${empty editMode }"><frm:input path="id" name ="id"/></c:if>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.record.type"/></b></td>
						<td>
							<frm:radiobutton path="type" label="Thành tích" value="true" id="one"/>
							<frm:radiobutton path="type" label="Kỷ luật" value="false" id="zero"/>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.record.reason"/></b></td>
						<td><frm:input path="reason" name="reason"/></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.record.date"/></b></td>
						<td><frm:input path="date" name="date" placeholder="mm/dd/yyyy" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="button" value="Insert" name="btnInsert" />
							<input type="submit" class="button" value="Update" name="btnUpdate" />
							<input type="submit" class="button" value="Delete" name="btnDelete" />
							<input type="reset" class="button" value="Reset">
						</td>
					</tr>
				</table>
			</frm:form>
			<h3><spring:message code="lang.record.title"/></h3>
			<table class="data" >
				<tr class="data">					
					<th class="data"><spring:message code="lang.record.id"/></th>
					<th class="data"><spring:message code="lang.record.staffname"/></th>
					<th class="data"><spring:message code="lang.record.type"/></th>
					<th class="data"><spring:message code="lang.record.reason"/></th>
					<th class="data"><spring:message code="lang.record.date"/></th>
					<th class="data" width="75px"></th>
				</tr>
				<c:forEach var="r" items="${records}">
				<tr class="data">
					<td class="data">${r.id }</td>
					<td class="data">${r.staff.name}</td>
					<td class="data">${r.type?'1':'0'}</td>
					<td class="data">${r.reason }</td>
					<td class="data">${r.date}</td>
					<td class="data" width="75px">
						<center>
							<a href="record.htm?linkEdit&id=${r.id}"><spring:message code="lang.button.edit"/></a>
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