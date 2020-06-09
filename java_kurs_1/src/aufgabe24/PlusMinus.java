package aufgabe24;

import java.awt.event.ActionEvent;

public class PlusMinus extends Taste{
	
	public PlusMinus (String wert, Anzeige anzeige) {
		super(wert, anzeige);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double wert = anzeige.getWert();
		wert = wert *(-1);
		anzeige.setText("" + wert);
		Taste.neueEingabe = true;
		
	}
	

}
