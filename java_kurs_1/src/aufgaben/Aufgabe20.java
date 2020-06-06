package aufgaben;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Figuren.FolgeDerMausFigur;
import Figuren.GehZurMausFigur;
import tools.StandardAnwendung;

public class Aufgabe20 extends StandardAnwendung implements ActionListener {
	
		GehZurMausFigur figur1 = new GehZurMausFigur(this);
		FolgeDerMausFigur figur2 = new FolgeDerMausFigur(this);
		
		public static void main( String[] args){
			starteAnwendung();
		}
			
		
			public Aufgabe20() {
				super("Aufgabe 20",500,500);
				Timer tick = new Timer(40,this);
				tick.start();
				this.setBackground(Color.black);
			}

	
			public void actionPerformed(ActionEvent e) {
				figur1.bewege();
				figur2.bewege();
				this.repaint();
			}
			public void zeichne (Graphics2D g) {
				figur1.zeichne(g);
				figur2.zeichne(g);
			}

}
