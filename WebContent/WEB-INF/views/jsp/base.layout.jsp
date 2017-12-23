<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<nav class="nav-extended">
		<div class="nav-wrapper center">
			<a href="${contextPath}/home/tests" class="brand-logo"
				style="letter-spacing: 7px;"><tiles:insertAttribute name="title" /></a>
			<a href="#" data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="${contextPath}/home/tests">Tests</a></li>
				<li><a href="${contextPath}/home/quizzes">Questionnaires</a></li>
				<li><a href="${contextPath}/home/formations">Formations</a></li>
				<li><a href="${contextPath}/home/subjects">Matières</a></li>
				<li><a href="${contextPath}/home/students">Candidats</a></li>
				<li><form:form method="POST"
						action="${contextPath}/connect/logout">
						<button class="btn waves-effect waves-light pink"
							style="height: 60px;" type="submit" name="logout">
							<i class="material-icons">power_settings_new</i>
						</button>
					</form:form></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><a href="${contextPath}/home/tests">Tests</a></li>
				<li><a href="${contextPath}/home/quizzes">Questionnaires</a></li>
				<li><a href="${contextPath}/home/formations">Formations</a></li>
				<li><a href="${contextPath}/home/subjects">Matières</a></li>
				<li><a href="${contextPath}/home/students">Candidats</a></li>
				<li><form:form method="POST"
						action="${contextPath}/connect/logout">
						<input type="submit" name="deconnexion" value="Deconnexion" />
					</form:form></li>
			</ul>
		</div>
		<div class="nav-content">
			<ul class="tabs tabs-transparent">
				<tiles:insertAttribute name="navcontent" />
			</ul>
		</div>
	</nav>

	<tiles:insertAttribute name="body" />

	<div class="fixed-action-btn">
		<a class="btn-floating btn-large pink" id="add"> <i
			class="large material-icons">add</i>
		</a>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {
			$('ul.tabs').tabs();
			$('select').material_select();
			$(".button-collapse").sideNav();
			$("#add").click(function() {
				$('ul.tabs').tabs('select_tab', 'test2');
			});
			$('.modal').modal();
			$('input[type=checkbox]').each(function() {

				var name = $(this).attr('name');
				$('[name="' + '_' + name + '"]').remove();

			});
		});
	</script>
</body>
</html>
