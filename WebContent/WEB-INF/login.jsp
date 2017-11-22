<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
</head>
<body>
	<div class="container">
		<div class="row"></div>		<div class="row"></div>
		<h5>Gestion du jeu Tétris</h5>
		<form method="POST" action="" class="row">
		<div class="input-field">
			<input type="text" name="identifier" id="identifier" />
			<label for="identifier">Identifiant</label>
		</div>
		<div class="input-field">
			<input type="text" name="password" id="password" />
			<label for="password">Password</label>
		</div>
		<div class="input-field">
			<input type="submit" class="btn red lighten-2 white-text" value="Connexion" />
		</div>

	</form>
	<p class="red-text">${msg}</p>
	</div>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>
</html>
