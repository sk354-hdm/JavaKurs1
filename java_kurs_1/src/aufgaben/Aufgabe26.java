package aufgaben;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import Figuren.SpielFigur;
import Figuren.ZufallsFigur;
import tools.Spiel;

public class Aufgabe26 extends Spiel implements MouseListener{
	
	private LinkedList <ZufallsFigur> figuren;
	private Rectangle rand;
	
	public static void main(String[] args) {
		starteAnwendung();
	}
	
	
	public Aufgabe26() {
		super("Aufgabe 26", 500,500);
		this.addMouseListener(this);
	}
	

	@Override
	protected void initialisiere() {
		rand = new Rectangle();
		figuren = new LinkedList <ZufallsFigur>();
		
	}

	@Override
	protected void neuerSpielstand() {
		for(SpielFigur f: figuren) {
			f.bewege();
		}
		
	}

	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fill(this.getRand());
		for(SpielFigur f: figuren) {
			f.zeichne(g);
		}
		
	}
	
	@Override
	public Rectangle getRand() {
		int delta = 80;
		rand.setBounds(getX()+delta,getY()+delta, getWidth()-2*delta, getHeight()-2*delta);;
		return rand;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.getRand().contains(e.getPoint()) && e.getPoint() != null ) {
			
			figuren.add(new ZufallsFigur(e.getX(),e.getY(),this));
		
		}
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
