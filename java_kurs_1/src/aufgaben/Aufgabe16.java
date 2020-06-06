package aufgaben;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Figuren.PlaySymbol;
import tools.StandardAnwendung;

public class Aufgabe16 extends StandardAnwendung implements MouseMotionListener {
	
	int xyPos = 10;
	private PlaySymbol play = new PlaySymbol();
	
	
		public static void main(String[]args) {
		starteAnwendung();
	}
	
		
	public Aufgabe16() {
		super("Aufgabe 16",500,400);
		this.setBackground(Color.RED);
		this.addMouseMotionListener(this);
		}
	
	
	
	public void zeichne(Graphics2D g) {
		g.fillRect(xyPos-50, xyPos, 30, 30);
		xyPos = (xyPos+1) % this.getWidth();
		play.zeichne(g, xyPos, xyPos);
	}
	
	public void mouseMoved(MouseEvent e) {
		xyPos = xyPos + 1;
		this.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}

}
