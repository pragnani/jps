<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<h4>Employee Details</h4>
	<table class="table table-bordered table-striped table table-hover">
	<thead>
		<tr>
			<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>UserName</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.email}</td>
					<td>${employee.userId}</td>
				</tr>
			</c:forEach>
</tbody>
</table>
	
</body>
</html>