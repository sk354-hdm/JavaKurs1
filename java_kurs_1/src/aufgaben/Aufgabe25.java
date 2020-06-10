package aufgaben;

import java.awt.Graphics2D;

import Figuren.ZielFigur;
import tools.Spiel;

public class Aufgabe25 extends Spiel {
	
	public static void main(String[] args) {
		starteAnwendung();
	}
	
	ZielFigur figur1;

	public Aufgabe25() {
		super("Aufgabe 25", 500, 500);
		
	}

	@Override
	protected void initialisiere() {
		figur1 = new ZielFigur(100, 100, this);
		
	}

	@Override
	protected void neuerSpielstand() {
		figur1.bewege();
		
	}

	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		figur1.zeichne(g);
		
	}
	
	
		
}
