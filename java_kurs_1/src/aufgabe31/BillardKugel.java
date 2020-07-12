package aufgabe31;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import Figuren.SpielFigur;
import tools.Klang;
import tools.Spiel;

public class BillardKugel extends SpielFigur {
	
	private Color QUEUE_FARBE;
	private BasicStroke QUEUE_STROKE;
	Ellipse2D.Double kugel;
	Color farbe;
	Klang QueueKlang;
	boolean zeigeQueue;
	Line2D.Double queue;

	public BillardKugel(Color farbe, double xC, double yC, Spiel spiel) {
		super(xC, yC, 40, 40, spiel);
		this.farbe = farbe;
		this.setRandReaktion(RAND_ABPRALLEN, QueueKlang);
		this.setDaempfung(0.99);
		kugel = new Ellipse2D.Double();
		queue = new Line2D.Double();
		QUEUE_FARBE = new Color(89,62,26);
		QUEUE_STROKE = new BasicStroke(9);
		QueueKlang = new Klang("/sound/billard_kugel_queue.mp3");
	}
	
	public void zeichne(Graphics2D g) {
		if(zeigeQueue) {
			g.setStroke(QUEUE_STROKE);
			g.setColor(QUEUE_FARBE);
			queue.x2 = this.getCenterX();
			queue.y2 = this.getCenterY();
			g.draw(queue);
		}
		kugel.setFrame(this);
		g.setColor(farbe);
		g.fill(kugel);
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(Color.white.equals(farbe)) {
		
		if(this.contains(e.getPoint())) {
			zeigeQueue = true;
			queue.x1 = e.getX();
			queue.y1 = e.getY();
		}
	}
}
	
	public void mouseDragged(MouseEvent e) {
		queue.x1 = e.getX();
		queue.y1 = e.getY();
	}
	
	public void mouseReleased(MouseEvent e) {
		if(zeigeQueue) {
			bewegung.x = 0.12 * (queue.x2 - queue.x1);
			bewegung.y = 0.12 * (queue.y2 - queue.y1);
		}
		zeigeQueue = false;
		QueueKlang.play((bewegung.distance(0,0)*0.03));
	}
	
	public Color getFarbe() {
		return farbe;
	}
	

}
