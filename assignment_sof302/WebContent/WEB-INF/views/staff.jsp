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
<script type="text/javascript" src='<c:url value="/resources/"/>/form2.js'></script>
<!--pemanggilan file css-->
<base href="${pageContext.servletContext.contextPath}/">

<style type="text/css">
.err{
	color:red;
	font-style: italic;
}
</style>

<title>Staff Management</title>
</head>
<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<spring:message code="lang.button.admin"/><br> <a href="staff.htm?lang=en">English</a> | 
					<a href="staff.htm?lang=vi">Vietnamese</a> | <a href="login.htm"><spring:message code="lang.button.login"/></a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3 style="color: red; font-style: italic;">${message}</h3>
			<frm:form action="staff.htm" method="post" modelAttribute="staff"
			 name="staff" onsubmit="return checkStaff()">
				<table width="80%">
					<tr>
						<td><b><spring:message code="lang.staff.departname"/></b></td>
						<td>
							<frm:select path="depart.id" items="${departs}" itemLabel="name" itemValue="id"></frm:select>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.id"/></b></td>
						<td>
						<c:if test="${not empty editMode }"><frm:input path="id" name ="id" readonly="true"/><span class="err" id="error_id"></span></c:if>
						<c:if test="${empty editMode }"><frm:input path="id" name ="id"/><span class="err" id="error_id"></span></c:if>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.name"/></b></td>
						<td><frm:input path="name" name="name"/><span class="err" id="error_name"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.gender"/></b></td>
						<td>
							<frm:radiobutton path="gender" label="Male" value="true" id="male"/>
							<frm:radiobutton path="gender" label="Female" value="false" id="female"/><span class="err" id="error_gender"></span>
						</td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.photo"/></b></td>
						<td><frm:input path="photo" name="photo" type="file"/><span class="err" id="error_photo"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.birthday"/></b></td>
						<td><frm:input path="birthday" name="birthday" placeholder = "yyyy/mm/dd"/><span class="err" id="error_birthday"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.salary"/></b></td>
						<td><frm:input path="salary" name="salary"/><span class="err" id="error_salary"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.email"/></b></td>
						<td><frm:input path="email" name="email" /><span class="err" id="error_email"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.phone"/></b></td>
						<td><frm:input path="phone" name="phone"/><span class="err" id="error_phone"></span></td>
					</tr>
					<tr>
						<td><b><spring:message code="lang.staff.notes"/></b></td>
						<td><frm:input path="notes" name="notes"/><span class="err" id="error_notes"></span></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="button" value="<spring:message code="lang.button.insert"/>" name="btnInsert"/>
							<input type="submit" class="button" value="<spring:message code="lang.button.update"/>" name="btnUpdate" />
							<input type="submit" class="button" value="<spring:message code="lang.button.delete"/>" name="btnDelete" />
							<input type="submit" class="button" value="<spring:message code="lang.button.reset"/>">
						</td>
					</tr>
				</table>
			</frm:form>
			<h3><spring:message code="lang.staff.title"/></h3>
			<table class="data" >
				<tr class="data">
					<th class="data"><spring:message code="lang.staff.id"/></th>
					<th class="data"><spring:message code="lang.staff.departname"/></th>
					<th class="data"><spring:message code="lang.staff.name"/></th>
					<th class="data"><spring:message code="lang.staff.gender"/></th>
					<th class="data"><spring:message code="lang.staff.photo"/></th>
					<th class="data"><spring:message code="lang.staff.birthday"/></th>
					<th class="data"><spring:message code="lang.staff.salary"/></th>
					<th class="data"><spring:message code="lang.staff.email"/></th>
					<th class="data"><spring:message code="lang.staff.phone"/></th>
					<th class="data"><spring:message code="lang.staff.notes"/></th>
					<th class="data" width="75px"></th>
				</tr>
				<c:forEach var="s" items="${staffs}">
				<tr class="data">
					<td class="data">${s.id}</td>
					<td class="data">${s.depart.name }</td>
					<td class="data">${s.name}</td>
					<td class="data">${s.gender?'Male':'Female'}</td>
					<td class="data"><img src="<c:url value="/resources/img/${s.photo}"/>" with =30px height = "30px" ></td>
					<td class="data">${s.birthday}</td>
					<td class="data">${s.salary}</td>
					<td class="data">${s.email}</td>
					<td class="data">${s.phone }</td>
					<td class="data">${s.notes}</td>
					<td class="data" width="75px">
						<center>
							<a href="staff.htm?linkEdit&id=${s.id}"><spring:message code="lang.button.edit"/></a>
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