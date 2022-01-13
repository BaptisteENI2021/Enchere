package fr.eni.enchere.ihm.utilisateur;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurCreerServlet")
public class UtilisateurCreerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurCreerServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		String WEBINF = "WEB-INF/PageCreerCompte.jsp";

		if (model == null) {
			model = new UtilisateurModel();
		}

		if (request.getParameter("creer") != null) {

			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");

			String confirmation = request.getParameter("confirmation");

			try {
				if (!confirmation.equals(motDePasse)) {
					model.setMessage("La confirmation du mot de passe est différente du mot de passe");

				} else {
					Utilisateur utilisateur = manager.inscrireUtilisateur(pseudo, nom, prenom, email, telephone, rue,
							codePostal, ville, motDePasse, 100);

					model.setUtilisateur(utilisateur);

					System.out.println("contact créé");

					WEBINF = "/EssaiServlet";

				}

			} catch (BLLException e) {
				System.out.println("pas de contact");
				e.printStackTrace();
				model.setMessage(e.getMessage());

			}

		}

		System.out.println(request.getParameter("annuler") != null);

		if (request.getParameter("annuler") != null) {
			WEBINF = "/EssaiServlet";
			System.out.println("J'ai appuyé sur annuler");
		}

		request.setAttribute("model", model);
		request.getRequestDispatcher(WEBINF).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
