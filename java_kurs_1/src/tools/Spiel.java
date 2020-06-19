package tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class Spiel extends StandardAnwendung implements ActionListener {
	
	 protected Timer timer;
	 
	 protected Spiel(String titel, int breite,int höhe) {
		 super(titel, breite, höhe);
		 this.setBackground(Color.BLACK);
		 timer = new Timer(40,this);
		 this.initialisiere();
		 timer.start();
		 }
	 
	 public final void actionPerformed (ActionEvent e) {
		 this.neuerSpielstand();
		 this.repaint();
	 }
	 
	 public final void zeichne(Graphics2D g) {
		 if(timer.isRunning()) {
			 this.zeichneSpielstand(g);
		 }
		 
		 }
	 
	 public Rectangle getRand () {
		 return this.getBounds();
	}
	 
	 protected abstract void initialisiere();
	 
	 protected abstract void neuerSpielstand();
	 
	 protected abstract void zeichneSpielstand(Graphics2D g);
	 
}
