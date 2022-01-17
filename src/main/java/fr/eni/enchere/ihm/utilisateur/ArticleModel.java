/**
 * 
 */
package fr.eni.enchere.ihm.utilisateur;

import java.util.List;
import java.util.ArrayList;

import fr.eni.enchere.bo.Article;

/**
 * Classe en charge de 
 * @author jdonal2021
 * @date 16 janv. 2022 - 15:45:07
 * @version Enchere - V0.1  
 */
public class ArticleModel {

	private Article article;
	private List<Article> listeArticles = new ArrayList<Article>();
	
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<Article> getListeArticles() {
		return listeArticles;
	}
	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	/**
	 * Constructeur.
	 * @param article
	 * @param listeArticles
	 */
	public ArticleModel(Article article, List<Article> listeArticles) {
		super();
		this.article = article;
		this.listeArticles = listeArticles;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVenteModel [article=");
		builder.append(article);
		builder.append(", listeArticles=");
		builder.append(listeArticles);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Constructeur.
	 */
	public ArticleModel() {
		super();
	}
	
}
