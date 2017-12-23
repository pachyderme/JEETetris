<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="container row">
	<form:form method="POST"
		action="${contextPath}/home/save/question/questions"
		modelAttribute="question" class="col s12">
		<div class="row">
			<form:input path="id" cssStyle="display:none" />
			<form:input path="quiz.id" cssStyle="display:none" />
			<div class="input-field col s6">
				<form:textarea id="title" type="text" class="materialize-textarea"
					name="title" path="title" />
				<label for="title">Enoncé</label>
			</div>
			<div class="input-field col s6">
				<form:select path="points" id="points" name="points">
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="5">5</form:option>
					<form:option value="10">10</form:option>
				</form:select>
				<label>Sélectionner des points</label>
			</div>
		</div>
		<div class="input-field center">
			<input type="submit" class="btn red lighten-2 white-text"
				value="Ajouter" />
		</div>
	</form:form>
</div>