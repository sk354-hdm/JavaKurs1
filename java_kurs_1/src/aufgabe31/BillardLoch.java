package aufgabe31;

import java.awt.Graphics2D;

import Figuren.SpielFigur;
import tools.Spiel;

public class BillardLoch extends SpielFigur {
	
	public int LINKS,MITTE,RECHTS,OBEN,UNTEN;
	private static int GROESSE = 30;
	private static int hPOS, vPOS;

	public BillardLoch(int hPOS, int vPOS, Spiel spiel) {
		
		super(0, 0, GROESSE, GROESSE, spiel);
		this.hPOS = hPOS;
		this.vPOS = vPOS;
		
		
	}
	
	
	public void zeichne (Graphics2D g ) {
		
	}
	
	

}
