package Figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import tools.Klang;
import tools.Spiel;

public class SpielFigur extends Rectangle2D.Double implements MouseListener, MouseMotionListener {

	public static final int RAND_IGNORIEREN=0, RAND_STOP=1, RAND_ABPRALLEN=2;

	protected static final Stroke STRICH5 = new BasicStroke(5);
	
	protected Point2D.Double bewegung;
	protected Spiel spiel;

	protected int randReaktion = RAND_IGNORIEREN;
	protected Klang randReaktionsKlang;
	protected double masse=1.0, daempfung=1.0;

	
	public SpielFigur(double xC, double yC, double breite, double hoehe, Spiel spiel) {
		super(xC-breite/2, yC-hoehe/2, breite, hoehe);
		this.spiel = spiel;
		bewegung = new Point2D.Double();
		spiel.addMouseListener(this);
		spiel.addMouseMotionListener(this);
	}
	
	public void setBewegung(double vx, double vy) {
		this.bewegung.x = vx;
		this.bewegung.y = vy;
	}
	
	public Point2D.Double getBewegung(){
		return this.bewegung;
	}
		
	public void setRandReaktion(int reaktion, Klang klang) {
		this.randReaktion = reaktion;
		this.randReaktionsKlang = klang;
	}
	
	public void setMasse(double masse) {
		this.masse = masse;
	}
	
	public double getMasse() {
		return this.masse;
	}

	public void setDaempfung(double daempfung) {
		this.daempfung = daempfung;
	}

	public double getDaempfung() {
		return this.daempfung;
	}
	
	public Spiel getSpiel() {
		return this.spiel;
	}
	
	public void bewege() {
		this.x = this.x + this.bewegung.x;
		this.y = this.y + this.bewegung.y;
		
		
		
	    if(randReaktion != RAND_IGNORIEREN){
	    	
	    	 Rectangle rand = spiel.getRand();
	    	 
	    	 if(!rand.contains(this)){ 
	    		 if(randReaktionsKlang!=null)  randReaktionsKlang.play(0.03*this.bewegung.distance(0,0));
	    		 
	    		 if(randReaktion==RAND_STOP){
	    	         this.bewegung.x = this.bewegung.y = 0;
	    		 }
	    		 
	    		 if(randReaktion==RAND_ABPRALLEN){
	    			 if(this.x<rand.x || this.x+this.width>rand.width+rand.x) bewegung.x = -bewegung.x;
	    			 if(this.y<rand.y || this.y+this.height>rand.height+rand.y) bewegung.y = -bewegung.y; 
	    		 }
	    		 
	    		 this.amRandAusrichten();
	    	 }
	    }
	    
	    
	    this.bewegung.x = this.bewegung.x*daempfung;
	    this.bewegung.y = this.bewegung.y*daempfung;
	}
	
	/**
	 * Positioniert Spielfiguren, die ueber den Rand hinausragen, genau an den Rand.
	 */
	 private void amRandAusrichten(){
	    Rectangle spielRand = spiel.getRand();
		double deltaX = 0.0, deltaY = 0.0;
		if(spielRand.getMinX() > this.getMinX()) deltaX = spielRand.getMinX() - this.getMinX();
		if(spielRand.getMaxX() < this.getMaxX()) deltaX = spielRand.getMaxX() - this.getMaxX();
		if(spielRand.getMinY() > this.getMinY()) deltaY = spielRand.getMinY() - this.getMinY();
		if(spielRand.getMaxY() < this.getMaxY()) deltaY = spielRand.getMaxY() - this.getMaxY();
		this.x = this.x + deltaX;
		this.y = this.y + deltaY;
	}

	
	public void zeichne(Graphics2D g) {
		g.setStroke(STRICH5);
		g.setColor(Color.GREEN);
		g.draw(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {	}
	@Override
	public void mouseMoved(MouseEvent arg0) { }
	@Override
	public void mouseClicked(MouseEvent arg0) {	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	}
	@Override
	public void mouseExited(MouseEvent arg0) {	}
	@Override
	public void mousePressed(MouseEvent arg0) {	}
	@Override
	public void mouseReleased(MouseEvent arg0) { }
}