package komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class KlickKnopf extends JButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Du sollst doch nicht klicken.");
	}
	
	
	public KlickKnopf() {
		super ("Nicht klicken");
		this.addActionListener(this);
	}

}
