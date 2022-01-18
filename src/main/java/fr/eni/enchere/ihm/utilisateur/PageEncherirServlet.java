package fr.eni.enchere.ihm.utilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerImpl;
import fr.eni.enchere.bll.impl.ArticleManagerImpl;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class PageEncherir
 */
@WebServlet("/PageEncherirServlet")
public class PageEncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager manager = ArticleManagerImpl.getInstance();
	private EnchereManager managerEnchere = EnchereManagerImpl.getInstance();
	Article articleRecupere = new Article();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageEncherirServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* recupération de ModelUtilisateur depuis la session */
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		ArticleModel articleModel = (ArticleModel) request.getSession().getAttribute("articleModel");
		
		
		String WEBINF = "WEB-INF/PageEncherir.jsp";
		
		
		if (model == null) {
			model = new UtilisateurModel();
		}
		if (articleModel == null) {
			articleModel = new ArticleModel();
		}
		
		
		if(articleRecupere.getNoArticle()== null) {
		Integer noAticleClic = Integer.valueOf(request.getParameter("id"));
		
		try {
			articleRecupere = manager.afficherArticleById(noAticleClic);
			articleModel.setArticle(articleRecupere);
		} catch (BLLException e2) {
			e2.printStackTrace();
		}
		
		System.out.println(articleModel.getArticle());
		System.out.println(articleModel.getArticle().getNomArticle());
		
		}
		
		if (request.getParameter("encherir") != null) {

			Integer prixDeVente = Integer.parseInt(request.getParameter("prixDeVente"));

			Utilisateur utilisateur = model.getUtilisateur();

		
			
			articleRecupere.setPrixDeVente(prixDeVente);

			articleModel.setArticle(articleRecupere);

			try {
				manager.modifierArticle(articleRecupere);
				System.out.println("Article enregistré");
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			WEBINF = "/PageListeEnchereMesVentesServlet";
		}
		
		request.setAttribute("articleModel", articleModel);
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
