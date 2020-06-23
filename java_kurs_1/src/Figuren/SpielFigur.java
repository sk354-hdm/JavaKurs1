package Figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import tools.Klang;
import tools.Spiel;

public class SpielFigur extends java.awt.geom.Rectangle2D.Double implements MouseListener, MouseMotionListener{
	
	protected static final java.awt.Stroke STRICH5 = new BasicStroke(5);
	protected Point2D.Double bewegung;
	protected Spiel spiel;
	
	public static final int RAND_IGNORIEREN = 0; 
	public static final int RAND_STOP = 1;
	public static final int RAND_ABPRALLEN = 2;
	
	protected int randReaktion = RAND_IGNORIEREN;
	protected Klang randReaktionsKlang;
	
	protected double daempfung = 1.0, masse =1.0;
	
	public SpielFigur(double xC, double yC, double breite, double höhe, Spiel spiel) {
		super(xC-breite/2, yC-höhe/2, breite, höhe);
		this.spiel = spiel;
		bewegung = new java.awt.geom.Point2D.Double();
		spiel.addMouseListener(this);
		spiel.addMouseMotionListener(this);
	
	}
	
	public void setBewegung(double vx,double vy) {
		bewegung.x = vx;
		bewegung.y = vy;
	}
	public void bewege() {
		this.x = this.x + bewegung.x;
		this.y = this.y + bewegung.y;
		
		if(randReaktion != RAND_IGNORIEREN) {
			Rectangle rand = spiel.getRand();
			if(!rand.contains(this)) {
				if(randReaktionsKlang != null) {
					randReaktionsKlang.play();
				}
			
		
		if(randReaktion == RAND_STOP) {
			this.bewegung.x = this.bewegung.y = 0;;
		}
		if(randReaktion == RAND_ABPRALLEN) {
			if(this.x<rand.x || this.x+this.width>rand.width+rand.x) bewegung.x = -bewegung.x;
			if(this.y<rand.y || this.y+this.height>rand.height+rand.y) bewegung.y = -bewegung.y;
		}
		
		}
	}
		
		bewegung.x = bewegung.x*daempfung;
		bewegung.y = bewegung.y*daempfung;
		
		this.amRandAusrichten();
		
	}
	public Point2D.Double getBewegung() {
		return bewegung;
	}
	public void zeichne(Graphics2D g) {
		g.setStroke(STRICH5);
		g.setColor(Color.GREEN);
		g.draw(this);
		
	}
	
	public void setRandReaktion(int reaktion, Klang klang) {
		this.randReaktionsKlang = klang;
		this.randReaktion = reaktion;
		
	}
	
	private void amRandAusrichten() {
		Rectangle spielRand = spiel.getRand();
		double deltaX = 0.0, deltaY = 0.0;
		if(spielRand.getMinX() > this.getMinX()) deltaX = spielRand.getMinX() - this.getMinX();
		if(spielRand.getMaxX() < this.getMaxX()) deltaX = spielRand.getMaxX() - this.getMaxX();
		if(spielRand.getMinY() > this.getMinY()) deltaY = spielRand.getMinY() - this.getMinY();
		if(spielRand.getMaxY() < this.getMaxY()) deltaY = spielRand.getMaxY() - this.getMaxY();
		this.x = this.x + deltaX;
		this.y = this.y + deltaY;

	}
	
	
	public void setDaempfung(double d) {
		daempfung = d;
	}
	
	public double getDaempfung(){
		return daempfung;
	}
	
	public void setMasse(double m) {
		masse = m;
	}
	
	public double getMasse() {
	return masse;
	}	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		}
}
