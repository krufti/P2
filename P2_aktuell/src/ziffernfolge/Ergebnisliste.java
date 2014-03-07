//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//
package ziffernfolge;

import ziffernfolge.interfaces.Liste;
import ziffernfolge.interfaces.Sortierung;

public class Ergebnisliste {
	
	private Liste ergebnisliste = new VerketteteListe();
	
	private Datenspeicher datenspeicher = new Datenspeicher();
	
	private Sortierung sortierung = new Bubblesort();
	
	private Liste.Iterator i;
	
	
	public void speichere(Ergebnis in){
		
		ergebnisliste.fuege_ein_nach(in, i);
		
		sortierung.sortiere(ergebnisliste);
		
		//datenspeicher.speichere(ergebnisliste);
		
				
	} 
	
	public Ergebnisliste(){
		i = ergebnisliste.erzeuge_Iterator();
	}
	
	public void start(){
		
		i.anfang();
		
	}
	
	public void weiter(){
		
		i.weiter();
		
	}

	public void ende(){
		
		i.ende();
		
	}
	
	public Ergebnis aktuelles_Element(){
		Ergebnis ret;
		
		ret = (Ergebnis)i.element();
		
		return ret;
	}
	
	
	
	

}
