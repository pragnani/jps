<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<!-- 

We are using spring form, you can find that above this will helps us to get all the form data to the server side, we are using a
commandName, it is same as the model attribute name we have used in our controllers. Spring will automatically place form data into
this Model Attribute "Employee"
 -->
	<form:form commandName="employee"  cssClass="form-horizontal">


		<div class="form-group">
			<c:if test="${param.success eq true}">
				<div class="col-sm-10">
					<label class="alert alert-success" for="name"
						class="col-sm-2 control-label">You have registered
						successfully</label>
				</div>
			</c:if>
		</div>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">First Name :</label>
			<div class="col-sm-10">
				<form:input path="firstName" id="name" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Last Name :</label>
			<div class="col-sm-10">
				<form:input path="lastName" id="name" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">UserName :</label>
			<div class="col-sm-10">
				<form:input path="userId" id="name" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email :</label>
			<div class="col-sm-10">
				<form:input path="email" id="email" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password
				:</label>
			<div class="col-sm-10">
				<form:password path="password" id="password" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="Occcupations" class="col-sm-2 control-label">Password
				:</label>
			<div class="col-sm-10">
				<form:select path="currentOccupation"  items="${occupations}" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Register</button>
			</div>
		</div>

	</form:form>
</body>
</html>