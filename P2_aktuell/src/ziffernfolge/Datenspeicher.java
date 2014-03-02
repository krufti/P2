//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//	Todo: Krypto und Komp auf String anwenden ser Daten in string schreiben anstatt in Datei
package ziffernfolge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Datenspeicher {
	
	private Kryptomethode krypto = new XOR();
	
	private Komprimierung komp = new Huffman();
	
	public void lade(Ergebnisliste liste){
		
		liste.start();
		try{ 
            FileReader fr = new FileReader("liste.txt");
            BufferedReader reader = new BufferedReader(fr);
            String zeile = reader.readLine();
            while (zeile != null) { 
            	
            	krypto.entschluesseln(zeile);
            	zeile = komp.expandieren(zeile);
            	String[] splitResult = zeile.split(";");
            	
            	liste.aktuelles_Element().name = splitResult[0];
            	liste.aktuelles_Element().zeit = Integer.parseInt(splitResult[1]);
            	liste.aktuelles_Element().ziffernanzahl = Integer.parseInt(splitResult[2]);
            	
            	liste.weiter();
            	
            }
            reader.close();
        }catch(IOException ioe){ 
            ioe.printStackTrace(); 
        } 	
		
				
	

	
		
	}
	
	
	public void speichere(Ergebnisliste ergebnisliste){
		
		String temp_string_s, temp_name;
		temp_string_s = "";
		temp_name = "leer";
		
		ergebnisliste.start();
		 
		try{	 
			PrintWriter pWriter = new PrintWriter(new FileWriter("liste.txt"));
			
			while(temp_name != ergebnisliste.aktuelles_Element().name){
				
				temp_name = ergebnisliste.aktuelles_Element().name;
				temp_string_s = ergebnisliste.aktuelles_Element().name + ";" + ergebnisliste.aktuelles_Element().zeit + ";" + ergebnisliste.aktuelles_Element().ziffernanzahl;
				temp_string_s = komp.komprimieren(temp_string_s);
				krypto.verschluesseln(temp_string_s);
				pWriter.println(temp_string_s);
				ergebnisliste.weiter();
			}
			
			pWriter.close();
			
			
		}catch(IOException ioe){ 
            ioe.printStackTrace(); 
        } 	

	
			
		
	}
	
	
}
