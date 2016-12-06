package com.yaya.chrono.dao;

import java.util.List;

import org.hibernate.Session;

import com.yaya.chrono.entities.Competition;

public class DaoCompetition {
	private Session session;
	
	public DaoCompetition(Session session){
		this.session = session;
	}
	
	public Competition save(Competition competition){
		session.getTransaction().begin();
		session.persist(competition);
		session.getTransaction().commit();
		return competition;
	}
	
	@SuppressWarnings("unchecked")
	public List<Competition> getAll(){
		List<Competition> list = (List<Competition>) session.createQuery("From "+Competition.class.getName()).list();
		return list;
	}
}
