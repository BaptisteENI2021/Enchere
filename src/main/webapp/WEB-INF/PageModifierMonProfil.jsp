<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>ENI-Encheres</h2>
<h2>Mon Profil</h2>

<form action="UtilisateurCreerServlet" method="POST">
Pseudo: <input type="text" name="pseudo" value="${model.utilisateur.pseudo}"/>
Nom: <input type="text" name="nom" value="${model.utilisateur.nom}"/> <br>
Prénom: <input type="text" name="prenom" value="${model.utilisateur.prenom}"/> 
Email: <input type="text" name="email" value="${model.utilisateur.email}"/> <br>
Téléphone: <input type="text" name="telephone" value="${model.utilisateur.telephone}"/>
Rue: <input type="text" name="rue" value="${model.utilisateur.rue}"/> <br>
Code postal: <input type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
Ville: <input type="text" name="ville" value="${model.utilisateur.ville}"/> <br>
Mot de passe: <input type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
Confirmation: <input type="password" name="confirmation" value="${model.utilisateur.confirmation}"/> <br>

Credit : ${model.utilisateur.credit}

<input type="submit" name="enregistrer" value="enregistrer"/>
<button type="submit" name="supprimer">Supprimer mon compte</button>

</form>
</body>
</html>