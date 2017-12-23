<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="container row">
	<form:form method="POST"
		action="${contextPath}/home/save/response/responses"
		modelAttribute="response" class="col s12">
		<div class="row">
			<form:input path="id" cssStyle="display:none" />
			<form:input path="question.id" cssStyle="display:none" />
			<div class="input-field col s12">
				<form:input id="name" type="text" class="validate" name="name"
					path="label" />
				<label for="name">Label</label>
			</div>
			<div class="switch">
				<label> Fausse <form:checkbox id="correct" path="correct" />
					<span class="lever"></span> Vraie
				</label>
			</div>
		</div>
		<div class="input-field center">
			<input type="submit" class="btn red lighten-2 white-text"
				value="Ajouter" />
		</div>
	</form:form>
</div>
