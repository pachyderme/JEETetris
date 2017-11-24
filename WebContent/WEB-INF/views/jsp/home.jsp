<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<nav class="nav-extended">
		<div class="nav-wrapper center">
			<a href="#" class="brand-logo" style="letter-spacing: 7px;">TETRIS</a>
			<a href="#" data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><form:form method="POST" action="/JEETetris/logout">
						<button class="btn waves-effect waves-light pink"
							style="height: 60px;" type="submit" name="deconnexion">
							<i class="material-icons">power_settings_new</i>
						</button>
					</form:form></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><form:form method="POST" action="/JEETetris/logout">
						<input type="submit" name="deconnexion" value="Deconnexion" />
					</form:form></li>
			</ul>
		</div>
		<div class="nav-content">
			<ul class="tabs tabs-transparent">
				<li class="tab"><a class="active" href="#test1">Tétriminos</a></li>
				<li class="tab"><a href="#test2">Ajouter un tétrimino</a></li>
			</ul>
		</div>
	</nav>
	<div id="test1" class="col s12">
		<div class="container row">
			<div class="row"></div>
			<c:if test="${applicationScope['tetris'].tetriminos.size() == 0 }">
				<p class="light center">Aucune entrée</p>
			</c:if>
			<c:forEach items="${applicationScope['tetriminos']}" var="tetrimino">
				<div class="col s6 m4">
					<div class="card ${tetrimino.color } lighten-1">
						<div class="card-content white-text">
							<span class="card-title">${tetrimino.name }</span>

						</div>
						<div class="card-action">
							<form:form method="POST" action="/JEETetris/deleteTetrimino"
								modelAttribute="tetrimino">
								<button type="submit" class="btn waves-effect waves-light pink"
									name="id" value="${tetrimino.id }" type="submit"
									name="deconnexion">
									<i class="material-icons">delete</i>
								</button>
							</form:form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="test2" class="container col s12">
		<div class="row"></div>
		<div class="row">
			<form:form method="POST" action="/JEETetris/addTetrimino"
				modelAttribute="tetrimino" class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input id="name" type="text" class="validate" name="name"
							value="${ tetrimino.name }"> <label for="name">Nom</label>
					</div>
					<div class="input-field col s6">
						<form:select path="color" id="color" name="color">
							<form:option value="blue">Bleu</form:option>
							<form:option value="green">Vert</form:option>
							<form:option value="red">Rouge</form:option>
							<form:option value="orange">Orange</form:option>
							<form:option value="purple">Violet</form:option>
							<form:option value="pink">Rose</form:option>
						</form:select>
						<label>Sélectionner une couleur</label>
					</div>
				</div>
				<div class="input-field center">
					<input type="submit" class="btn red lighten-2 white-text"
						value="Ajouter" />
				</div>
			</form:form>
		</div>
	</div>

	<div class="fixed-action-btn">
		<a class="btn-floating btn-large pink" id="addTetrimino"> <i
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
			$("#addTetrimino").click(function() {
				$('ul.tabs').tabs('select_tab', 'test2');
			});
		});
	</script>
</body>
</html>