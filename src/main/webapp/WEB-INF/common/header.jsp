<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
<head>

<!-- Static navbar
		
		We have included all of our styles in one place to avoid redundant code
		
		 -->
<jsp:include page="../common/styles.jsp" />
</head>
<body>
	<div class="container">

		<!-- Static navbar
		
		This is where we have placed our menus, We are using Twitter bootstrap and jquery CDNs
		
		
		 -->


		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<spring:url value="/"/>">Java
					Spring Tutorial</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<spring:url value="/"/>">Home</a></li>
					
						<security:authorize access="! isAuthenticated()">
						
					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Register
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<spring:url value="/register"/>">Employee</a></li>
							<li><a href="<spring:url value="/empregister"/>">Employer</a></li>
							<li class="divider"></li>

						</ul></li>
						
						</security:authorize>
					<li><a href="<spring:url value="/joblistings"/>">Job
							Listings</a></li>
					<li><a href="<spring:url value="/employees"/>">Employees</a></li>
					<li><a href="<spring:url value="/postjob"/>">Post Job</a></li>
					<security:authorize access="! isAuthenticated()">
						<li><a href="<spring:url value="/login"/>">Login</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href='<spring:url value="/logout" />'>Logout</a></li>
					</security:authorize>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
	</div>
</body>
</html>