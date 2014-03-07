package ziffernfolge.interfaces;

public interface Kryptomethode
{ 
  /** Der Schluessel fuer das Ver- und Entschluesseln wird bereitgestellt.
      @param wert Wert des Schluessels: eine Zeichenkette.*/
  public void Schluessel(String wert);
  
  /** Der Text wird verschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder für den Text ein Null-Zeiger uebergeben wird, wird nicht 
      verschluesselt. Der verschlüsselte Text wird im Parameter text zur 
      Verfügung gestellt.
      @param text der zu verschluesselnde Text.*/
  public void verschluesseln(String text);

  /** Der Text wird entschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder für den Text ein Null-Zeiger uebergeben wird, wird nicht 
      entschluesselt. Der entschlüsselte Text wird im Parameter text zur 
      Verfügung gestellt.
      @param text der zu entschluesselnde Text.*/
  public void entschluesseln(String text);
}