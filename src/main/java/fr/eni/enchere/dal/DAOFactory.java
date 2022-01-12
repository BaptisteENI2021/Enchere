package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.UtilisateurDAOImpl;


public class DAOFactory {

	
	public static UtilisateurDAO getInstance() {
		return new UtilisateurDAOImpl();

	}
	/**
	public static ArticleDAO getInstance() {
		return new ArticleDAOImplMock();

	}
	
	public static RetraitDAO getInstance() {
		return new RetraitDAOImplMock();

	}
	
	public static EnchereDAO getInstance() {
		return new EnchereDAOImplMock();

	}
	
	public static CategorieDAO getInstance() {
		return new CategorieDAOImplMock();

	}
**/
	
	
	
	
}
