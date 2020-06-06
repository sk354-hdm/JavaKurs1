package Figuren;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class FolgeDerMausFigur extends Ellipse2D.Double implements MouseMotionListener{
	
	public FolgeDerMausFigur(JPanel panel) {
		
		this.height = 40;
		this.width = 40;
		this.x = 0;
		this.y = 0;
		panel.addMouseMotionListener(this);
	}
	
	public void zeichne(Graphics2D g) {
		g.setBackground(Color.YELLOW);
		g.fill(this);
		
	}
	
	public void bewege() {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.x = e.getX() -20;
		this.y = e.getY() -20;
	}

}
