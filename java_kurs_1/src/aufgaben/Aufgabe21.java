package aufgaben;

import java.awt.Graphics2D;

import Figuren.GehZurMausFigur;
import tools.Spiel;

public class Aufgabe21 extends Spiel{
	
	GehZurMausFigur figur;
	
	public static void main(String []args) {
		starteAnwendung();
	}
	public Aufgabe21() {
		super("Aufgabe 21", 250, 250);
	}
	public void initialisiere() {
		this.figur = new GehZurMausFigur(this);
}
	public void zeichneSpielstand(Graphics2D g) {
		figur.zeichne(g);
	}
	public void neuerSpielstand() {
		figur.bewege();
	}
}
