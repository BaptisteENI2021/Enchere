package fr.eni.enchere.dal;

import fr.eni.enchere.dal.mock.ArticleDAOImplMock;
import fr.eni.enchere.dal.mock.CategorieDAOImplMock;
import fr.eni.enchere.dal.mock.EnchereDAOImplMock;
import fr.eni.enchere.dal.mock.RetraitDAOImplMock;
import fr.eni.enchere.dal.mock.UtilisateurDAOImplMock;

public class DAOFactory {

	public static UtilistaeurDAO getInstance() {
		return new UtilisateurDAOImplMock();

	}
	
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
	
	
	
	
	
}
