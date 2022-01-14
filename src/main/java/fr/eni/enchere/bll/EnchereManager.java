package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

public interface EnchereManager {
	
	public Enchere ajoutEnchere (Enchere enchere) throws BLLException ;
	
	public  Enchere selectionnerEnchereById(Integer noEnchere) throws BLLException ;
	
	public List<Enchere> selectionnerToutesLesEncheres() throws BLLException;
	
	public  List<Enchere> selectionnerEncheresParArticle(Integer noEnchere) throws BLLException;
	
	public void modifierEnchere (Enchere EnchereAModifier) throws BLLException;
	
}
