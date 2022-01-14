package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class TestBllArticle {

	public static void main(String[] args) {

		List<Article> lstArticles = new ArrayList<>();

		ArticleManager manager = ArticleManagerImpl.getInstance();


		
		try {
			
			Utilisateur utilisateur = DAOFactory.getInstance().selectById(45);
			Categorie categorie =  DAOFactory.getInstanceCategorie().selectById(1);
			
			Utilisateur utilisateur2 = DAOFactory.getInstance().selectById(42);
			Categorie categorie2 =  DAOFactory.getInstanceCategorie().selectById(2);
			
			
		manager.vendreArticle(new Article("Velo", "VTT qui va vite", LocalDate.of(2022, 11, 22),
				LocalDate.of(2022, 11, 22), 500, 500, utilisateur, categorie));

		manager.vendreArticle(new Article("Ballon", "Ballon de foot", LocalDate.of(2022, 01, 23),
					LocalDate.of(2022, 01, 24), 300, 300, utilisateur2, categorie2));


		
		
		

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
