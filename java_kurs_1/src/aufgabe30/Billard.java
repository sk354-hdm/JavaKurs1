package aufgabe30;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import tools.Klang;
import tools.Spiel;

public class Billard extends Spiel{
	
	Color FELD_FARBE;
	LinkedList<BillardKugel> kugeln;
	java.awt.Rectangle rand;
	LinkedList<ElastischerStoss> reaktionen;
	
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
		
		timer.setDelay(10);
		
		Klang bg = new Klang("/sound/atmo_bar.mp3");		//Hintergrundgeräusch
		bg.setBasisPegel(0.5);
		bg.loop();
		
		kugeln = new LinkedList<BillardKugel>();            //Initialisierung der Kugeln
		rand = new java.awt.Rectangle();
		
		double x=400, y, y0=400, distanz=41;    
		Color farbe = Color.WHITE;
		
		for(int reihe=0; reihe<5; reihe++){                  //Aufstellung der Kugeln
			if(reihe>3) farbe=Color.BLUE;
				else if(reihe>2) farbe=Color.MAGENTA;
				else if(reihe>1) farbe=Color.YELLOW;
				else if(reihe>0) farbe=Color.RED;
						y = y0-reihe*distanz/2.0;
						
		for(int j=0; j<=reihe; j++){
			kugeln.add(new BillardKugel(farbe, x, y, this));
			y = y+distanz;
		}
		x = x+distanz;
		} 
		
		reaktionen = new LinkedList<ElastischerStoss>();    //Initialisierung der reaktionen
		
		for(int i = 0; i < kugeln.size() -1; i++) {
			for(int j = i+1; j < kugeln.size(); j++) {
				reaktionen.add(new ElastischerStoss(kugeln.get(i), kugeln.get(j)));
			}
		}
		
	}

	@Override
	protected void neuerSpielstand() {
		
		for(BillardKugel b: kugeln) {
			b.bewege();
		}
		
		for(ElastischerStoss r: reaktionen) {
			r.reagiere();
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
