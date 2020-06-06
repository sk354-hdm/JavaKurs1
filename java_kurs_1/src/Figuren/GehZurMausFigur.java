package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GehZurMausFigur extends java.awt.geom.Rectangle2D.Double implements MouseListener{
	
	java.awt.Point zielPunkt;
		
		
	public GehZurMausFigur(JPanel panel) {
		
		zielPunkt = new java.awt.Point(200,200);
		this.height = 40;
		this.width = 40;
		panel.addMouseListener(this);
	}
	
	public void zeichne (Graphics2D g) {
		
		g.setColor(Color.green);
		g.fill(this);
	}
	
	public void bewege() {
		this.x = this.x + (zielPunkt.getX()-this.x)/10;
		this.y = this.y +(zielPunkt.getY()-this.y)/10;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.zielPunkt = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

	 
}

	
