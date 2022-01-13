<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h2>ENI-Enchères</h2>
<a href="http://localhost:8080/Enchere/PageConnexionServlet" id="InscrireConnecte">S'inscrire - Se connecter</a>

<h3>Liste des enchères</h3>

<h4>Filtres :</h4>
<input type="search" name="rechercheArticle"/>

<h5>Catégorie :</h5>
<select name="categorie">
<option value="toutes">Toutes</option>
<option value="informatique">Informatique</option>
<option value="ameublement">Ameublement</option>
<option value="vêtement">Vêtement</option>
<option value="sportLoisirs">Sport et Loisirs</option>
</select>

<input type="submit" name="rechercher" value="Rechercher"/>

</body>
</html>