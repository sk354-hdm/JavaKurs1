package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import tools.Spiel;

public class MausOverHellerFigur extends SpielFigur{
	
	private Color farbeDunkel;
	private Color farbeHell;
	
	public MausOverHellerFigur(double xC, double yC,Color farbe, Spiel spiel) {
		super(xC,yC, 40, 40, spiel);
		this.setBewegung(1,0);
		farbeDunkel = farbe.darker();
		farbeHell = farbe.brighter().brighter();
		
	}
	
	public void zeichne(Graphics2D g) {
		g.setColor(farbeDunkel);
		g.fill(this);
		Point mausPos = spiel.getMousePosition();
		if(mausPos != null && this.contains(mausPos)){
			g.setColor(farbeHell);
			g.fill(this); 
		}
	}
	
}
