package komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class TimerStopKnopf extends JButton implements ActionListener {
	
	private Timer tick = new Timer(100, this);

	public TimerStopKnopf(Timer tick) {
		super("STOP");
		this.tick = tick;
		this.addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e) {
		tick.stop();
	}
}
