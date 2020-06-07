package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import tools.Spiel;

public class DragAndDropFigur extends SpielFigur {
	
	private boolean wirdGezogen;

	public DragAndDropFigur(double xC, double yC, Spiel spiel) {
		super(xC,yC,40,40,spiel);
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(this.contains(e.getPoint())) {
			wirdGezogen = true;
		}
	}
		
	public void mouseReleased(MouseEvent e) {
		wirdGezogen = false;
	}
	public void mouseDragged(MouseEvent e) {
		if(wirdGezogen) {
			this.x = e.getPoint().x-20;
			this.y = e.getPoint().y-20;
		}
	}
	public void zeichne(Graphics2D g) {
		g.setColor(Color.red);
		g.fill(this);
		if(wirdGezogen) {
			g.setColor(Color.green);
			g.fill(this);
		}
	}
}
