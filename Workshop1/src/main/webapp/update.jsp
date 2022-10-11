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
	<div style="text-align: left; margin-left: 500px">
		<h1>Update Job</h1>
		<form action="SaveUpdateServlet" method="post">
			<c:set var="job" value="${requestScope.jb}" />
			<c:if test="${not empty job}"/>
					Job_ID:
					<input type="text" readonly="readonly" name="txtJobID" value="${job.job_ID}">
				<br>
				<br>
					Job_Name:
					<input type="text" name="txtJobName" value="${job.job_Name}">
				<br>
				<br>
					Job_Company:
					<input type="text"  name="txtJobCompany" value="${job.job_Company}">
				<br>
				<br>
					Year_of_Experience:
					<input type="number"  name="txtYear_of_Experience" value="${job.year_of_Experience}">
				<br>
				<br>	
				<input type="submit" name="button" value="Save">
				<input type="submit" name="button" value="Cancel">
		</form>
	</div>
</body>
</html>