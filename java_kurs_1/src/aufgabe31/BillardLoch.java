package aufgabe31;

import java.awt.Color;
import java.awt.Graphics2D;

import Figuren.SpielFigur;
import tools.Spiel;

public class BillardLoch extends SpielFigur {
	
	public static final int LINKS = 3,MITTE = 6,RECHTS = 9, OBEN = 1,UNTEN = 2;
	private static final int GROESSE = 40;
	private int hPos, vPos;

	public BillardLoch(int hPos, int vPos, Spiel spiel) {
		
		super(0, 0, GROESSE, GROESSE, spiel);
		this.hPos = hPos;
		this.vPos = vPos;
		
		
	}
	
	
	public void zeichne (Graphics2D g ) {
		
		if(hPos == (LINKS)) {
			this.x = spiel.getRand().getMinX();
			} else if (hPos == (MITTE)) {
				this.x = (spiel.getRand().getMaxX() - spiel.getRand().getMinX() - GROESSE) / 2;
			} else if(hPos == (RECHTS)) {
				this.x = spiel.getRand().getMaxX() - GROESSE;
			}
		if (vPos == (OBEN)) {
			this.y = spiel.getRand().getMinY();
		} else if (vPos == (UNTEN)) {
			this.y = spiel.getRand().getMaxY() - GROESSE;
		}
		
		g.setColor(Color.LIGHT_GRAY);
		g.fill(this);
		
		
		
	}
	
	

}
