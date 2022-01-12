package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public class TestBll {

	public static void main(String[] args) {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();

		UtilisateurManager manager = UtilisateurManagerImpl.getInstance();

		try {
			listeUtilisateurs.add(manager.inscrireUtilisateur("StarHack", "Malalaniche", "Melanie", "melaniemalalaniche@gmail.com", "098765443",
					"rue des pommiers", "35000", "Rennes", "Pa$$w0rd", 1000));
			
			listeUtilisateurs.add(manager.inscrireUtilisateur("ehoheho", "Beausapin", "Edmond", "edmondbeausapin@gmail.com", "4721380938",
					"allée des fruits", "69000", "Lyon", "Pa$$w0rd", 6987));
			
			listeUtilisateurs.add(manager.inscrireUtilisateur("xx-JCdu34-xx", "Cérien", "Jean", "jeancérien@gmail.com", "487930667",
					"boulevard Pompidou", "34000", "Montpelier", "azerty", 456));

			
			System.out.println(manager.getAllUtilisateurs());
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

}
