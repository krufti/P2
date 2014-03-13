//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//
package ziffernfolge;

import java.io.IOException;

import ziffernfolge.interfaces.IErgebnisliste;
import ziffernfolge.interfaces.Liste;
import ziffernfolge.interfaces.Sortierung;
import ziffernfolge.interfaces.Liste.Iterator;

public class Ergebnisliste implements IErgebnisliste{
	
	private Liste ergL;
	private Sortierung sort = new Einfügesortierung();
	private Iterator ergI;
	private Datenspeicher data = new Datenspeicher();
	
	public Ergebnisliste() throws IOException {
		ergL = data.lade();
		sort.sortiere(ergL);
		ergI = ergL.erzeuge_Iterator();
	}
	
	
	public void close() throws IOException{
		sort.sortiere(ergL);
		data.speichere(ergL);
	}
	
	
	public void speichere(Ergebnis in){
		ergL.setze_an_Ende(in);
	}
		
	public void start(){
		
		ergI.anfang();
		
	}
	
	public void weiter(){
		
		ergI.weiter();
		
	}

	public void ende(){
		
		ergI.ende();
		
	}
	
	public Ergebnis aktuelles_Element(){
		Ergebnis ret;
		
		ret = (Ergebnis)ergI.element();
		
		return ret;
	}
	
	
	
	
	
	
	
	
	

}
