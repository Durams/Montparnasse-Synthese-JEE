<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  <!-- Rajouter cette ligne -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.css"/> <!-- rajouter cette ligne -->

<title>Insert title here</title>
</head>
<body>
<body>
	<div class="container">
		<h2>Formulaire Stagiaire</h2>
		<form action="ServletStagiaire">
			<!-- dans l'action il faut mettre la destination de notre Servlet où on veut aller    -->
			<div class="form-group">
			
				
				
				Nom:<br> <input type="text" name="lastname" value="${lastname }"required><br> <!--on ramene les infos avec ces parametres-->
				Prenom:<br> <input type="text" name="firstname" value="${firstname }"required><br>
				Age:<br> <input type="text" name="age" value="${age}"required><br>

			</div>

			<input type="submit" name="ajouter" value="Ajouter">
		
		</form>

	</div>
</body>
<div class = "container">
<h2>Liste des personnes en bdd</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Age</th>
			<th>Supprimer</th>
			
		</tr>
	</thead>
	<tbody>
		<c:if test="${! empty Stagiaires}">
			<c:forEach items="${Stagiaires}" var="x">
				<tr>
					<td><c:out value="${x.id}"/></td>
					<td><c:out value="${x.nom}"/></td>
					<td><c:out value="${x.prenom}"/></td>
					<td><c:out value="${x.age}"/></td>
					<td><a href = "ServletSupprimerStag?idStagiaire=${x.id }">Supprimer</a></td>
				
				</tr>
			</c:forEach>
			</c:if>
	</tbody>
</table>
</div>
</body>
</html>