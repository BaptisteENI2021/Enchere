<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creer Compte</title>
</head>
<body>

<form action="UtilisateurServlet" method="POST">
Pseudo: <input type="text" name="pseudo" value="${model.utilisateur.pseudo}"/>
Nom: <input type="text" name="nom" value="${model.utilisateur.nom}"/>
Prénom: <input type="text" name="prenom" value="${model.utilisateur.prenom}"/>
Email: <input type="text" name="email" value="${model.utilisateur.email}"/>
Téléphone: <input type="text" name="telephone" value="${model.utilisateur.telephone}"/>
Rue: <input type="text" name="rue" value="${model.utilisateur.rue}"/>
Code postal: <input type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
Ville: <input type="text" name="nom" value="${model.utilisateur.ville}"/>
Mot de passe: <input type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
Nouveau mot de passe: <input type="text" name="nom" value="${model.utilisateur.nom}"/>
Nom: <input type="text" name="nom" value="${model.utilisateur.nom}"/>
 


<input type="submit" name="enregistrer" value="enregistrer"/>


</body>
</html>