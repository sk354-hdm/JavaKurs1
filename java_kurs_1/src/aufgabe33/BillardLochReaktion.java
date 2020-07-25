package aufgabe32;


import java.awt.Color;

import Figuren.FigurReaktion;
import Figuren.SpielFigur;
import tools.Klang;
import tools.Spiel;

public class BillardLochReaktion extends FigurReaktion {
	
	private static int anzahlEingelochteKugeln = 0;
	private Spiel spiel;
	private BillardKugel kugel;
	private static Klang klang = new Klang("/sound/billard_kugel_loch.mp3");
	
	public BillardLochReaktion(BillardLoch f1, BillardKugel f2) {
		super(f1,f2,null, 1.0);
		kugel = f2;
		spiel = f2.getSpiel();
	}
	@Override
	protected void reaktion() {
		((Billard)spiel).kugelEingelocht(kugel);
		kugel.setBewegung(0, 0);
		if(Color.WHITE.equals(kugel.getFarbe())) {
			kugel.x=200;
			kugel.y=400;
		}
		else {
			kugel.setRandReaktion(SpielFigur.RAND_IGNORIEREN, null);
			kugel.x = 200+50*anzahlEingelochteKugeln++;
			kugel.y = spiel.getHeight()-60;
		}
		
	klang.play(1.2);
	}

}
