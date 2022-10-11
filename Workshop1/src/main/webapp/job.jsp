<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Job</title>
</head>
<body>
	<h1>Create a new job</h1>
		<form action="CreateJobServlet" method="post">
			Job_ID: <input type="text" name="txtJobID" value=""/> (4 characters)
			<c:set var="err" value="${requestScope.insertErr}"/> <br><br>
			
			<c:if test="${not empty err.jobIDErr}"/>
				<font color="red">${err.jobIDErr}</font> <br><br>
			Job_Name: <input type="text" name="txtJobName" value=""/> <br><br>
			
			<c:if test="${not empty err.jobNameErr}"/>
				<font color="red">${err.jobNameErr}</font> <br><br>
			Job_Company: <input type="text" name="txtJobCompany" value=""/><br><br>
			
			<c:if test="${not empty err.jobCompanyErr}"/>
				<font color="red">${err.jobCompanyErr}</font> <br><br>
			Year_of_Experience: <input type="number" name="txtYear_of_Experience" value=""/> Just numerical<br><br>
			
			<c:if test="${not empty err.yearErr}"/>
				<font color="white">${err.yearErr}</font> <br><br>
			<input type="submit" value="Create New Job" name="btAction"/>
			<input type="reset" value="Reset"/>
		</form>
			<br>
			<br>
</body>
</html>