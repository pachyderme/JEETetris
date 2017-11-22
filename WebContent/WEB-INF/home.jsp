<%@ page pageEncoding="UTF-8"%>
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
				<li><a href="collapsible.html">Deconnexion</a></li>
			</ul>
			<ul class="side-nav" id="mobile-demo">
				<li><a href="collapsible.html">Deconnexion</a></li>
			</ul>
		</div>
		<div class="nav-content">
			<ul class="tabs tabs-transparent">
				<li class="tab"><a class="active" href="#test1">Tétriminos</a></li>
				<li class="tab"><a href="#test2">Ajouter un
						tétrimino</a></li>
			</ul>
		</div>
	</nav>
	<div id="test1" class="col s12">
		<div class="row">
			<div class="col s12 m6">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
						<span class="card-title">Card Title</span>
						<p>I am a very simple card. I am good at containing small bits
							of information. I am convenient because I require little markup
							to use effectively.</p>
					</div>
					<div class="card-action">
						<a href="#">This is a link</a> <a href="#">This is a link</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="test2" class="col s12">
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="first_name" type="text"
							class="validate"> <label for="first_name">First
							Name</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"> <label
							for="last_name">Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input disabled value="I am not editable" id="disabled"
							type="text" class="validate"> <label for="disabled">Disabled</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="password" type="password" class="validate"> <label
							for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="email" class="validate"> <label
							for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="col s12">
						This is an inline input field:
						<div class="input-field inline">
							<input id="email" type="email" class="validate"> <label
								for="email" data-error="wrong" data-success="right">Email</label>
						</div>
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
		});
	</script>
</body>
</html>