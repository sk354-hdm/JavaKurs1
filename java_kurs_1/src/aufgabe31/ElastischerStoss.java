package aufgabe31;

import Figuren.FigurReaktion;
import Figuren.SpielFigur;
import tools.Klang;
import tools.Vektor2D;


public class ElastischerStoss extends FigurReaktion {
	
	private Vektor2D impuls = new Vektor2D();;
	
	public ElastischerStoss(SpielFigur f1, SpielFigur f2) {
		super(f1, f2, new Klang("/sound/billard_kugel_kugel.mp3"), 0.01);
	
		
	}
	
	protected void reaktion() {
		
		impuls.setLocation(f1.getCenterX(),f1.getCenterY());
		impuls.subtrahiere(f2.getCenterX(),f2.getCenterY());
		
		if(impuls.distance(0,0)>42) return;
		
		impuls.normiere();
		
		double f = Math.sqrt(Math.abs(impuls.skalarProdukt(relativBewegung))) * f1.getMasse() *f2.getMasse();
		
		impuls.skalarMult(f);
		
		f1.setBewegung(v1.x + impuls.x/f1.getMasse(), v1.y + impuls.y/f1.getMasse());
		f2.setBewegung(v2.x - impuls.x/f2.getMasse(), v2.y - impuls.y/f2.getMasse());
		
	}
}
