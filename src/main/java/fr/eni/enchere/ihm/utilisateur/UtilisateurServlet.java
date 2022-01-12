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
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();


    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		
		if(model==null) {
			model = new UtilisateurModel();
		}
		
		if(request.getParameter("enregistrer")!=null) {
			
			
			
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasseActuel = request.getParameter("motDePasseActuel");
			String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
			String confirmation = request.getParameter("confirmation");
			
			
			
			try {
				manager.inscrireUtilisateur(null, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, nouveauMotDePasse, 100);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Utilisateur utilisateur = new Utilisateur();
			
			model.setUtilisateur(utilisateur);
			model.setMessage("Crédit "+ utilisateur.getCredit());
			
		
			
		}
		
		
		
		
		
		
		request.setAttribute("model", model);					
		request.getRequestDispatcher("WEB-INF/PageCrerCompte.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
