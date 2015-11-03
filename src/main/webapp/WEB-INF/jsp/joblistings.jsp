<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html 
xmlns="http://www.w3.org/1999/xhtml"
 xmlns:th="http://www.thymeleaf.org">

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
.center {
     margin-left: auto;
     margin-right: auto;
     width: 50%;
 }
</style>
</head>
<jsp:include page="../common/header.jsp" />
<body class="center" >
	<h4><u>Job Listings</u></h4>
	<c:forEach items="${jobs}" var="job" >
		<table  >
			<thead>
				<tr>
					<td colspan="2"><h3>${job.jobTitle}</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td >${job.jobDescription}" </td>

				</tr>
				<tr>
					<td style="color:blue">By ${job.postedBy}</td>
				</tr>
				
			</tbody>
		</table>
		<hr/>
	</c:forEach>
</body>
</html>