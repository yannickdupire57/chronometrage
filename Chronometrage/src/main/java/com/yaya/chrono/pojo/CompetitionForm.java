package com.yaya.chrono.pojo;

import java.util.Date;

public class CompetitionForm {
	private String nom;
	
	private String ville;
	
	private Date date;
	
	public CompetitionForm(){
		
	}
	
	public CompetitionForm(String nom, String ville, Date date) {
		this.nom = nom;
		this.ville = ville;
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
