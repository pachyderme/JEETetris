<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="test1" class="col s12">
	<div class="container row">
		<tiles:insertAttribute name="values" />
	</div>
</div>
<div id="test2" class="container col s12">
	<div class="container row">
	<form:form method="POST" action="${contextPath}/home/save/quiz/quizzes"
			modelAttribute="quiz" class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<form:select multiple="true" path="tests" id="tests" name="tests" items="${applicationScope['tests']}" itemValue="id" itemLabel="label"/>
					<label>Sélectionner des tests</label>
				</div>
				<div class="input-field col s6">
					<form:select path="subject.id" id="subject" name="subject" items="${applicationScope['subjects']}" itemValue="id" itemLabel="label"/>
					<label>Sélectionner une matière</label>
				</div>
			</div>
			<div class="input-field center">
				<input type="submit" class="btn red lighten-2 white-text"
					value="Ajouter" />
			</div>
		</form:form>
	</div>
</div>