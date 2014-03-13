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
import ziffernfolge.interfaces.IDatenspeicher;



public class Datenspeicher implements IDatenspeicher {
	
	@SuppressWarnings("unused")
	private Kryptomethode krypto = new XOR();
	
	@SuppressWarnings("unused")
	private Komprimierung komp = new Huffman();
	

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
		
}
