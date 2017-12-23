<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="card-content">
	<span class="card-title">${value.subject.label} -
		${value.questions.size()} question(s)</span>
</div>
<div class="card-action">
	<a class="waves-effect waves-light btn"
		href="${contextPath}/home/questions/${value.id}"><i
		class="material-icons left">list</i></a>
	<form:form method="POST"
		action="${contextPath}/home/delete/quiz/quizzes/${value.id}"
		cssStyle="display:inline-block;" modelAttribute="test">
		<button type="submit" class="btn waves-effect waves-light" name="id"
			value="${value.id }" name="delete">
			<i class="material-icons">delete</i>
		</button>
	</form:form>
</div>