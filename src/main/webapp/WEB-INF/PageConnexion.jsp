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
<form action="PageConnexionServlet" method="POST">
Identifiant : <input type="text" name="identifiant"/>
Mot de passe: <input type="text" name="MotDePasse"/>

<input type="submit" name="Connexion" value="Connexion"/>
<input type="checkbox" name="SeSouvenir" /> Se souvenir de moi
<a href="">Mot de passe oublié</a>
</form>
<form action="PageConnexionServlet" method="POST">
<input type="submit" name="CréerUnCompte" value="Créer un compte">
</form>
</body>
</html>