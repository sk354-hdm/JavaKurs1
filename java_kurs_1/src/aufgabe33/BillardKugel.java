package aufgabe32;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import Figuren.SpielFigur;
import tools.Klang;
import tools.Spiel;

public class BillardKugel extends SpielFigur{
	
	private static final Color QUEUE_FARBE = new Color(89,62,26);
	private static final BasicStroke QUEUE_STROKE = new BasicStroke(9);
	private Ellipse2D.Double kugel =new Ellipse2D.Double();
	private Color farbe;
	private static Klang queueKlang = new Klang("/sound/billard_kugel_queue.mp3");
	private static Klang randKlang = new Klang("/sound/billard_kugel_rand.mp3");
	private boolean zeigeQueue = false;
	private Line2D.Double queue = new Line2D.Double();
	
	public BillardKugel(Color farbe, double x, double y, Spiel spiel) {		
			super(x, y, 40, 40, spiel);
			this.farbe = farbe;
			this.setRandReaktion(RAND_ABPRALLEN,randKlang);
			this.setDaempfung(0.99);
	
	}
	@Override
	public void zeichne(Graphics2D g) {
		if(this.zeigeQueue) {
			g.setStroke(QUEUE_STROKE);
			g.setColor(QUEUE_FARBE);
			this.queue.x2 = this.getCenterX();
			this.queue.y2 = this.getCenterY();
			g.draw(queue);
		}
		this.kugel.setFrame(this);
		g.setColor(this.farbe);
		g.fill(kugel);
	}
	
	public Color getFarbe() {
		return this.farbe;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(((Billard)spiel).istSpielenErlaubt()) {
			if(Color.WHITE==this.farbe && this.contains(e.getPoint())) {
				this.zeigeQueue = true;
				this.queue.x1 = e.getX();
				this.queue.y1 = e.getY();			
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(((Billard)spiel).istSpielenErlaubt()) {
			if(zeigeQueue) {
				final double FAKTOR = 0.13;
				this.bewegung.x = FAKTOR*(this.queue.x2-this.queue.x1);
				this.bewegung.y = FAKTOR*(this.queue.y2-this.queue.y1);
				BillardKugel.queueKlang.play(0.03*this.bewegung.distance(0,0));
			}
			zeigeQueue = false;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.queue.x1 = e.getX();
		this.queue.y1 = e.getY();			
	}
}