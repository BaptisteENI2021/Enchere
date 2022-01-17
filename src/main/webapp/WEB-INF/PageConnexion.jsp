<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ENI-Enchere</h2>
<form action="PageConnexionServlet" method="POST">
Identifiant : <input type="text" name="identifiant"/>
Mot de passe: <input type="text" name="motDePasse"/>

<input type="submit" name="Connexion" value="Connexion"/>
<input type="checkbox" name="SeSouvenir" /> Se souvenir de moi
<a href="">Mot de passe oublié</a>
</form>

<form action="PageConnexionServlet" method="POST">
<button type="submit" name="CreerUnCompte">Créer un compte</button>
</form>

</body>
</html>