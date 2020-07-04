package aufgabe27;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Figuren.SpielFigur;
import tools.Spiel;

public class Billard extends Spiel{
	
	Color FELD_FARBE;
	LinkedList<BillardKugel> kugeln;
	java.awt.Rectangle rand;
	
	public static void main(String[] args) {
		starteAnwendung();
	}
	
	public Billard() {
		super("Billard", 1200,900);
		super.setBackground(new Color(139,69,19));
		FELD_FARBE = Color.GREEN.darker();
		
	}

	@Override
	protected void initialisiere() {
		kugeln = new LinkedList<BillardKugel>();
		rand = new java.awt.Rectangle();
		kugeln.add(new BillardKugel(Color.RED,500,400,this));
		kugeln.add(new BillardKugel(Color.BLACK,600,400,this));
		kugeln.add(new BillardKugel(Color.WHITE,700,400,this));
		
	}

	@Override
	protected void neuerSpielstand() {
		for(BillardKugel b: kugeln) {
			b.bewege();
		}
		
	}

	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		g.setColor(FELD_FARBE);
		g.fill(this.getRand());
		for(BillardKugel b: kugeln) {
			b.zeichne(g);
		}
		
	}
	
	public Rectangle getRand() {
		int delta = 80;
		rand.setBounds(getX()+delta,getY()+delta, getWidth()-2*delta, getHeight()-2*delta);;
		return rand;
	}

}
