<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="card-content">
	<span class="card-title">${value.firstName} ${value.lastName}</span>
	<p>${value.email}</p>
</div>
<div class="card-action">
	<form:form method="POST" action="${contextPath}/home/delete/student/students/${value.id}"
		modelAttribute="test">
		<button type="submit" class="btn waves-effect waves-light"
			value="${value.id}" type="submit" name="delete">
			<i class="material-icons">delete</i>
		</button>
	</form:form>
</div>