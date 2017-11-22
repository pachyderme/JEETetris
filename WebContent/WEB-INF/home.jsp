<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<nav class="nav-extended">
		<div class="nav-wrapper center">
			<a href="#" class="brand-logo" style="letter-spacing:7px;">TETRIS</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li>
					<form method="POST" action="">
						<button class="btn waves-effect waves-light pink" style="height: 60px;" type="submit" name="deconnexion">
						    <i class="material-icons">power_settings_new</i>
						</button>
					</form>
				</li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li>
					<form method="POST" action="">
						<input type="submit" name="deconnexion" value="Deconnexion" />
					</form>
				</li>
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
			<c:forEach items="${applicationScope['tetris'].tetriminos }" var="tetrimino">
				<div class="col s6 m4">
					<div class="card ${tetrimino.color } lighten-1">
						<div class="card-content white-text">
							<span class="card-title">${tetrimino.name }</span>

						</div>
						<div class="card-action">
							<form method="post" action="">
								<button type="submit" class="btn waves-effect waves-light pink" name="delete" value="${tetrimino.name }" type="submit" name="deconnexion">
								    <i class="material-icons">delete</i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="test2" class="container col s12">
			<div class="row"></div>
		<div class="row">
			<form method="POST" action="" class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input id="name" type="text" class="validate" name="name">
						<label for="name">Nom</label>
					</div>
					<div class="input-field col s6">
						<select id="color" name="color">
							<option value="" disabled selected>Selectionner une couleur</option>
							<option value="blue">Bleu</option>
							<option value="green">Vert</option>
							<option value="red">Rouge</option>
							<option value="orange">Orange</option>
							<option value="purple">Violet</option>
							<option value="pink">Rose</option>
						</select>
						<label>Couleur</label>
					</div>
				</div>
				<div class="input-field center">
					<input type="submit" class="btn red lighten-2 white-text"
						value="Ajouter" />
				</div>
			</form>
		</div>
	</div>
	
	<div class="fixed-action-btn">
	    <a class="btn-floating btn-large pink" id="addTetrimino">
	      <i class="large material-icons">add</i>
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