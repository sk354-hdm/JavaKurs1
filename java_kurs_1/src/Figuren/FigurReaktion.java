package Figuren;

import tools.Klang;
import tools.Vektor2D;

public abstract class FigurReaktion {
	
	protected SpielFigur f1,f2;
	protected Klang klang;
	protected double klangFaktor;
	protected Vektor2D v1,v2,relativBewegung;
	
	public FigurReaktion(SpielFigur f1, SpielFigur f2, Klang klang, double klangFaktor) {
		
		this.f1 = f1;
		this.f2 = f2;
		this.klang = klang;
		this.klangFaktor = klangFaktor;
		
		v1 = new Vektor2D();
		v2 = new Vektor2D();
		
		relativBewegung = new Vektor2D();
	}
	
	public final void reagiere() {
		
		if(f1.intersects(f2)) {
			v1.setLocation(f1.getBewegung());
			v2.setLocation(f2.getBewegung());
			relativBewegung.setLocation(v1);
			relativBewegung.subtrahiere(v2);
			
			if(klang != null) {
				klang.setBasisPegel(relativBewegung.distance(0,0)*klangFaktor);
				klang.play();
			}
			reaktion();
		}
	}
	
	
	protected abstract void reaktion();
		
}
