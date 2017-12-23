<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="card-content">
	<span class="card-title">${value.title} - ${value.points}
		point(s)</span>
	<p>${value.responses.size()}suggestions</p>
</div>
<div class="card-action">
	<a class="waves-effect waves-light btn"
		href="${contextPath}/home/responses/${value.id}"><i
		class="material-icons left">list</i></a>
	<a class="waves-effect waves-light btn"
		href="${contextPath}/home/questions/update/${value.id}"><i
		class="material-icons left">update</i></a>
	<form:form method="POST"
		action="${contextPath}/home/delete/question/questions/${value.id}"
		cssStyle="display:inline-block;" modelAttribute="question">
		<button type="submit" class="btn waves-effect waves-light" name="id"
			value="${value.id }" name="delete">
			<i class="material-icons">delete</i>
		</button>
	</form:form>
</div>