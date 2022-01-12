package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String INSERT = "INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse) VALUES (?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_BY_ID = "SELECT * FROM UTILISATEUR WHERE noArticle=?";

	@Override
	public void insert(Utilisateur nouvelUtilisateur) throws DALException, SQLException {

		try (Connection con = JdbcTools.getConnection()) {

			PreparedStatement stmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nouvelUtilisateur.getPseudo());
			stmt.setString(2, nouvelUtilisateur.getNom());
			stmt.setString(3, nouvelUtilisateur.getPrenom());
			stmt.setString(4, nouvelUtilisateur.getEmail());
			stmt.setString(5, nouvelUtilisateur.getTelephone());
			stmt.setString(6, nouvelUtilisateur.getRue());
			stmt.setString(7, nouvelUtilisateur.getCodePostal());
			stmt.setString(8, nouvelUtilisateur.getVille());
			stmt.setString(9, nouvelUtilisateur.getMotDePasse());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				nouvelUtilisateur.setNoUtilisateur(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

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
		Utilisateur utilisateur = null;

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, noUtilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				utilisateur = map(rs);

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return utilisateur;
	}

	private Utilisateur map(ResultSet rs) throws SQLException {
		int noUtilisateur = rs.getInt("noUtilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String codePostal = rs.getString("codePostal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("motDePasse");
		int credit = rs.getInt("credit");

		Utilisateur utilisateur = null;

		utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, credit);

		return utilisateur;
	}

}
