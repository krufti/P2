//
// Autor: Sebastian Kruft
// zuletzt ge�ndert: 13.03.2014
//
package ziffernfolge.interfaces;

import ziffernfolge.Ergebnis;

public interface IErgebnis {
	
	/**
	 * Zeilenweise Ausgabe zum leichten abspeichern
	 * @return String mit 3 Zeilen
	 */
	public String toString();
	
	/**
	 * Ausgabe zum Ausgeben geeignet
	 * @return 'sch�ner' String
	 */
	public String toShow();
	
	/**
	 * Vergleicht dieses Ergebnis mit �bergebenen Ergebnis
	 * -sortiert nach zifferanzahl
	 * -dann nach ben�tigter zeit
	 * viele! Ziffern gut
	 * wenig! Zeit gut
	 * @param o
	 * @return Integer (1=dies ist besser, 0=beide gleich, -1=�bergebenes ist besser)
	 */
	public int compareTo(Ergebnis o);
	
	

}
