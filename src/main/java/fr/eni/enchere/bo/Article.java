package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Article {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer prixInitial;
	private Integer noUtilisateur;
	private Integer noCategorie;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer prixInitial, Integer noUtilisateur, Integer noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	@Override
	public String toString() {
		return String.format(
				"ArticleVendu [noArticle=%s, nomArticle=%s, description=%s, dateDebutEncheres=%s, dateFinEncheres=%s, prixInitial=%s, noUtilisateur=%s, noCategorie=%s]",
				noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noUtilisateur,
				noCategorie);
	}

	
}
