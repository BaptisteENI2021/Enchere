package fr.eni.enchere.bo;

public class Categorie {

	private Integer noCategorie;
	private String libelle;

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Integer getNo_categorie() {
		return noCategorie;
	}

	public void setNo_categorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return String.format("Categorie [noCategorie=%s, libelle=%s]", noCategorie, libelle);
	}

}
