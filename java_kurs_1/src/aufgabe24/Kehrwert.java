package aufgabe24;

import java.awt.event.ActionEvent;

public class Kehrwert extends Taste{
	
	public Kehrwert(String wert,Anzeige anzeige) {
		super(wert, anzeige);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		double wert = anzeige.getWert();
		
		if (wert != 0) { wert = 1 / wert;}
		
		anzeige.setText("" + wert);
		Taste.neueEingabe = true;
		
	}

}
