package fr.eni.enchere.ihm.utilisateur;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.HomesUserDatabase;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerImpl;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.impl.ArticleManagerImpl;
import fr.eni.enchere.bll.impl.CategorieManagerImpl;
import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class PageAccueilNonConnecte
 */
@WebServlet("/PageListeEnchereMesVentesServlet")
public class PageListeEnchereMesVentesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();
	private ArticleManager managerArticle = ArticleManagerImpl.getInstance();
	private CategorieManager managerCategorie = CategorieManagerImpl.getInstance();
	private EnchereManager managerEnchere = EnchereManagerImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageListeEnchereMesVentesServlet() {
		super();
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

		if (request.getParameter("Rechercher") != null) {

//			String rechercheArticle = request.getParameter("rechercheArticle");
//			Integer noCategorie = Integer.parseInt(request.getParameter("categorie"));
//			Categorie categorie = null;
//			String etatVente = "commence"; 
//
//			try {
//				categorie = managerCategorie.categorieById(noCategorie);
//				// System.out.println(categorie);
//				// System.out.println("article saisie "+rechercheArticle);
//				if (rechercheArticle == "") {
//					if (noCategorie == 0) {
//						modelArticle.setListeArticles(managerArticle.getAllVenteCommence());
//								
//					} else {
//						
//						//modelArticle.setListeArticles(managerArticle.getAllArticlesByCategories(categorie));
//						List<Article>lstArticlesCommence = managerArticle.getAllVenteCommence();
//						List<Article> lstCommenceParCategories = new ArrayList<Article>();
//						
//						for (Article article : lstArticlesCommence) {
//							
//							if (noCategorie == (article.getCategorie().getNoCategorie())) {
//								lstCommenceParCategories.add(article);
//							}
//						}
//							modelArticle.setListeArticles(lstCommenceParCategories);
//					}
//						
//				} else {
//					if (noCategorie == 0) {
//						List<Article>lstParMotCle = managerArticle.getAllArticleByNomMotCle(rechercheArticle);
//						List<Article>lstArticlesCommencesParMotCle = new ArrayList<Article>();
//						for (Article article : lstParMotCle) {
//							
//							if (etatVente.equals(article.getEtatVente())) {
//								
//								lstArticlesCommencesParMotCle.add(article);
//							}
//							modelArticle.setListeArticles(lstArticlesCommencesParMotCle);
//						}
//						
//					} else {
//						List<Article> listeArticlesNom = managerArticle.getAllArticleByNomMotCle(rechercheArticle);
//						List<Article> listeArticlebyNomByCategorie = new ArrayList<Article>();
//						List<Article>lstArticlesCommenceParNomParCategorie = new ArrayList<Article>();
//						for (Article article : listeArticlesNom) {
//							if (noCategorie == (article.getCategorie().getNoCategorie())) {
//								listeArticlebyNomByCategorie.add(article);
//							}
//							
//							for (Article article2 : listeArticlebyNomByCategorie) {
//								
//								if (etatVente.equals(article2.getEtatVente())) {
//									
//									lstArticlesCommenceParNomParCategorie.add(article);
//								}
//								
//							}
//						}
//						// System.out.println("Ma liste par article: "+listeArticlesNom);
//						// System.out.println("Ma liste par article/categorie:
//						// "+listeArticlebyNomByCategorie);
//						modelArticle.setListeArticles(lstArticlesCommenceParNomParCategorie);
//
//					}
//
//				}
//
//			} catch (BLLException e1) {
//				e1.printStackTrace();
//			}

			// Toutes les ventes existantes: cela sert à avoir une première liste sans les
			// filtres des checks boxs

			String rechercheArticle = request.getParameter("rechercheArticle");
			Integer noCategorie = Integer.parseInt(request.getParameter("categorie"));
			Categorie categorie = null;

			try {
				categorie = managerCategorie.categorieById(noCategorie);

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

			// Filtres des 3 checks boxs de Mes Ventes: c'est la liste récupérée au
			// dessus avec le profil connecté et les filtres des checks boxs

			List<Article> listeArticlesConnecte = new ArrayList<Article>();
			Utilisateur utilisateurConnecte = model.getUtilisateur();


			//mes ventes en cours
			for (Article article : modelArticle.getListeArticles()) {
				if (("commence").equals(article.getEtatVente())
						&& article.getUtilisateur().getNoUtilisateur() == utilisateurConnecte.getNoUtilisateur()
						&& request.getParameter("mesVentesEnCours") != null) {

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);

				}
			//mes ventes non debutées
				else if ((("cree").equals(article.getEtatVente())
						&& article.getUtilisateur().getNoUtilisateur() == utilisateurConnecte.getNoUtilisateur()
						&& request.getParameter("ventesNonDebutees") != null)) {

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);
				}
			//mes ventes terminées
				else if ((("termine").equals(article.getEtatVente())
						&& article.getUtilisateur().getNoUtilisateur() == utilisateurConnecte.getNoUtilisateur()
						&& request.getParameter("ventesTerminees") != null)) {

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);
				}

			}
			
			
			// Filtres des 3 checks boxs des Achats: c'est la 1ère liste des ventes récupérée au
				//dessus (nom+categorie) qui ont une enchère qui appartient au connecté, puis on filtre avec les checks boxs
			
			
			//enchères ouvertes
			
			for (Article article : modelArticle.getListeArticles()) {
				if (("commence").equals(article.getEtatVente())
						&& request.getParameter("encheresOuvertes") != null) {

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);
			// mes enchères
				}
				else if(request.getParameter("mesEncheres") != null) {
					
					//List<Enchere> listeMesEnchères = managerEnchere.selectionnerEnchereById(noCategorie)

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);
				}
			// mes enchères remportées
				else if(article.getUtilisateur().getNoUtilisateur() == utilisateurConnecte.getNoUtilisateur()
						
						&& request.getParameter("mesEncheres") != null) {

					listeArticlesConnecte.add(article);
					modelArticle.setListeArticles(listeArticlesConnecte);
				}
				
				
				
				
				
				
			}

		}

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
