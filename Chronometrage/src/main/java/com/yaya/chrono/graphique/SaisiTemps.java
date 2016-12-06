package com.yaya.chrono.graphique;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SaisiTemps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5080241320991925700L;

	public SaisiTemps(){
		
	}
	
	public void paintComponent(Graphics g){
	    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
		int x1 = this.getWidth()/4;
	    int y1 = this.getHeight()/4;                      
	    g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
	  }   
}
