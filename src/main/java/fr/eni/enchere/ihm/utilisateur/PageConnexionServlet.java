package fr.eni.enchere.ihm.utilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerImpl;

/**
 * Servlet implementation class PageConnexionServlet
 */
@WebServlet("/PageConnexionServlet")
public class PageConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		String WEBINF = "WEB-INF/PageConnexion.jsp";
		
		if (request.getParameter("CreerUnCompte") != null) {
			WEBINF = "UtilisateurCreerServlet";
		}
		
		
		
		request.setAttribute("model", model);
		request.getRequestDispatcher(WEBINF).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
