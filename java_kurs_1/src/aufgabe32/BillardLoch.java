package aufgabe32;

import java.awt.Color;
import java.awt.Graphics2D;

import Figuren.SpielFigur;
import tools.Spiel;

public class BillardLoch extends SpielFigur{
	
	public static final int LINKS=1, MITTE=2, RECHTS=3, UNTEN=4, OBEN=5;
	private static final int GROESSE=30;
	
	private int hPos, vPos;
	
	public BillardLoch(int hPos, int vPos, Spiel spiel) {
		super(0,0,GROESSE,GROESSE,spiel);
		this.hPos = hPos;
		this.vPos = vPos;
	}
	
	@Override
	public void zeichne(Graphics2D g) {
		if(this.hPos==LINKS) {
			this.x = this.spiel.getRand().getMinX();
		}else if(this.hPos==MITTE) {
			this.x = this.spiel.getRand().getMinX() + (this.spiel.getRand().getMaxX()-this.spiel.getRand().getMinX()-GROESSE)/2;
		}else {
			this.x = this.spiel.getRand().getMaxX()-GROESSE;
		}
		
		if(this.vPos==OBEN) {
			this.y = this.spiel.getRand().getMinY();
		}else {
			this.y = this.spiel.getRand().getMaxY()-GROESSE;
		}
		g.setColor(Color.LIGHT_GRAY);
		g.fill(this);
	}
	
}
