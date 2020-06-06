package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import tools.Spiel;

public class MausOverFarbeFigur extends SpielFigur {
	
	private boolean mausInFigur;
	
	
	public MausOverFarbeFigur(double xC, double yC, Spiel spiel) {
		super(xC, yC, 40, 40, spiel);
		this.setBewegung(1,0);
		
	}
	
	
	public void zeichne(Graphics2D g) {
		g.setColor(Color.BLUE);
		if(mausInFigur) {
			g.setColor(Color.yellow);
		}
		g.fill(this);
		
		
			}
	
	public void mouseMoved(MouseEvent e) {
	mausInFigur = this.contains(e.getPoint());
}
}
