<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Job Information</h1>
	<table border ="1">
		<thead>
			<tr>
				<th>Job_ID</th>
				<th>Job_Name</th>
				<th>Job_Company</th>
				<th>Year_of_Experience</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="job" value="${requestScope.ListJOB}"/>
			<c:forEach var="dto" items="${job}">
				<tr>
					<td>${dto.job_ID}</td>
					<td>${dto.job_Name}</td>
					<td>${dto.job_Company}</td>
					<td>${dto.year_of_Experience}</td>
					<td><a href="DeleteServlet?job_ID=${dto.job_ID}">Delete</a>
					<td><a href="UpdateServlet?job_ID=${dto.job_ID}">Update</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="document.location='job.jsp'">Add New Job</button>
</body>
</html>