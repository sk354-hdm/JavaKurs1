package aufgabe35;

import java.awt.Graphics2D;
import java.util.LinkedList;

import Figuren.SpielFigur;
import tools.Spiel;

public class AffineSpiel extends Spiel{
	
	private LinkedList<SpielFigur> figuren = new LinkedList<SpielFigur>();
	
	public static void main(String[] args) {
		starteAnwendung();
	}

	public AffineSpiel() {
		super("Affine Figuren",450, 450);
		sk354Figur figur = new sk354Figur(100,100,this);
		figuren.add(figur);
	}

	@Override
	protected void initialisiere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void neuerSpielstand() {
		for (SpielFigur f:figuren) f.bewege();
		}

	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		for(SpielFigur f:figuren) f.zeichne(g);
		
	}

}
