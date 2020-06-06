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
		wirdGezogen = this.contains(e.getPoint());
		}
		
	public void mouseReleasedn(MouseEvent e) {
		wirdGezogen = false;
	}
	public void MouseDraggen(MouseEvent e) {
		if(wirdGezogen) {
			this.x = e.getPoint().x-20;
			this.y = e.getPoint().y-20;
		}
	}
	public void zeichne(Graphics2D g) {
		g.setBackground(Color.red);
		g.fill(this);
		
		Point mausPos = spiel.getMousePosition();
		if(mausPos != null && this.contains(mausPos)) {
			g.setBackground(Color.green);
			g.fill(this);
		}
	}
}
