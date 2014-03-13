package ziffernfolge.interfaces;

import java.io.IOException;

public interface IDatenspeicher {
	
	/**
	 * Funktion zum Speichern
	 * Verwendet Krytomodul und Kompressionmodul
	 * 
	 * @param toSave Liste die gespeichert werden soll
	 * @throws IOException Schreibfehler Datei schreibgeschütz? 
	 */
	public void speichere(Liste toSave) throws IOException;
	
	/**
	 * Funktion zum Laden
	 * Verwendet Krytomodul und Kompressionmodul
	 * 
	 * @return fertig geladene Liste noch nicht sortiert
	 * @throws IOException Fehler beim laden
	 */
	public Liste lade() throws IOException;
	
	

}
