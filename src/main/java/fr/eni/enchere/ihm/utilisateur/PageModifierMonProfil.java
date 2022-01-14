package fr.eni.enchere.ihm.utilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class PageModifierMonProfil
 */
@WebServlet("/PageModifierMonProfil")
public class PageModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageModifierMonProfil() {
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
		String WEBINF = "WEB-INF/PageModifierMonProfil.jsp";
		
		if (model == null) {
			model = new UtilisateurModel();
		}
		
		if (request.getParameter("enregistrer") != null) {

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

				}

			} catch (BLLException e) {
				e.printStackTrace();
				model.setMessage(e.getMessage());

			}

			if (request.getParameter("supprimer") != null) {
				WEBINF = "/PageAccueilNonConnecteServlet";
			}

			request.setAttribute("model", model);
			request.getRequestDispatcher("WEB-INF/PageModifierMonProfil.jsp").forward(request, response);
		}
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
