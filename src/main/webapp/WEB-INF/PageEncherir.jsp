<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page encherir</title>
</head>
<body>

<form action= "PageEncherirServlet" method="POST">
 ${modelArticle.article.nomArticle}
<br>
Description : ${modelArticle.article.description}
<br>
Categorie :  ${modelArticle.article.categorie}
<br>
Meilleure offre :${modelArticle.article.prixDeVente}
<br>
Mise à prix : ${modelArticle.article.prixInitial}
<br>
Fin de l'enchère : ${articleModel.article.dateFinEncheres}
<br>
Retrait : ${articleModel.retrait.rue} ${articleModel.retrait.codePostal} ${articleModel.retrait.ville}
<br> 
Vendeur : ${articleModel.utilisateur.pseudo} 
// doit afficher le pseudo du vendeur
<br>
<input type = "number" name= "prixDeVente" value = "${articleModel.article.prixDeVente}"/>

<input type="submit" name="encherir" value="Encherir"/>

</form> 
</body>
</html>