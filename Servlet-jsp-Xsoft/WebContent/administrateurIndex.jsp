<%@page import="ma.ensa.todo.beans.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="ma.ensa.todo.business.UtilisateurBusiness"%>
<%@page import="ma.ensa.todo.business.imp.UtilisateurBusinessImp"%>
<%@page import="ma.ensa.todo.dao.UtilisateurDao"%>
<%@page import="ma.ensa.todo.dao.imp.UtilisateurDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<% UtilisateurDao userDao=new UtilisateurDaoImp();
UtilisateurBusiness userBusiness=new UtilisateurBusinessImp(userDao);
List<Utilisateur> users=userBusiness.allUtilisateur(); 
%>
<%Utilisateur admin=(Utilisateur)session.getAttribute("utilisateur"); %>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse" id="navbarNav" style="background-color: pink;">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="administrateurIndex.jsp">Administrateur: <%=admin.getNom() + " " + admin.getPrenom()%></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="profiladm.jsp">Mon profile</a></li>
			<li class="nav-item"><a class="nav-link"
				href="Deconnection">Déconnecter</a></li>
		</ul>
	</div>
</nav>
</head>
<body style ="background-color: pink;">
	<h1>Bienvenue Admin</h1>
	
	<p align="center">Liste des utilisateurs</p>
	<table class="table" style ="background-color: white;">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">email</th>
				<th scope="col">nom</th>
				<th scope="col">prenom</th>
				<th scope="col">role</th>
			</tr>
		</thead>

		<%
			for(Utilisateur u:users) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%= u.getEmail() %></td>	
			<td> <%= u.getNom() %> </td>
			<td><%= u.getPrenom() %></td>
			<td><%= u.getRole() %></td>
			<td><a href="editeruser.jsp?id=<%=u.getId()%>">Editer</a></td>
		    <td><a href="deleteusers?idd=<%=u.getId()%>">Supprimer</a></td>
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