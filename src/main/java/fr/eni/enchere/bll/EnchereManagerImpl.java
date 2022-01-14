package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.jdbc.EnchereDAOImpl;

public class EnchereManagerImpl implements EnchereManager {

	/** SINGLETON **/
	private static class EnchereManagerHolder {
		private static EnchereManager instance = new EnchereManagerImpl();
	}

	private EnchereManagerImpl() {
	}

	public static EnchereManager getInstance() {
		return EnchereManagerHolder.instance;
	}

	/** FIN SINGLETON **/

	private static EnchereDAO enchereDAO = new EnchereDAOImpl();
	private static BLLException BLLException = new BLLException();

	@Override
	public Enchere ajoutEnchere(Enchere enchere) throws BLLException {

		try {
			enchereDAO.insert(enchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException(e);
		}

		return null;
	}

	@Override
	public Enchere selectionnerEnchereById(Integer noEnchere) throws BLLException {

		try {
			return enchereDAO.getById(noEnchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> selectionnerToutesLesEncheres() throws BLLException {

		try {
			return enchereDAO.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> selectionnerEncheresParArticle(Integer noArticle) throws BLLException {

		try {
			return enchereDAO.getAllByArticle(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException(e);
		}

	}

	@Override
	public void modifierEnchere(Enchere EnchereAModifier) throws BLLException {

		try {
			enchereDAO.update(EnchereAModifier);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}

	}

}
