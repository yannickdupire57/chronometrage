package com.yaya.chrono.graphique;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.yaya.chrono.dao.DaoCompetition;
import com.yaya.chrono.dao.DaoCourse;
import com.yaya.chrono.database.Connexion;
import com.yaya.chrono.entities.Competition;
import com.yaya.chrono.entities.Course;
import com.yaya.chrono.pojo.CompetitionForm;
import com.yaya.chrono.pojo.CourseForm;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4690329553231316904L;
	
	private CardLayout cl = new CardLayout();
	
	private JPanel jPprincipal = new JPanel();
	
	public FenetrePrincipale(int hauteur,int largeur,String titre){
		this.setTitle(titre);
	    this.setSize(largeur, hauteur);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    //this.setUndecorated(true);Pour retirer tous les boutons et les contours
	    initComposent();
	    this.setVisible(true);
	}
	
	public void initComposent(){
		
		jPprincipal.setLayout(cl);
		JPanel accueil = new JPanel();
	    
	    jPprincipal.add(accueil, "accueil");
	    cl.show(jPprincipal, "accueil");
	    this.setContentPane(jPprincipal);
		
	    initMenu();
	}
	
	public void showSaisiCompetition(){
		SaisiCompetition saisiCompetition = new SaisiCompetition(this, "Saisi compétition", true);
		CompetitionForm competitionForm = saisiCompetition.showDialog();
		DaoCompetition daoCompetition = new DaoCompetition(Connexion.configureSessionFactory());
		Competition competition = new Competition();
		competition.setDate(competitionForm.getDate());
		competition.setNom(competitionForm.getNom());
		competition.setVille(competitionForm.getVille());
		daoCompetition.save(competition);
	}
	
	@SuppressWarnings("unused")
	public void showSaisiCourses(){
		DaoCompetition daoCompetition = new DaoCompetition(Connexion.configureSessionFactory());
		SaisiCourses saisiCourses = new SaisiCourses(this, "Saisi course", true,daoCompetition.getAll());
		CourseForm courseForm = saisiCourses.showDialog();
		DaoCourse daoCourse = new DaoCourse(Connexion.configureSessionFactory());
		Course course = new Course();
		//course.setCompetition(competition);
		String test = "";
	}
	
	public void initMenu(){
		JMenuBar menuBar = new JMenuBar();
		 
		JMenu menuFichier = new JMenu("Fichier");
		
		JMenuItem nouveau = new JMenuItem("nouveau");
		nouveau.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				cl.show(jPprincipal, "accueil");
			}
		});
		menuFichier.add(nouveau);
		
		JMenu menuSaisi = new JMenu("Saisie");
 
		
		JMenuItem competition = new JMenuItem("Compétition");
		competition.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		    	showSaisiCompetition();
		    }
		});
		JMenuItem courses = new JMenuItem("Courses");
		courses.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		    	showSaisiCourses();
		    }
		});
		menuSaisi.add(competition);
		menuSaisi.add(courses);
		menuBar.add(menuFichier);
		menuBar.add(menuSaisi);
 
		setJMenuBar(menuBar);
	}
}
