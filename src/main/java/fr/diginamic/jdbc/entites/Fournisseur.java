package fr.diginamic.jdbc.entites;

public class Fournisseur {
	private String nom;
	private int id;
	
	public Fournisseur(String nom, int id) {
		this.nom = nom;
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
