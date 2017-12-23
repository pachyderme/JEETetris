<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:if test="${applicationScope['values'].size() == 0 }">
	<p class="light center">Aucune donnée</p>
</c:if>
<c:forEach items="${applicationScope['values']}" var="value">
	<div class="col s6 m4">
		<div class="card">
		<c:set var="value" value="${value}" scope="request"/>
		<tiles:insertAttribute name="cardContent" />
		</div>
	</div>
</c:forEach>