package aufgabe31;

import java.awt.Color;

import Figuren.FigurReaktion;
import tools.Klang;
import tools.Spiel;

public class BillardLochReaktion extends FigurReaktion{
	
	private static int anzahlEingelochteKugeln;
	private Spiel spiel;
	private BillardKugel kugel;
	
	public BillardLochReaktion(BillardLoch f1, BillardKugel f2) {
		super(f2, f2, new Klang("/sound/billard_kugel_loch.mp3"), 0.01);
		f2 = kugel;
		spiel = f2.getSpiel();
	}

	@Override
	protected void reaktion() {
		kugel.setBewegung(0, 0);
		if(kugel.getFarbe().equals(Color.WHITE)) {
			kugel.x = 200;
			kugel.y = 400;
		} else {
			kugel.setRandReaktion(kugel.RAND_IGNORIEREN, null);
			kugel.x = 200 + 50 * anzahlEingelochteKugeln++;
			kugel.y = spiel.getHeight() - 60;
		}
		
	}

}
