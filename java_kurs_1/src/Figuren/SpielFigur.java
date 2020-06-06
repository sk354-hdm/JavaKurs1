package Figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import tools.Spiel;

public class SpielFigur extends java.awt.geom.Rectangle2D.Double implements MouseListener, MouseMotionListener{
	
	protected static final java.awt.Stroke STRICH5 = new BasicStroke(5);
	protected Point2D.Double bewegung;
	protected Spiel spiel;

	
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
	}
	public Point2D.Double getBewegung() {
		return bewegung;
	}
	public void zeichne(Graphics2D g) {
		g.setStroke(STRICH5);
		g.draw(this);
		
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
