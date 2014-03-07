//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//	Todo: Krypto und Komp auf String anwenden ser Daten in string schreiben anstatt in Datei
package ziffernfolge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import ziffernfolge.interfaces.Liste.Iterator;
import ziffernfolge.interfaces.Komprimierung;
import ziffernfolge.interfaces.Kryptomethode;
import ziffernfolge.interfaces.Liste;



public class Datenspeicher {
	
	@SuppressWarnings("unused")
	private Kryptomethode krypto = new XOR();
	
	@SuppressWarnings("unused")
	private Komprimierung komp = new Huffman();
	
	
	
	/**
	 * Funktion zum Speichern
	 * Verwendet Krytomodul und Kompressionmodul
	 * 
	 * @param toSave Liste die gespeichert werden soll
	 * @throws IOException Schreibfehler Datei schreibgeschütz? 
	 */
	public void speichere(Liste toSave) throws IOException {
		String temp;
		StringBuffer buffer = new StringBuffer();
		// Erzeuge Klartext
		for (Iterator zeiger = toSave.erzeuge_Iterator(); !zeiger.nach_ende(); zeiger.weiter()) {
			buffer.append(zeiger.element().toString());
		}
		// Verschlüssel
		//krypto.verschluesseln(buffer);
		// Komprimieren
		//temp = komp.komprimieren(buffer.toString());
		// Komprimierten String in Datei schreiben
		temp = buffer.toString();
		FileWriter file = new FileWriter("ergList.txt");
		PrintWriter writer = new PrintWriter(new BufferedWriter(file));

		writer.println(temp);
		
		writer.close();
		file.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Funktion zum Laden
	 * Verwendet Krytomodul und Kompressionmodul
	 * 
	 * @return fertig geladene Liste noch nicht sortiert
	 * @throws IOException Fehler beim laden
	 */
	public Liste lade() throws IOException {
		VerketteteListe nListe = new VerketteteListe();
		String temp = new String();
		StringBuffer buffer = new StringBuffer();
		// Komprimierten und verschlüsselten komplett auslesen
		BufferedReader leser = new BufferedReader(new FileReader("ergList.txt"));
		for (;;) {
			int gelesen = leser.read();
			if (gelesen == -1)
				break;
			temp += ((char)gelesen);
		}
		// expandieren
		//temp = komp.expandieren(temp);
		// entschluesseln
		//buffer.append(temp);
		//krypto.entschluesseln(buffer);
		// Aus dem entschlüsselten Text zeilenweise wieder Ergebnis herstellen
		buffer.append(temp);
		BufferedReader sLeser = new BufferedReader(new StringReader(buffer.toString()));
		Ergebnis erg = new Ergebnis();
		for (int i = 0;; i++) {
			String zeile = sLeser.readLine();
			if (zeile == null) {
				break; // Bei Ende Abbruch
			}
			// Tue alle drei Zeilen das selbe
			switch (i % 3) {
			case 0:
				erg = new Ergebnis();
				erg.name = zeile;
				break;
			case 1:
				erg.zeit = Integer.parseInt(zeile);
				break;
			case 2:
				erg.ziffernanzahl = Integer.parseInt(zeile);
				nListe.setze_an_Ende(erg);
				break;
			}
			leser.close();
		}

		return nListe;
	}
	
	
	
//	public void lade(Ergebnisliste liste){
//		
//		liste.start();
//		try{ 
//            FileReader fr = new FileReader("liste.txt");
//            BufferedReader reader = new BufferedReader(fr);
//            String zeile = reader.readLine();
//            while (zeile != null) { 
//            	
//            	krypto.entschluesseln(zeile);
//            	zeile = komp.expandieren(zeile);
//            	String[] splitResult = zeile.split(";");
//            	
//            	liste.aktuelles_Element().name = splitResult[0];
//            	liste.aktuelles_Element().zeit = Integer.parseInt(splitResult[1]);
//            	liste.aktuelles_Element().ziffernanzahl = Integer.parseInt(splitResult[2]);
//            	
//            	liste.weiter();
//            	
//            }
//            reader.close();
//        }catch(IOException ioe){ 
//            ioe.printStackTrace(); 
//        } 	
//		
//				
//	
//
//	
//		
//	}
//	
//	
//	public void speichere(Ergebnisliste ergebnisliste){
//		
//		String temp_string_s, temp_name;
//		temp_string_s = "";
//		temp_name = "leer";
//		
//		ergebnisliste.start();
//		 
//		try{	 
//			PrintWriter pWriter = new PrintWriter(new FileWriter("liste.txt"));
//			
//			while(temp_name != ergebnisliste.aktuelles_Element().name){
//				
//				temp_name = ergebnisliste.aktuelles_Element().name;
//				temp_string_s = ergebnisliste.aktuelles_Element().name + ";" + ergebnisliste.aktuelles_Element().zeit + ";" + ergebnisliste.aktuelles_Element().ziffernanzahl;
//				temp_string_s = komp.komprimieren(temp_string_s);
//				krypto.verschluesseln(temp_string_s);
//				pWriter.println(temp_string_s);
//				ergebnisliste.weiter();
//			}
//			
//			pWriter.close();
//			
//			
//		}catch(IOException ioe){ 
//            ioe.printStackTrace(); 
//        } 	
//
//	
//			
//		
//	}
//	
	
	
	
	
}
