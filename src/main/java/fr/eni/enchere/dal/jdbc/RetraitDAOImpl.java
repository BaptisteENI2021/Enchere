package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO {
	
	
//	CREATE TABLE RETRAITS (
//			no_article       INTEGER NOT NULL,
//		    rue              VARCHAR(30) NOT NULL,
//		    code_postal      VARCHAR(15) NOT NULL,
//		    ville            VARCHAR(30) NOT NULL
//		)
//	
	
	
	private final static String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?,?)";
	

	@Override
	public void insert(Retrait nouveuRetrait) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Retrait retraitAModifier) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Retrait> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retraitByNoArticle(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub

	}

}
