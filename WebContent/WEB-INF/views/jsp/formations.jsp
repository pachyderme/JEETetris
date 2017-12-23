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
		<form:form method="POST" action="${contextPath}/home/save/formation/formations"
			modelAttribute="formation" class="col s12">
			<div class="row">
				<div class="input-field col s12">
					<form:input id="name" type="text" class="validate" name="name"
						path="label"/> <label for="name">Label</label>
				</div>
			</div>
			<div class="input-field center">
				<input type="submit" class="btn red lighten-2 white-text"
					value="Ajouter" />
			</div>
		</form:form>
	</div>
</div>