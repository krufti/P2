package ziffernfolge;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ziffernfolge.interfaces.Liste;

/** Spielkonsole fuer das Spiel "Ziffernfolge". 
Es besteht aus
einem Feld von neun Ziffernfeldern, die in verschiedenen Farben
aufleuchten können. Der Spieler kan die Zifferfelder mit der Maus
anklicken, um die memorierte Ziffernreihe einzugeben.*/
@SuppressWarnings("serial")
public class Spielkonsole extends JPanel
{  
  private static final int abstand=5;
  
  /** Hoehe der Spielkonsole, wird automatisch so eingestellt, dass
      drei Ziffernfelder nebeneinander Platz haben.*/
  public static final int hoehe=abstand*4+Ziffer.groesse*3;;
  
  /** Breite der Spielkonsole, wird automatisch so eingestellt, dass
      drei Ziffernfelder übereinander Platz haben.*/
  static final int breite=abstand*4+Ziffer.groesse*3;;
  
  private Ziffer[][] ziffern=new Ziffer[3][3];
  private Random zufallszahlen=new Random(); // fuer die zufaellige Auswahl neuer Ziffern
  private Liste ziffernfolge=new VerketteteListe(); // fuer die Verwaltung der Ziffernfolge
  private Liste.Iterator zifferzeiger=null;
  private Steuerung steuerung;  // fuer die Spielsteuerung
  private boolean alle_Ziffern_memoriert=false; 
  
  /** Erzeugt eine neue Spielkonsole.
      Die Abmessungen werden automatisch so eingestellt, dass
      die neun Ziffernfelder genug Platz haben. Die Spielkonsole erzeugt
      eine Steuerung, die erlaubt, das Spiel zu kontrollieren. 
      Ist die Spielkonsole erzeugt, wird der Steuerung den Eintritt des 
      Ereignisses "Spiel gestartet" übermittelt.*/
  public Spielkonsole()
  { this.setBorder(new LineBorder(new Color(0, 0, 0)));
    this.setBackground(SystemColor.controlHighlight);
    this.setSize(breite,hoehe); 
    this.setLayout(null);
    for(int i=0;i<3;i++)
    { for(int j=0;j<3;j++)
      { ziffern[i][j]=new Ziffer(this);
        int xpos=abstand+j*(abstand+Ziffer.groesse);
        int ypos=abstand+i*(abstand+Ziffer.groesse);
        ziffern[i][j].setLocation(xpos,ypos);
        this.add(ziffern[i][j]);
      } 
    }
  }
  
  /** Die aktuelle Ziffernreihe wird um eine Ziffer verlaengert und 
      ihre Praesentation gestartet.
      Dies bedeutet, dass die zugehoerigen Ziffernfelder 
      nacheinander  blau aufleuchten. Ausserdem wird die Präsentation akustisch mit 
      Signaltoenen unterstützt. Ist die Praesentation beendet, wird der
      Steuerung mitgeteilt, dass dieses Ereignis eingetreten ist.*/
  public void starte_Praesentation_Ziffernfolge()
  { alle_Ziffern_memoriert=false; 
    int ziffer=zufallszahlen.nextInt(9)+1;
    ziffernfolge.setze_an_Ende(ziffer);
    zifferzeiger=ziffernfolge.erzeuge_Iterator();
    Thread t=new PraesentationsThread(this);
    t.start();
  }    
    
  /** Die aktuelle Ziffernfolge wird geloescht und durch eine neue, noch 
      leere ersetzt. */
  public void beginne_neue_Ziffernfolge()
  { ziffernfolge=new VerketteteListe();
  }
  
  /** Teilt der Spielkonsole mit, dass der Spieler ein Ziffernfeld 
      mit der Maus angeklickt hat. Die Spielkonsole leitet dieses Ereignis an
      seine Steuerung weiter.
      @param ziffer Verweis auf das ausgewählte Ziffer-Objekt.*/
  public void Ziffer_ausgewaehlt(Ziffer ziffer)
  { steuerung.ziffer_ausgewaehlt(ziffer);
  }
  
  /** Es wird geprüft, ob die ausgewaehlte Ziffer korrekt ist.
      Die ausgewaehlte Ziffer wird mit der aktuellen Ziffer der Ziffernreihe
      verglichen. Danach wird die naechste Ziffer in der Reihe die aktuelle
      Ziffer. Ist die aktuelle Zuffer das Ende der Ziffernreihe, wird die 
      erste Ziffer zur aktuellen Ziffer. Ist die Ziffer korrekt, leuchtet sie
      gruen auf, sonst rot.
      @param ziffer Verweis auf das ausgewaehlte Ziffer-Objekt 
      @return true, wenn die Ziffer mit der aktuellen uebereinstimmt. */
  public boolean ausgewaehlte_Ziffer_korrekt(Ziffer ziffer)
  { int ziffer_ist=ziffer.wert();
    int ziffer_soll=(Integer)zifferzeiger.element();
    if(ziffer_ist==ziffer_soll) 
    { ziffer.leuchte_gruen_auf();
      zifferzeiger.weiter();
      if(zifferzeiger.nach_ende()) alle_Ziffern_memoriert=true;
      return true;
    }
    ziffer.leuchte_rot_auf();
    return false;
  }
  
  /** Prueft, ob die gesamte Ziffernreihe richtig memoriert worden ist.
      @return true, wenn die gesamte Ziffernreihe 
      richtig memoriert worden ist. */
  public boolean alle_Ziffern_Memoriert()
  { if(alle_Ziffern_memoriert)
    { alle_Ziffern_memoriert=false; 
      return true;
    }
    return false;
  }
  
  public void melde_an(Steuerung steuerung)
  { this.steuerung=steuerung;
  }  
  
  private class PraesentationsThread extends Thread
  { private Spielkonsole spielkonsole;
    
    private PraesentationsThread(Spielkonsole spielkonsole)
    { this.spielkonsole=spielkonsole;
    }
    
    public void run()
    { for(Liste.Iterator zeiger=ziffernfolge.erzeuge_Iterator();!zeiger.nach_ende();zeiger.weiter())
      { int ziffer=(Integer)zeiger.element();
    	int i=(ziffer-1)/3;
        int j=((ziffer)-1)%3;  
        try{Thread.sleep(2000);} catch(InterruptedException e){} 
        this.spielkonsole.ziffern[i][j].leuchte_blau_auf();
      }
      steuerung.praesentation_Ziffernfolge_beendet();
    }
  }
}