package tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Klang (Version 5 - 03.04.2017)
 * 
 * * @author Uwe Schulz (schulz@hdm-stuttgart.de)
 * 
 * Klasse zum Abspielen von Sound-Dateien (.wav oder .mp3)
 * Achtung: verwendet Java-FX, deshalb ist mindestens Java Version 7 notwendig!<br>
 *           
 *  Die Dateien muessen innerhalb des src-Verzeichnisses liegen,
 *  damit die Sounds auch in JAR-Dateien gefunden werden.      
 *    
 *           
 * Zur Kontrolle des Pegels und der Abspielgeschwindigkeit gibt es folgende Moeglichkeiten:
 * <ul>
 *   <li>Ein Klang Objekt hat zunaechst einen Lautstaerkepegel von 1. 
 *       Mit <code>setBasisPegel(double b)</code> wird dieser Wert angepasst.
 *   <li>Beim Abspielen mit <code>play(double p)</code> wird der Basispegel mit p multipliziert 
 *       Dadurch kann man die Lautstaerke dynamisch an das Spielgeschehen anpassen.    
 *   <li>Mit <code>setRate(double r)</code> kann man die Abspielgeschwindigkeit aendern.      
 * </ul>
 * Beispiel:     
 * <pre>                            
 *   Klang melodie = new Klang("/sound/beispiel.mp3"); // beispiel.mp3 liegt im Verzeichnis src/sound
 *   melodie.play();              // spielt den Sound einmal ab 
 *   melodie.setBasisPegel(0.5);  // halbe Lautstaerke
 *   melodie.play(0.5);           // abspielen mit der Lautstaerke 0.25
 *   melodie.play(2);             // abspielen mit der Lautstaerke 1
 *   melodie.loop();              // endlos abspielen mit Basispegel (0.5)
 *</pre>  
 *
 *  Version 5 (03.04.2017):
 *     - Das Laden der temporaeren Dateien ist nicht mehr notwendig, das Loopen wird durch einen 
 *       eigenen Timer realisiert. Bei jedem Abspielen wird ein neuer Player erzeugt.
 *  Version 4 (12.10.2016):
 *     - Sound wird in eine temporaere Datei geschrieben, weil Java FX sonst beim Lesen aus deine JAR-Datei
 *       den onSetEndOfMedia Event nicht richtig behandelt, dadurch waren Sounds aus Jar Dateien nur 
 *       ein einziges Mal abspielbar.
 *  Version 3 (29.7.2016):
 *     - Suche in verschiedenen Verzeichnissen 
 *  Version 2 (17.4.2015): 
 *     - von AudioClip auf MediaPlayer umgestellt, damit MP3-Dateien auch im Loop abspielbar sind
 *     - Abfrage der Zeitspanne zwischen zwei Sounds (lastTimeSoundPlayed) eingebaut um 
 *       Probleme beim Abspielen von vielen Sounds schnell hintereinander zu vermeiden. 
 *  
 */
public class Klang {
	private final static int MINIMALE_PAUSE = 150; // Millisekunden zwischen zwei Sounds um Sync-Probleme zu verhindern
	private double basisPegel=1.0, rate = 1.0;
	private javafx.scene.media.MediaPlayer player;
	private long lastTimeSoundPlayed=0;
	private Timer timer;                        // wird beim loopen verwendet 
	private static javafx.embed.swing.JFXPanel panel = null;
	private static boolean fehlerGemeldet = false;  
	
	private static long firstTime = -1;
	
	
	/**
	 * Generiert ein Klang Objekt aus einer WAV oder MP3 Datei, die auch in einem JAR Archiv liegen kann.
	 *  
	 * Hinweis: Falls die Datei nicht existiert oder keine gueltige Sound-Datei ist,
	 *          wird ein Fehler gemeldet und der Sound laesst sich nicht abspielen.
	 * 
	 * @param filename: Pfadname der Sound Datei (WAV oder MP3), relativ zum 
	 *                  src-Verzeichnis des Eclipse-Projekts, Beispiele:
	 *                  
	 *                  Pfad im Eclipse-Projekt     filename             
	 *                  src/sound/test.mp3          "/sound/test.mp3"
	 *                         
	 */
	public Klang(String filename){
		if(panel==null) panel =	new javafx.embed.swing.JFXPanel();  // Initialisirt Java FX
		
		URL url = this.getClass().getResource(filename);		
		if(url==null) {
			if(!fehlerGemeldet) JOptionPane.showMessageDialog(null, "Klasse Klang: Datei "+filename+"\" nicht gefunden.", "FEHLER", JOptionPane.ERROR_MESSAGE);
			fehlerGemeldet = true;  // nur der erste Fehler wird gemeldet
		}
		else {
			javafx.scene.media.Media media = new javafx.scene.media.Media(url.toString());
			player = new javafx.scene.media.MediaPlayer(media);
		}
	}
	
	/**
	 * Setzt den Pegel, mit dem der Sound standardmaessig abgespielt wird.
	 * Die Voreinstellung ist 1.0. Durch unterschiedliche Basispegel koennen 
	 * verschiedene Sounds aneinander angepasst werden.
	 * 
	 * @param basisPegel Standard-Pegel
	 */
	public void setBasisPegel(double basisPegel){
		this.basisPegel = basisPegel;
	}

	/**
	 * Spielt den Klang einmal ab. Die Lautstaerke wird durch den Basispegel definiert.
	 */
	public void play(){
		this.play(1.0);
	}
		
	/**
	 * Spielt den Klang einmal ab. Lautstaerke = Basispegel*pegel.
	 * @param pegel Multiplikator fuer den Basispegel
	 */
	public void play(double pegel){
		long time = System.currentTimeMillis();
		long delta=time-this.lastTimeSoundPlayed;
		if(player!=null && delta>MINIMALE_PAUSE) {
			lastTimeSoundPlayed=time;			
			new Thread(){				
				public void run(){
					player.setVolume(pegel*basisPegel);
					player.setRate(rate);
					player.pause();
					player.seek(javafx.util.Duration.ZERO);
					player.play();
				}
			}.start();		
		}
	}		

	/**
	 * Spielt den Klang endlos ab. Die Lautstaerke wird durch den Basispegel definiert.
	 */
	public void loop(){
		if(player!=null){
			new Thread(){	
				public void run(){
					/*
					 *  Da player.setOnEndOfMedia() fuer MP3-Files nicht funktioniert, faengt 
					 *  ein eigener Timer das Ende des Klangs ab und startet den Player neu. 
					 */
					player.setVolume(basisPegel);		
					player.setRate(rate);
					
					timer = new Timer(250,new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
								player.pause();
								player.seek(javafx.util.Duration.ZERO);
								player.play();
							}
						}
					});
					timer.start();
					player.play();
				}
			}.start();		
		}
	}

	/**
	 *   Beendet das Abspielen des Klangs.
	 */
	public void stop(){
		if(player!=null) player.stop();
		if(timer!=null) timer.stop();
	}
	
	/**
	 * Veraendert die Abspielgeschwindigkeit 
	 * @param rate  Faktor fuer die Geschwindigkeit  
	 */
	public void setRate(double rate){
		this.rate = rate;
	}		
}