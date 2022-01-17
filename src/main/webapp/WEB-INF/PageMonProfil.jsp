<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageMonProdil</title>
</head>
<body>

<h2>ENI-Encheres</h2>

<form action="PageMonProfilServlet" method="POST">
Pseudo : ${model.utilisateur.pseudo}
<br>
Nom : ${model.utilisateur.nom}
<br>
Prenom : ${model.utilisateur.prenom}
<br>
Email : ${model.utilisateur.email}
<br>
Teléphone : ${model.utilisateur.telephone}
<br>
Rue : ${model.utilisateur.rue}
<br>
Code postal : ${model.utilisateur.codePostal}
<br>
Ville : ${model.utilisateur.ville}
<br>
<input type="submit" name="Modifier" value="Modifier"/>

</form>
</body>
</html>