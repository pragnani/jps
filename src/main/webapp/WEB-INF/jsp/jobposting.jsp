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

		<!--
		This will include the main menu in this page.
		 -->
	<jsp:include page="../common/header.jsp" />

	<form:form commandName="job" cssClass="form-horizontal">

<!-- We are checking if the query string returned is true or not  -->
		<div class="form-group">
			<c:if test="${param.success eq true}">
				<div class="col-sm-10">
					<label class="alert alert-success" for="name"
						class="col-sm-2 control-label">Job Posted Successfully</label>
				</div>
			</c:if>
		</div>

		
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Job title :</label>
			<div class="col-sm-10">
				<form:input path="jobTitle" id="name" cssClass="form-control" />
			</div>
		</div>


 
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Job Description :</label>
			<div class="col-sm-10">
			<form:textarea path="jobDescription" cssClass="form-control" cols="8"  rows="5" />
			</div>
		</div>

		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Post</button>
			</div>
		</div>

	</form:form>
</body>
</html>