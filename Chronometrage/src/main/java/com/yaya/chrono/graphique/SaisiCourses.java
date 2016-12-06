package com.yaya.chrono.graphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.yaya.chrono.entities.Competition;
import com.yaya.chrono.pojo.CourseForm;

public class SaisiCourses extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6331041629910044483L;
	
	private CourseForm coursesForm = new CourseForm();
	
	private List<Competition> listCompetition;
	
	public SaisiCourses(JFrame frame,String title, boolean modal,List<Competition> list){
		
		super(frame, title, modal);
		
		listCompetition = list;
		
		initComponent();
	}
	
	public CourseForm showDialog(){
		this.setVisible(true);
		return coursesForm;
	}
	
	public void initComponent(){
		
		this.setSize(new Dimension(300,200));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		JLabel nom = new JLabel("Nom");
		this.add(nom, gbc);
		
		Font police = new Font("Arial", Font.BOLD, 14);
	    
		final JTextField jTnom = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		jTnom.setFont(police);
		jTnom.setPreferredSize(new Dimension(150, 30));
		this.add(jTnom, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		JLabel distance = new JLabel("Distance");
		this.add(distance,gbc);
		
		final JTextField jTDistance = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		jTDistance.setFont(police);
		jTDistance.setPreferredSize(new Dimension(150, 30));
		this.add(jTDistance, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		JLabel competition = new JLabel("competition");
		this.add(competition,gbc);

		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		List<String> choix = new ArrayList<String>();
		for(Competition c : listCompetition)
			choix.add(c.getNom());
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox jCBlistCompetition = new JComboBox(choix.toArray());
		this.add(jCBlistCompetition, gbc);
		
		JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
			coursesForm = new CourseForm(jTnom.getText(),jTDistance.getText(),(String) jCBlistCompetition.getSelectedItem());
	        setVisible(false);
	      }
	    }); 
	    
	    gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(okBouton, gbc);
	    
	}

}
