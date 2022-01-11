package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private String libelle;
	
	private List<Article> listeArticles = new ArrayList<>();

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(String libelle, List<Article> listeArticles) {
		super();
		this.libelle = libelle;
		this.listeArticles = listeArticles;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	@Override
	public String toString() {
		return String.format("Categorie [libelle=%s, listeArticles=%s]", libelle, listeArticles);
	}

	

}
