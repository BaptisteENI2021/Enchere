/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;

/**
 * Classe en charge de
 * 
 * @author jdonal2021
 * @date 13 janv. 2022 - 10:17:25
 * @version Enchere - V0.1
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private final static String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres,"
			+ " date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";

	private static final String UPDATE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

	@Override
	public void insert(Article nouvelArticle) throws DALException {

		try (Connection con = JdbcTools.getConnection()) {

			PreparedStatement pStmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nouvelArticle.getNomArticle());
			pStmt.setString(2, nouvelArticle.getDescription());
			pStmt.setDate(3, Date.valueOf(nouvelArticle.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(nouvelArticle.getDateFinEncheres()));
			pStmt.setInt(5, nouvelArticle.getPrixInitial());
			pStmt.setInt(6, nouvelArticle.getPrixInitial());
			// TODO: modifier et mettre prix de vente
			pStmt.setInt(7, nouvelArticle.getUtilisateur().getNoUtilisateur());
			pStmt.setString(8, nouvelArticle.getCategorie().getLibelle());
			;
			// TODO: modifier setString en setInt et get.Libelle par getNo

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				nouvelArticle.setNoArticle(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public void update(Article articleAModifier) throws DALException {

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			pStmt.setString(1, articleAModifier.getNomArticle());
			pStmt.setString(2, articleAModifier.getDescription());
			pStmt.setDate(3, Date.valueOf(articleAModifier.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(articleAModifier.getDateFinEncheres()));
			pStmt.setInt(5, articleAModifier.getPrixInitial());
			pStmt.setInt(6, articleAModifier.getPrixInitial());
			// TODO: modifier et mettre prix de vente
			pStmt.setInt(7, articleAModifier.getUtilisateur().getNoUtilisateur());
			pStmt.setString(8, articleAModifier.getCategorie().getLibelle());
			// TODO: modifier setString en setInt et get.Libelle par getNo
			pStmt.setInt(9, articleAModifier.getNoArticle());

			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public void delete(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public Article selectById(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByUtilisateurVendeur(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByCategorie(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
