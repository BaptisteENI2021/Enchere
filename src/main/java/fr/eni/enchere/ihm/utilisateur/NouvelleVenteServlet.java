package fr.eni.enchere.ihm.utilisateur;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.impl.ArticleManagerImpl;
import fr.eni.enchere.bll.impl.CategorieManagerImpl;
import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleManager manager = ArticleManagerImpl.getInstance();
	private CategorieManager managerCat = CategorieManagerImpl.getInstance();

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelleVenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String WEBINF = "WEB-INF/NouvelleVente.jsp";

		if (request.getParameter("enregistrer") != null) {

			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			Integer categorieNumero = Integer.parseInt(request.getParameter("categorieNumero"));
			// PHOTO DE L'Article
			Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			LocalDate debutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
			LocalDate finEnchere = LocalDate.parse(request.getParameter("finEnchere"));
			String rueRetrait = request.getParameter("rueRetrait");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			
			Categorie categorie = managerCat.categorieById(categorieNumero);
			
			Article article = new Article (nomArticle,description,debutEnchere,finEnchere, miseAPrix,categorie);
			

		//	(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			//		Integer prixInitial, Categorie categorie, Retrait retrait) {
			
			Article nouvelArticle = manager.vendreArticle(article);

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
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
