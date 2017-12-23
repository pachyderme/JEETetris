<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="test1" class="col s12">
	<div class="container row">
		<c:if test="${applicationScope['values'].size() == 0 }">
			<p class="light center">Aucune donnée</p>
		</c:if>
			<ul class="collection">
			<c:forEach items="${applicationScope['values']}" var="value">
				<li class="collection-item"><div>${ value.label }-
						${ value.correct }
						<a class="btn-flat secondary-content" href="${contextPath}/home/responses/update/${value.id}"><i class="material-icons">update</i></a>
						<form:form method="POST"
							action="${contextPath}/home/delete/response/responses/${value.id}"
							cssStyle="display:inline-block;">
							<button type="submit"
								class=" btn-flat waves-effect waves-green secondary-content">
								<i class="material-icons">delete</i>
							</button>
						</form:form>
					</div></li>
			</c:forEach>
		</ul>		
	</div>
</div>
<div id="test2" class="container col s12">
	<div class="container row">
		<form:form method="POST"
			action="${contextPath}/home/save/response/responses"
			modelAttribute="response" class="col s12">
			<div class="row">
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
</div>