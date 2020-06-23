package aufgabe27;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import Figuren.SpielFigur;
import tools.Klang;
import tools.Spiel;

public class BilliardKugel extends SpielFigur {
	
	private Color QUEUE_FARBE;
	private BasicStroke QUEUE_STROKE;
	Ellipse2D.Double kugel;
	Color farbe;
	Klang QueueKlang;
	boolean zeigeQueue;
	Line2D.Double queue;

	public BilliardKugel(Color farbe, double xC, double yC, Spiel spiel) {
		super(xC, yC, 40, 40, spiel);
		kugel = new Ellipse2D.Double();
		queue = new Line2D.Double();
		QUEUE_FARBE = new Color(89,62,26);
		QUEUE_STROKE = new BasicStroke(9);
		QueueKlang = new Klang("/sound/billard_kugel_queue.mp3");
	}
	
	public void zeichne(Graphics2D g) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	

}
