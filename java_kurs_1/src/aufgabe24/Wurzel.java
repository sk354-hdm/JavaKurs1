package aufgabe24;

import java.awt.event.ActionEvent;

public class Wurzel extends Taste{
	
	public Wurzel(String wert,Anzeige anzeige) {
		super(wert,anzeige);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		double wert = anzeige.getWert();
		
		wert = Math.sqrt(wert);
		
		if (wert<0) {wert=0;}
		
		anzeige.setText("" + wert);
		Taste.neueEingabe = true;
		
	}

}
