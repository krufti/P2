package ziffernfolge;

public class Steuerung
{     
  private Spielkonsole spielkonsole;
  // Zustaende
  private Start start=new Start();
  private Praesentation_Ziffernfolge praesentation_ziffernfolge=new Praesentation_Ziffernfolge();
  private Memorieren_Ziffernfolge memorieren_ziffernfolge=new Memorieren_Ziffernfolge();
  private Spiel_beendet spiel_beendet=new Spiel_beendet();
  
  // aktueller Zustand der Spielkonsole.
  private Zustand zustand=start; 
  
  /** Erzeugt eine Steuerung fuer eine Spielkonsole.
      @param spielkonsole Spielkonsole, welche gesteuert
             werden soll. */
  public Steuerung(Spielkonsole spielkonsole)
  { this.spielkonsole=spielkonsole;
  }
  
  /** Ereignis. Teilt der Steuerung mit, dass das Spiel gestartet worden ist.*/
  public void spiel_gestartet()
  { zustand.spiel_gestartet();
  }

  /** Ereignis. Teilt der Steuerung mit, dass die Praesentation der Ziffernfolge
      beendet worden ist.*/
  public void praesentation_Ziffernfolge_beendet()
  { zustand.praesentation_Ziffernfolge_beendet();
  }

  /** Ereignis. Teilt der Steuerung mit, dass der Spieler eine
      Ziffer ausgewaehlt hat*/
  public void ziffer_ausgewaehlt(Ziffer ziffer)
  { zustand.ziffer_ausgewaehlt(ziffer); 
  }

  // abstrakte Zustandsklasse mit Standardverhalten
  private abstract class Zustand
  {
    public void spiel_gestartet(){};
    public void praesentation_Ziffernfolge_beendet(){};
    public void ziffer_ausgewaehlt(Ziffer ziffer){};
    public void entry(){};
    public void exit(){};   
    
    // Umschalten auf neuen Zustand
    public void naechster_Zustand(Zustand neuer_zustand)
    { exit(); 
      zustand=neuer_zustand;
      neuer_zustand.entry();
    }
  }

  // Zustand Start
  private class Start extends Zustand
  {  
    public void spiel_gestartet()
    { naechster_Zustand(praesentation_ziffernfolge);
    }
  }  
   
  // Zustand Praesentation_Ziffernfolge
  private class Praesentation_Ziffernfolge extends Zustand
  { 
    public void entry() 
    { spielkonsole.starte_Praesentation_Ziffernfolge();
    }
    
    public void praesentation_Ziffernfolge_beendet()
    { naechster_Zustand(memorieren_ziffernfolge);
    }
  }
  
  // Zustand Memorieren_Ziffernfolge
  private class Memorieren_Ziffernfolge extends Zustand
  { 
    public void ziffer_ausgewaehlt(Ziffer ziffer)
    { if(!spielkonsole.ausgewaehlte_Ziffer_korrekt(ziffer))
      { // Fehler
        naechster_Zustand(spiel_beendet);
        return;
      }
      if(spielkonsole.alle_Ziffern_Memoriert())
      { naechster_Zustand(praesentation_ziffernfolge);
        return;
      }
      naechster_Zustand(memorieren_ziffernfolge);
    }
  }
  
  // Zustand Spiel_beendet
  private class Spiel_beendet extends Zustand
  { 
    public void ziffer_ausgewaehlt(Ziffer ziffer)
    { naechster_Zustand(praesentation_ziffernfolge);
    }

    public void exit() 
    { spielkonsole.beginne_neue_Ziffernfolge();
    }
  }
}