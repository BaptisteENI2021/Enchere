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

<br/>

<div>
	Achats : <input type="radio" name="transaction" value="Achats" id="achats" onclick="onClickAchats()">
    Mes ventes : <input type="radio" name="transaction" value="Mes Ventes" id="mesVentes" onclick="onClickVentes()">
</div>
<hr/>
<div>
enchères ouvertes : <input type="checkbox" value="enchères ouvertes" id="encheresOuvertes" >
mes ventes en cours : <input type="checkbox" value="mes ventes en cours" id="mesVentesEnCours"><br/>
mes enchères: <input type="checkbox" value="mes enchères" id="mesEncheres">
ventes non débutées : <input type="checkbox" value="ventes non débutées" id="ventesNonDebutees"><br/>
enchères remportées : <input type="checkbox" value="enchères remportées" id="encheresRemportees">
ventes terminées : <input type="checkbox" value="ventes terminées" id="ventesTerminees"><br/>

</div>


<br/>

<c:forEach items="${modelArticle.listeArticles}" var="article">
	<p><a href = "<c:url value = "PageEncherirServlet?id=${article.noArticle}"/>">${article.nomArticle}</a> : ${article.categorie.libelle}</p>
	
</c:forEach>

</body>
</html>


<script type="application/javascript">

function onClickAchats()
{
    var mesVentesEnCours = document.getElementById("mesVentesEnCours");
    mesVentesEnCours.checked = false;
    mesVentesEnCours.disabled = true;
    var ventesNonDebutees = document.getElementById("ventesNonDebutees");
    ventesNonDebutees.checked = false;
    ventesNonDebutees.disabled = true;
    var ventesTerminees = document.getElementById("ventesTerminees");
    ventesTerminees.checked = false;
    ventesTerminees.disabled = true;
    var encheresOuvertes = document.getElementById("encheresOuvertes");
    encheresOuvertes.checked = false;
    encheresOuvertes.disabled = false;
    var mesEncheres = document.getElementById("mesEncheres");
    mesEncheres.checked = false;
    mesEncheres.disabled = false;
    var encheresRemportees = document.getElementById("encheresRemportees");
    encheresRemportees.checked = false;
    encheresRemportees.disabled = false;
}
function onClickVentes()
{
    var encheresOuvertes = document.getElementById("encheresOuvertes");
    encheresOuvertes.checked = false;
    encheresOuvertes.disabled = true;
    var mesEncheres = document.getElementById("mesEncheres");
    mesEncheres.checked = false;
    mesEncheres.disabled = true;
    var encheresRemportees = document.getElementById("encheresRemportees");
    encheresRemportees.checked = false;
    encheresRemportees.disabled = true;
    var mesVentesEnCours = document.getElementById("mesVentesEnCours");
    mesVentesEnCours.checked = false;
    mesVentesEnCours.disabled = false;
    var ventesNonDebutees = document.getElementById("ventesNonDebutees");
    ventesNonDebutees.checked = false;
    ventesNonDebutees.disabled = false;
    var ventesTerminees = document.getElementById("ventesTerminees");
    ventesTerminees.checked = false;
    ventesTerminees.disabled = false;
}






</script>
