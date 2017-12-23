<%@ page pageEncoding="UTF-8"%>
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
		<form:form method="POST"
			action="${contextPath}/home/save/student/students"
			modelAttribute="form" class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<form:input id="name" type="text" class="validate" name="name"
						path="student.firstName" />
					<label for="name">Prénom</label>
				</div>
				<div class="input-field col s6">
					<form:input id="name" type="text" class="validate" name="name"
						path="student.lastName" />
					<label for="name">Nom</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input id="name" type="text" class="validate" name="name"
						path="student.email" />
					<label for="name">mail</label>
				</div>
				<div class="input-field col s6">
					<select name="testsIds" multiple="multiple">
						<c:forEach items="${applicationScope['tests']}" var="test">
							<option value="${test.id}">${test.label}</option>
						</c:forEach>
					</select>
					<label>Sélectionner des tests</label>
				</div>
			</div>
			<div class="input-field center">
				<input type="submit" class="btn red lighten-2 white-text"
					value="Ajouter" />
			</div>
		</form:form>
	</div>
</div>