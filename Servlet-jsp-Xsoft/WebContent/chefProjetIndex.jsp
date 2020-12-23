 <%@page import="ma.ensa.todo.dao.ProjetDao"%>
<%@page import="ma.ensa.todo.dao.imp.ProjetDaoImp"%>
<%@page import="ma.ensa.todo.business.ProjetBusiness"%>
<%@page import="ma.ensa.todo.business.imp.ProjetBusinessImp"%>
<%@page import="ma.ensa.todo.beans.Projet"%>
<%@page import="ma.ensa.todo.beans.Utilisateur"%>

<%@page import="java.util.List"%>


<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<% ProjetDao prDao=new ProjetDaoImp();
ProjetBusiness prBusiness=new ProjetBusinessImp(prDao);
List<Projet> projets=prBusiness.afficherProjets();
Utilisateur admin=(Utilisateur)session.getAttribute("utilisateur");
%>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse" id="navbarNav" style="background-color: pink";>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="chefProjetIndex.jsp">Chef de projet: <%= admin.getNom() %></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="profilchef.jsp">Mon profile</a></li>
			<li class="nav-item"><a class="nav-link"
				href="Deconnection">Déconnecter</a></li>
		</ul>
	</div>
</nav>
</head>
<body style="background-color: pink";>

<p align="center">Liste de mes projets</p>
	<table class="table" style="background-color: white";>
		<thead>
			<tr>
				<th scope="col">Code</th>
				<th scope="col">charge Horaire</th>
				<th scope="col">Description</th>
				<th scope="col">Intitule</th>
				<th scope="col">Statut</th>
			</tr>
		</thead>

		<%
			for(Projet projet : projets) {
		%>

		<tr>
			<td><%= projet.getCode() %></td>
			<td><%= projet.getChargeHoraire() %></td>
			<td><%= projet.getDescription() %></td>
			<td><%= projet.getIntitule() %></td>
			<td><%= projet.getStatut() %></td>
			
			<td><a href="editerProjet.jsp?code_pro=<%=projet.getCode()%>">Editer</a></td>
		    <td><a href="deleteprojet?codd=<%=projet.getCode()%>">Supprimer</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
</html>