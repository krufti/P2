//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//
package ziffernfolge;

public class Ergebnis implements Comparable<Ergebnis>{
	
	String name=null;
	int zeit=0;
	int ziffernanzahl=0;
	
	public Ergebnis(String meinName,int meineZeit, int erreichteZifrn) {
		name = meinName;
		zeit = meineZeit;
		ziffernanzahl = erreichteZifrn;
	}
	
	public Ergebnis() {
		name = new String();
	}
	


	/*
	  
	   @Override
	public int compareTo(Object in) {
		// TODO Auto-generated method stub
		Ergebnis e = (Ergebnis)in;
		
		if(this.zeit == e.zeit){
			return 0;
		}
		
		
		if(this.zeit < e.zeit){
			return -1;
		}else{ 
			return 1;
		}
		
		
		
	
	}*/
	
	
	/**
	 * Zeilenweise Ausgabe zum leichten abspeichern
	 * @return String mit 3 Zeilen
	 */
	public String toString() {
		String temp = new String();
		temp += name;
		temp += "\n";
		temp += zeit;
		temp += "\n";	
		temp += ziffernanzahl;
		temp += "\n";	
		return temp;
	}
	
	/**
	 * Ausgabe zum Ausgeben geeignet
	 * @return 'schöner' String
	 */
	public String toShow() {
		return name + " hat " 
					+ new Integer(ziffernanzahl).toString() 
					+ " Zahlen nach " 
					+ new Integer(zeit).toString() 
					+ " erreicht";		
	}
	
	/**
	 * Vergleicht dieses Ergebnis mit übergebenen Ergebnis
	 * -sortiert nach zifferanzahl
	 * -dann nach benötigter zeit
	 * viele! Ziffern gut
	 * wenig! Zeit gut
	 * @param o
	 * @return Integer (1=dies ist besser, 0=beide gleich, -1=übergebenes ist besser)
	 */
	public int compareTo(Ergebnis o) {
		int temp = 0;
		//Vergleiche ziffernanzahl
		if(this.ziffernanzahl>o.ziffernanzahl){
			temp = 1;
		}else if (this.ziffernanzahl<o.ziffernanzahl) {
			temp = -1;
		} else {
			//bei gleicher Anzahl Vergleich der Zeiten 
			//wenig Zeit ist gut
			if(this.zeit>o.zeit){
				temp = -1;
			}else if (this.zeit<o.zeit) {
				temp = 1;
			} 
		}
		return temp;
	}

}
