//
// Autor: Sebastian Kruft
// zuletzt geändert: 13.03.2014
//
package ziffernfolge.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import ziffernfolge.Datenspeicher;
import ziffernfolge.Ergebnis;
import ziffernfolge.interfaces.Liste;
import ziffernfolge.VerketteteListe;
import ziffernfolge.interfaces.Liste.Iterator;

public class Datenspeicher_Test {
	
	@Test(expected = FileNotFoundException.class) 
	public void ladenNichtVorhanden() throws IOException{
		System.out.println("Laden einer nicht vorhandenen Datei");
		File zuLoeschen = new File("ergList.txt");
		if(zuLoeschen.exists()){
			zuLoeschen.delete();
			System.out.println("Gelöscht");
		}
		new Datenspeicher().lade();
	}
	
	@Test 
	public void speichern_leer() throws IOException{
		System.out.println("Leere Datei speichern");
		new Datenspeicher().speichere(new VerketteteListe());
	}
	
	
	@Test 
	public void speichern_normal() throws IOException{
		System.out.println("Speichern mit einem Ergebnis");
		VerketteteListe res = new VerketteteListe();
		res.setze_an_Anfang(new Ergebnis("test",1,1));
		new Datenspeicher().speichere(res);
	}
	
	
	@Test 
	public void laden_normal() throws IOException{
		System.out.println("Laden vom Standardergebnis");
		speichern_normal();
		Liste res = new Datenspeicher().lade();
		//System.out.println(res.erzeuge_Iterator().element().compareTo(new Ergebnis("test",2,1)));
		assertEquals(res.erzeuge_Iterator().element().compareTo(new Ergebnis("test",1,1)),0);
	}
	
	@Test
	public void mehr_elemente() throws IOException{
		System.out.println("Test von vielen Ergebnissen");
		Liste startListe = new VerketteteListe();
		for(int i = 0; i < 100 ; i++){
			startListe.setze_an_Ende(new Ergebnis("test Nr. 0"+i,i,i));
		}
		Datenspeicher data = new Datenspeicher();
		data.speichere(startListe);
		Liste geladeneListe = data.lade();
		Iterator startIterator = startListe.erzeuge_Iterator();
		Iterator loadedIterator = geladeneListe.erzeuge_Iterator();
		for (int i = 0; i < 100; i++) {
			assertEquals("Ungleich: "+startIterator.element().toString()+" "+loadedIterator.element().toString(),
						 startIterator.element().toString(), 
						 loadedIterator.element().toString());
			//System.out.println(startIterator.element().toString()+" "+loadedIterator.element().toString());
			startIterator.weiter();
			loadedIterator.weiter();
		}
	}
	
	@Test
	public void laden_leer() throws IOException{
		System.out.println("Laden von leerer Datei");
		speichern_leer();
		Liste res = new Datenspeicher().lade();
		assertTrue(res.erzeuge_Iterator().nach_ende());
	}

}
