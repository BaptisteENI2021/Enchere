package fr.eni.enchere.ihm.utilisateur;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.impl.ArticleManagerImpl;
import fr.eni.enchere.bll.impl.CategorieManagerImpl;
import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;

/**
 * Servlet implementation class PageAccueilNonConnecte
 */
@WebServlet("/PageListeEnchereMesVentesServlet")
public class PageListeEnchereMesVentesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();
	private ArticleManager managerArticle = ArticleManagerImpl.getInstance();
	private CategorieManager managerCategorie = CategorieManagerImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageListeEnchereMesVentesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		String WEBINF = "WEB-INF/PageListeEnchereMesVentes.jsp";

		if (model == null) {
			model = new UtilisateurModel();
		}
		
		
		ArticleModel modelArticle = new ArticleModel();
		
		List<Article> listeArticles = new ArrayList<Article>();

		

//		if (request.getParameter("InscrireConnecte") != null) {
//		}

		// Lister les articles en fonction des filtres NomArticle et Categorie
		if (request.getParameter("Rechercher") != null) {

			String rechercheArticle = request.getParameter("rechercheArticle");
			Integer noCategorie = Integer.parseInt(request.getParameter("categorie"));
			Categorie categorie = null;

			try {
				categorie = managerCategorie.categorieById(noCategorie);
				// System.out.println(categorie);
				// System.out.println("article saisie "+rechercheArticle);
				if (rechercheArticle == "") {
					if (noCategorie == 0) {
						modelArticle.setListeArticles(managerArticle.getAllArticle());
					} else {
						modelArticle.setListeArticles(managerArticle.getAllArticlesByCategories(categorie));
					}

				} else {
					if (noCategorie == 0) {
						modelArticle.setListeArticles(managerArticle.getAllArticleByNomMotCle(rechercheArticle));
					} else {
						List<Article> listeArticlesNom = managerArticle.getAllArticleByNomMotCle(rechercheArticle);
						List<Article> listeArticlebyNomByCategorie = new ArrayList<Article>();
						for (Article article : listeArticlesNom) {
							if (noCategorie == (article.getCategorie().getNoCategorie())) {
								listeArticlebyNomByCategorie.add(article);
							}
						}
						modelArticle.setListeArticles(listeArticlebyNomByCategorie);

					}

				}

			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			
		}
		System.out.println("Recupération du no avant de cliquer sur un lien: " +request.getParameter("id"));
		
		
		request.setAttribute("model", model);
		request.setAttribute("modelArticle", modelArticle);
		request.getRequestDispatcher(WEBINF).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
