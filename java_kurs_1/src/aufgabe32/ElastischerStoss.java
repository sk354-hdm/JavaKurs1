package aufgabe32;

import Figuren.FigurReaktion;
import Figuren.SpielFigur;
import tools.Klang;
import tools.Vektor2D;

public class ElastischerStoss extends FigurReaktion{
	private Vektor2D impuls=new Vektor2D();
	private static Klang klang = new Klang("/sound/billard_kugel_kugel.mp3");
	
	public ElastischerStoss(SpielFigur f1, SpielFigur f2) {
		super(f1, f2, null,0.01);
	}
	
	protected void reaktion() {
		// impuls: normalisierten Vektor vom Mittelpunkt der ersten zur zweiten Kugel
		  impuls.setLocation(f1.getCenterX(), f1.getCenterY());		
		  impuls.subtrahiere(f2.getCenterX(), f2.getCenterY());
		  if(impuls.distance(0,0)>42) return;  // berühren sich die Kugeln wirklich?
		  impuls.normiere();
		  
			double f = Math.sqrt(Math.abs(impuls.skalarProdukt(relativBewegung)*f1.getMasse()*f2.getMasse()));
			impuls.skalarMult(f);
			f1.setBewegung(v1.x + impuls.x/f1.getMasse(), v1.y + impuls.y/f1.getMasse());
			f2.setBewegung(v2.x - impuls.x/f2.getMasse(), v2.y - impuls.y/f2.getMasse());

			klang.play(0.1 * f);


		
	}
}
