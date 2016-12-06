package com.yaya.chrono.controleur;

import com.yaya.chrono.dao.DaoCompetition;
import com.yaya.chrono.database.Connexion;

public class CompetitionControleur {

	DaoCompetition daoCompetition;
	
	public CompetitionControleur(){
		daoCompetition = new DaoCompetition(Connexion.configureSessionFactory());
	}
	
	
}
