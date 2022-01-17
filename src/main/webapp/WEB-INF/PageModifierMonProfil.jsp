<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageModifierMonProfil</title>
</head>
<body>

<h2>ENI-Encheres</h2>
<h2>Mon Profil</h2>

<form action="PageModifierMonProfilServlet" method="POST">
Pseudo: <input type="text" name="pseudo" value="${model.utilisateur.pseudo}"/>
Nom: <input type="text" name="nom" value="${model.utilisateur.nom}"/> <br>
Prénom: <input type="text" name="prenom" value="${model.utilisateur.prenom}"/> 
Email: <input type="text" name="email" value="${model.utilisateur.email}"/> <br>
Téléphone: <input type="text" name="telephone" value="${model.utilisateur.telephone}"/>
Rue: <input type="text" name="rue" value="${model.utilisateur.rue}"/> <br>
Code postal: <input type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
Ville: <input type="text" name="ville" value="${model.utilisateur.ville}"/> <br>
Mot de passe: <input type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
Confirmation: <input type="password" name="confirmation" value="${model.confirmation}"/> <br>
<input type="submit" name="enregistrer" value="enregistrer"/>
<input type="submit" name="supprimer" value="supprimer mon comptte"/>
</form>
</body>
</html>