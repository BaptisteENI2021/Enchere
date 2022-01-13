package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private String libelle;
	private Integer noCategorie;
	private List<Article> listeArticles = new ArrayList<>();

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(String libelle, List<Article> listeArticles, Integer noCategorie) {
		super();
		this.libelle = libelle;
		this.listeArticles = listeArticles;
		this.noCategorie = noCategorie;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
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
		return String.format("Categorie [libelle=%s, listeArticles=%s, noCategorie=%s]", libelle, listeArticles);
	}

}
