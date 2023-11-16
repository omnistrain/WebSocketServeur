package fr.formation.models;

import java.io.Serializable;

public class Formation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String nom;
	private String description;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
