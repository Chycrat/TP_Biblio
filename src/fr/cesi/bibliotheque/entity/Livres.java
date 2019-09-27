package fr.cesi.bibliotheque.entity;

public class Livres {
	private Long id;
	private String Titre;
	private String Auteur;
	private String Edition;
		
	public Livres(Long id, String titre, String auteur, String edition) {
		super();
		this.id = id;
		Titre = titre;
		Auteur = auteur;
		Edition = edition;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public String getEdition() {
		return Edition;
	}
	public void setEdition(String edition) {
		Edition = edition;
	}
}
