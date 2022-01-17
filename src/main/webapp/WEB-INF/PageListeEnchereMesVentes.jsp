<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageListeEnchereMesVentes</title>
</head>

<body>

<h2>ENI-Enchères</h2>
<a href="http://localhost:8080/Enchere/EssaiServlet" id="Encheres">Echères</a>
<a href="http://localhost:8080/Enchere/NouvelleVenteServlet" id="VendreUnArticle">Vendre un article</a>
<a href="http://localhost:8080/Enchere/PageMonProfilServlet" id="MonProfil">Mon Profil</a>
<a href="http://localhost:8080/Enchere/PageAccueilNonConnecteServlet" id="Deconnection">Déconnection</a>


<h3>Liste des enchères</h3>

<h4>Filtres :</h4>
<form action="PageListeEnchereMesVentesServlet" method="POST">
<input type="search" name="rechercheArticle"/>


<h5>Catégorie :</h5>

<select name="categorie">
<option value="0">Toutes</option>
<option value="1">Informatique</option>
<option value="2">Ameublement</option>
<option value="3">Vêtement</option>
<option value="4">Sport et Loisirs</option>
</select>



<input type="submit" name="Rechercher" value="Rechercher"/>
</form>

<c:forEach items="${modelArticle.listeArticles}" var="article">
	<p><a href = "<c:url value = "EssaiServlet?noArticle=${article.noArticle}"/>"> ${article.nomArticle}</a> : ${article.categorie.libelle}</p>
	

	
	
</c:forEach>



</body>
</html>