package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurManager {
	
	public void inscrireUtilisateur (Utilisateur nouvelUtilisateur) throws BLLException;
	
	public void modifierUtilisateur (Utilisateur utilisateurAModifier) throws BLLException;
	
	public Utilisateur afficherUtilisateur (Integer noUtilisateur) throws BLLException;
	
	public void supprimerUtilisateur (Integer noUtilisateur) throws BLLException;

}
