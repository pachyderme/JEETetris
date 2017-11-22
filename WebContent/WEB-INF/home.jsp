<%@ page pageEncoding="UTF-8" langage="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
</head>
<body>
	<nav class="nav-extended">
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">Tetris</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li>
					<form method="POST" action="">
						<input class="btn waves-effect waves-light pink" type="submit" name="deconnexion" value="Deconnexion" />

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
		<div class="row">
			<c:foreach items="${applicationScope['tetris'].Tetriminos }" var="tetrimino">
						<div class="col s12 m6">
				<div class="card ${tetrimino.Color }">
					<div class="card-content white-text">
						<span class="card-title">${tetrimino.Name }</span>
						
					</div>
					<div class="card-action">
						<a href="#">This is a link</a> <a href="#">This is a link</a>
					</div>
				</div>
			</div>
			</c:foreach>
		</div>
	</div>
	<div id="test2" class="col s12">
		<div class="row">
			<form method="POST" action="" class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input id="name" type="text"
							class="validate" name="name"> <label for="name">Nom</label>
					</div>
					<div class="input-field col s6">
						<select id="color" name="color">
							<option value="" disabled selected>Selectionner une couleur</option>
							<option value="1">Bleu</option>
							<option value="2">Blanc</option>
							<option value="3">Rouge</option>
						</select> 
						<label>Couleur</label>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

	<script>
		$(document).ready(function() {
			$('ul.tabs').tabs();
			$('select').material_select();
		});
	</script>
</body>
</html>