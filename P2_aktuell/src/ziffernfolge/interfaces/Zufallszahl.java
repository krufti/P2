package ziffernfolge.interfaces;

public interface Zufallszahl
{ 
  /** Die naechste ganzzahlige Zufallszahl wird ausgegeben. 
      Sie liegt im Bereich von einschliesslich 0 bis einschliesslich 100.
      @param wert Wert des Schluessels: eine Zeichenkette.*/
  public int naechste();    

  /** Die naechste ganzzahlige Zufallszahl wird ausgegeben. 
      Sie liegt im angegebenen Bereich.
      @param von die kleinste moegliche Zahl. Wird eine negative
      Zahl fuer diesen Parameter angegeben, ist die kleinste 
      moegliche Zahl 0. Ist "von" groesser als "bis", ist die
      die kleinste moegliche Zahl "bis"; 
      @param bis die groesste mögliche Zahl. Wird eine negative
      Zahl fuer diesen Parameter angegeben, ist die groesste 
      moegliche Zahl 0. Ist "bis" kleiner als "von", ist die
      die groesste moegliche Zahl "von"*/
  public int naechste(int von, int bis);
}