package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;

public class TestBllArticle {

	public static void main(String[] args) {

		List<Article> lstArticles = new ArrayList<>();

		ArticleManager manager = ArticleManagerImpl.getInstance();

		try {
			lstArticles.add(manager.vendreArticle("Velo", "VTT qui va vite", LocalDate.of(2022, 11, 22),
					LocalDate.of(2022, 11, 22), 500, 1));

			lstArticles.add(manager.vendreArticle("Ballon", "Ballon de foot", LocalDate.of(2022, 01, 23),
					LocalDate.of(2022, 01, 24), 300, 2));

			lstArticles.add(manager.vendreArticle("Maison", "Maison200 mettres carrés", LocalDate.of(2022, 03, 15),
					LocalDate.of(2022, 04, 24), 2000, 3));

		} catch (BLLException e) {

			e.printStackTrace();
		}

	}

}
