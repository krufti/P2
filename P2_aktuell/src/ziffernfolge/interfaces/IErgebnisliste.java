package ziffernfolge.interfaces;

import java.io.IOException;

import ziffernfolge.Ergebnis;

public interface IErgebnisliste {
	
	
	/**
	 * Führt die Sortierung aus und speichert die Ergebnisliste ab
	 */
	public void close() throws IOException;
	
	/**
	 * Neues Ergebnis zur Liste hinzufügen
	 * @param in
	 */
	public void speichere(Ergebnis in);
	
	/**
	 * Setzt den Iterator auf den Start
	 */
	public void start();
	
	/**
	 * Setzt den Iterator auf das nächste Element
	 */
	public void weiter();
	
	/**
	 * Setzt den Iterator auf das letzte Element
	 */
	public void ende();
	
	/**
	 * Liefert den Ergebnis Datensatz vom aktuellen Element
	 * @return Ergebnis aktuelles Element
	 */
	public Ergebnis aktuelles_Element();

}
