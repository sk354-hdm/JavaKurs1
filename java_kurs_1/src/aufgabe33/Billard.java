package aufgabe32;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Figuren.FigurReaktion;
import Figuren.SpielFigur;
import tools.Klang;
import tools.Spiel;

public class Billard extends Spiel {
	
	private static final Color FELD_FARBE = Color.GREEN.darker();
	private LinkedList<BillardKugel> kugeln;
	private LinkedList<FigurReaktion> reaktionen;
	private LinkedList<BillardLoch> loecher;
	private Rectangle rand;
	private final Font FONT_GROSS = new Font("SansSerif",Font.BOLD,25);
	private double gesamtBewegung;
	private int punkteLinks,punkteRechts,punkteVorDemZug;
	private boolean linksIstAmZug, weisseKugelVersenkt;
	

	public static void main(String[] args) {
		starteAnwendung();
	}

	public Billard() {
		super("Billard",1400,900);
		this.setBackground(new Color(139,69,19));
	}

	@Override
	protected void initialisiere() {
		Klang atmo = new Klang("/sound/atmo_bar.mp3");
		atmo.setBasisPegel(0.5);
		atmo.loop();
		this.timer.setDelay(10);
		rand = new Rectangle();

		kugeln = new LinkedList<BillardKugel>();
		kugeln.add(new BillardKugel(Color.WHITE,400,400,this));
		double x=900, y, y0=400, distanz=41;
		Color farbe = Color.CYAN;
		for(int reihe=0; reihe<5; reihe++){
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

		reaktionen= new LinkedList<FigurReaktion>();
		for(int i=0;i< kugeln.size()-1;i++){
			for(int j=i+1;j< kugeln.size();j++){
				reaktionen.add(new ElastischerStoss(kugeln.get(i), kugeln.get(j)));
			}
		}	
		
		loecher = new LinkedList<BillardLoch>();
		loecher.add(new BillardLoch(BillardLoch.LINKS, BillardLoch.OBEN, this));
		loecher.add(new BillardLoch(BillardLoch.MITTE, BillardLoch.OBEN, this));
		loecher.add(new BillardLoch(BillardLoch.RECHTS, BillardLoch.OBEN, this));
		loecher.add(new BillardLoch(BillardLoch.LINKS, BillardLoch.UNTEN, this));
		loecher.add(new BillardLoch(BillardLoch.MITTE, BillardLoch.UNTEN, this));
		loecher.add(new BillardLoch(BillardLoch.RECHTS, BillardLoch.UNTEN, this));
		
		for(BillardLoch loch:loecher) {
			for(BillardKugel kugel:kugeln) {
				reaktionen.add(new BillardLochReaktion(loch, kugel));
			}
		}
	}

	@Override
	protected void neuerSpielstand() {
		
		for(SpielFigur f:kugeln) f.bewege();
		for(FigurReaktion s:reaktionen) s.reagiere();
		double bewegungVorher = gesamtBewegung;
		gesamtBewegung = 0;
		for(BillardKugel f: kugeln) {
			gesamtBewegung += f.getBewegung().distance(0,0);
		}
		boolean spielZugZuende = bewegungVorher>=0.1 && gesamtBewegung<0.1;
		if(spielZugZuende && (weisseKugelVersenkt || punkteLinks + punkteRechts == punkteVorDemZug)) {
			if(linksIstAmZug) {
				linksIstAmZug = false;
			} else {
				linksIstAmZug = true;
			}
			punkteVorDemZug = punkteLinks + punkteRechts;
			weisseKugelVersenkt = false;
		}
	}

	@Override
	public Rectangle getRand() {
		int delta=80;
		rand.setBounds(getX()+delta, getY()+delta, getWidth()-2*delta, getHeight()-2*delta);
		return rand;
	}

	@Override
	protected void zeichneSpielstand(Graphics2D g) {
		
		g.setColor(istSpielenErlaubt()?Color.WHITE:Color.GRAY);
		g.setFont(FONT_GROSS);
		g.drawString("Links: " + punkteLinks, 80, 50);
		g.drawString("Rechts: " + punkteRechts , 1220, 50);
		
		if((punkteLinks + punkteRechts) < 15) {
		g.drawString(linksIstAmZug?"Links ist am Zug":"Rechts ist am Zug.", 580, 50);
		} else if(punkteLinks>punkteRechts){
			g.setColor(Color.RED);
			g.drawString("GAME OVER. Links hat gewonnen", 450, 450);
		} else {
			g.setColor(Color.RED);
			g.drawString("GAME OVER. Rechts hat gewonnen", 450,450); 
		}
		
		g.setColor(FELD_FARBE);
		g.fill(this.getRand());
		for(SpielFigur f:kugeln) f.zeichne(g);
		for(BillardLoch loch:loecher) loch.zeichne(g);
		
	}
	
	public void kugelEingelocht(BillardKugel kugel) {
		if(kugel.getFarbe().equals(Color.WHITE)) {
			weisseKugelVersenkt = true;
		} else {
			if(linksIstAmZug) {
				punkteLinks++;
			}else {
				punkteRechts++;
			}
		}
	}
	
	public boolean istSpielenErlaubt() {
		if(gesamtBewegung<0.1 && (punkteLinks + punkteRechts) < 15) {
			return true;
		}
		return false;
	}
	
	
	
	
	
}