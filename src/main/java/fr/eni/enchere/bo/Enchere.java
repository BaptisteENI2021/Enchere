package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Enchere {

	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Integer noArticle;
	private Integer noUtilisateur;

	public Enchere() {
		// TODO Auto-generated constructor stub
	}

	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere, Integer noArticle,
			Integer noUtilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	@Override
	public String toString() {
		return String.format(
				"Enchere [noEnchere=%s, dateEnchere=%s, montantEnchere=%s, noArticle=%s, noUtilisateur=%s]", noEnchere,
				dateEnchere, montantEnchere, noArticle, noUtilisateur);
	}

	
}