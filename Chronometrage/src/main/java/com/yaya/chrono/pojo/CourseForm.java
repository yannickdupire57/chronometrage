package com.yaya.chrono.pojo;

public class CourseForm {
	private String nom;
	
	private String distance;
	
	private String competition;
	
	public CourseForm(){
		
	}
	
	public CourseForm(String nom, String distance, String competition) {
		this.nom = nom;
		this.distance = distance;
		this.competition = competition;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	
	
}
