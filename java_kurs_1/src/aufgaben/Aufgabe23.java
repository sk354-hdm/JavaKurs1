package aufgaben;

import java.awt.Graphics2D;

import Figuren.KlangFigur;
import tools.Spiel;

public class Aufgabe23 extends Spiel {
	
	private KlangFigur c,cis,d,dis,e,f,fis,g,gis,a,ais,h,c1;
	
	public static void main (String [] args) {
		starteAnwendung();
	}
	
	public Aufgabe23() {
		super("Aufgabe 23", 200, 200);
		
	}
	
	protected void initialisiere() {
		
		this.c = new KlangFigur(false,"/sound/ton1.mp3", 100, 100, this);
		this.cis = new KlangFigur(true,"/sound/ton1.mp3",100,100,this);
		this.d = new KlangFigur(false,"/sound/ton2.mp3", 100, 100, this);
		this.dis = new KlangFigur(true,"/sound/ton2.mp3",100,100,this);
		this.e = new KlangFigur(false, "/sound/ton3.mp3", 100, 100, this);
		this.f = new KlangFigur(false,"/sound/ton4.mp3", 100, 100, this);
		this.fis = new KlangFigur(true,"/sound/ton4.mp3",100,100,this);
		this.g = new KlangFigur(false,"/sound/ton5.mp3", 100, 100, this);
		this.gis = new KlangFigur(true,"/sound/ton5.mp3",100,100,this);
		this.a = new KlangFigur(false,"/sound/ton6.mp3", 100, 100, this);
		this.ais = new KlangFigur(true,"/sound/ton6.mp3",100,100,this);
		this.h = new KlangFigur(false,"/sound/ton7.mp3", 100, 100, this);
		this.c1 = new KlangFigur(false,"/sound/ton8.mp3", 100, 100, this);
		
	}
	
	protected void neuerSpielstand() {
		
	}
	
	protected void zeichneSpielstand(Graphics2D g) {
		c.zeichne(g);
		cis.zeichne(g);
		d.zeichne(g);
		dis.zeichne(g);
		e.zeichne(g);
		f.zeichne(g);
		fis.zeichne(g);
		this.g.zeichne(g);
		gis.zeichne(g);
		a.zeichne(g);
		ais.zeichne(g);
		h.zeichne(g);
		c1.zeichne(g);
	}

}
