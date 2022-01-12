package fr.eni.enchere.dal.mock;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOImplMock implements UtilisateurDAO {

	@Override
	public void insert(Utilisateur nouvelUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Utilisateur utilisateurAModifier) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectById(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
