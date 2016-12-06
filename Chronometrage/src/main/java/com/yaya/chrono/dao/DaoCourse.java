package com.yaya.chrono.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

import com.yaya.chrono.entities.Competition;
import com.yaya.chrono.entities.Course;

public class DaoCourse {

	private Session session;
	
	public DaoCourse(Session session){
		this.session = session;
	}
	
	public Course save(Course course){
		session.save(course);
		return course;
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getAll(){
		return session.createQuery("From "+Course.class.getName()).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getByCompetition(Competition competition){
		return session.createCriteria(Course.class).add(Restrictions.eq("competition", competition)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}
