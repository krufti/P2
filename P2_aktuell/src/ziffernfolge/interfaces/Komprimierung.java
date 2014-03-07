package ziffernfolge.interfaces;

public interface Komprimierung
{
  /** Der Text wird verschluesselt. Wenn fuer den Text 
      ein Null-Zeiger uebergeben wird, wird nicht 
      komprimiert.
      @param text der zu komprimierende Text.*/
  public String komprimieren(String text);

  /** Der Text wird entschluesselt. Wenn fuer den Text 
      ein Null-Zeiger uebergeben wird, wird nicht 
      expandiert.
      @param text der zu expandierende Text.*/
  public String expandieren(String text);
}