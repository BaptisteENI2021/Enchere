package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.EnchereDAOImpl;
import fr.eni.enchere.dal.jdbc.UtilisateurDAOImpl;

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
	private static ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
	private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();
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

	@Override
	public List<Enchere> selectionnerEnchereByNomMotCle(String libelle) throws BLLException {
		try {
			return enchereDAO.selectByNomArticle(libelle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public void Encherir(Utilisateur encherisseur, Article articleAEncherir, Integer maProposition)
			throws BLLException {

		// Article article = aricleAEncherir ;

		try {
//			if (articleDAO.selectById(articleAEncherir.getNoArticle()).getEtatVente().equals("commence")
//					&& articleDAO.selectById(articleAEncherir.getNoArticle()).getPrixDeVente() < maProposition
//					&& utilisateurDAO.selectById(encherisseur.getNoUtilisateur()).getCredit() > maProposition) {
				if(1<2) {
					
					System.out.println("je suis rentré dans le IF de la méthode enchérir");
					
				Enchere nouvelleEnchere = new Enchere(LocalDate.now(), maProposition, encherisseur, articleAEncherir);

				System.out.println("ma nouvelle enchère en détail: "+nouvelleEnchere);
				
				//Décréditer l'encherisseur
				encherisseur.setCredit(encherisseur.getCredit() - maProposition);
				utilisateurDAO.update(encherisseur);
			

				System.out.println("encherisseur après la baisse du crédit: " +encherisseur);
				
				//Gestion de l'ancienne meilleur enchère et de l'ancier meilleur encherisseur
				List<Enchere> lstEncheres = new ArrayList<Enchere>();
				Enchere ancienneMeilleureEnchere = new Enchere();
				Utilisateur ancienMeilleurEncherisseur = new Utilisateur();
				
				lstEncheres = enchereDAO.getAllByArticle(articleAEncherir.getNoArticle());
				
				if (lstEncheres != null) {
					for (Enchere enchere : lstEncheres) {
						if (enchere.isRemporte() == true) {
							ancienneMeilleureEnchere = enchere;
							
							System.out.println("l'ancienne meilleure enchère est: " + ancienneMeilleureEnchere);
							
							//on récupère l'acheteur de l'ancienne meilleure enchère
							ancienMeilleurEncherisseur = ancienneMeilleureEnchere.getUtilisateur();
							
							System.out.println("l'ancien meilleur encherisseur est: " +ancienMeilleurEncherisseur);
							//on recrédite l'ancien meilleur 
							ancienMeilleurEncherisseur.setCredit(
									ancienMeilleurEncherisseur.getCredit() + articleAEncherir.getPrixDeVente());
							utilisateurDAO.update(ancienMeilleurEncherisseur);
							ancienneMeilleureEnchere.setRemporte(false);
							enchereDAO.update(ancienneMeilleureEnchere);
						}
					}

				}
				//on modifie le prix de vente de l'article en lui mettant le montant de la nouvelle enchère
				articleAEncherir.setPrixDeVente(maProposition);
				articleDAO.update(articleAEncherir);
				
				ajoutEnchere(nouvelleEnchere);
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
