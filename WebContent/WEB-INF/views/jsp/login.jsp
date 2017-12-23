<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row"></div>
	<div class="row"></div>
	<h5 class="center">Connexion</h5>
	<form:form method="POST" action="${contextPath}/connect/connect" class="row"
		modelAttribute="user">
		<div class="input-field">
			<input type="text" name="identifier" id="identifier"
				value="${ user.identifier }" /> <label for="identifier">Identifiant</label>
		</div>
		<div class="input-field">
			<input type="password" name="password" id="password"
				value="${ user.password }" /> <label for="password">Password</label>
		</div>
		<div class="input-field center">
			<input type="submit" class="btn red lighten-2 white-text"
				value="Connexion" />
		</div>
	</form:form>
	<p class="red-text">${msg}</p>
</div>