//
// Autor: Sebastian Kruft
// zuletzt geändert: 13.03.2014
//
package ziffernfolge;

import ziffernfolge.interfaces.IErgebnis;

public class Ergebnis implements Comparable<Ergebnis>, IErgebnis{
	
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
	
	
	public String toShow() {
		return name + " hat " 
					+ new Integer(ziffernanzahl).toString() 
					+ " Zahlen nach " 
					+ new Integer(zeit).toString() 
					+ " erreicht";		
	}
	
	
	public int compareTo(Ergebnis o) {
		int temp = 0;
		//Vergleiche ziffernanzahl
		if(this.ziffernanzahl>o.ziffernanzahl){
			temp = 1;
		}else if (this.ziffernanzahl<o.ziffernanzahl) {
			temp = -1;
		} else {
			//bei gleicher Anzahl Vergleich der Zeiten 
			//weniger Zeit ist gut
			if(this.zeit>o.zeit){
				temp = -1;
			}else if (this.zeit<o.zeit) {
				temp = 1;
			} 
		}
		return temp;
	}

}
