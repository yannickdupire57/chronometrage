package com.yaya.chrono.graphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.yaya.chrono.pojo.CompetitionForm;

public class SaisiCompetition extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6331041629910044483L;
	
	private CompetitionForm competitionForm = new CompetitionForm();
	
	public SaisiCompetition(JFrame frame,String title, boolean modal){
		
		super(frame, title, modal);
		
		initComponent();
	}
	
	public CompetitionForm showDialog(){
		this.setVisible(true);
		return competitionForm;
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
		JLabel ville = new JLabel("Ville");
		this.add(ville,gbc);
		
		final JTextField jTville = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		jTville.setFont(police);
		jTville.setPreferredSize(new Dimension(150, 30));
		this.add(jTville, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		JLabel date = new JLabel("Date");
		this.add(date,gbc);
		
		final JXDatePicker datePicker = new JXDatePicker();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		datePicker.setPreferredSize(new Dimension(150, 30));
		datePicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		this.add(datePicker, gbc);

		JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
			competitionForm = new CompetitionForm(jTnom.getText(),jTville.getText(),datePicker.getDate());
	        setVisible(false);
	      }
	    }); 
	    
	    gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		this.add(okBouton, gbc);
	    
	}

}
