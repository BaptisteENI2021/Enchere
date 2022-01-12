package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	/** SINGLETON **/
	private static class UtilisateurManagerHolder {
		private static UtilisateurManager instance = new UtilisateurManagerImpl();
	}

	private UtilisateurManagerImpl() {
	}

	public static UtilisateurManager getInstance() {
		return UtilisateurManagerHolder.instance;
	}

	/** FIN SINGLETON **/

	private static UtilisateurDAO dao = DAOFactory.getInstance();

	@Override
	public void inscrireUtilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse, Integer credit)
			throws BLLException {

		Utilisateur nouvelUtilisateur = null;
		BLLException be = new BLLException();

		validationNoUtilisateur(noUtilisateur, be);
		validationPseudo(pseudo, be);
		validationNom(nom, be);
		validationPrenom(prenom, be);
		validationEmail(email, be);
		validationTelephone(email, be);
		validationRue(rue, be);
		validationCodePostal(codePostal, be);
		validationVille(ville, be);
		validationMotDePasse(motDePasse, be);
		validationCredit(credit, be);

		try {
			dao.insert(nouvelUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void validationCredit(Integer credit, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationMotDePasse(String motDePasse, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationVille(String ville, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationCodePostal(String codePostal, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationRue(String rue, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationTelephone(String email, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationEmail(String email, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationPrenom(String prenom, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationNom(String nom, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationPseudo(String pseudo, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	private void validationNoUtilisateur(Integer noUtilisateur, BLLException be) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateurAModifier) throws BLLException {
		try {
			dao.update(utilisateurAModifier);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur afficherUtilisateur(Integer noUtilisateur) throws BLLException {
		try {
			return dao.selectById(noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public void supprimerUtilisateur(Integer noUtilisateur) throws BLLException {
		try {
			dao.delete(noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
