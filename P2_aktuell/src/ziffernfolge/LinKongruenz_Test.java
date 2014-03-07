package ziffernfolge;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinKongruenz_Test {

	@Test
	public void Zufallszahl_Bereich() {
		int zahlen[] = new int[7];
		int rand, bereich, anz, von, bis;
		von = 0;		//zufallszahlen von
		bis = 6;		//zufallszahlen bis
		
		bereich = 1000;	// abweichung 
		anz = 100000; //wie viele zufallszahlen sollen erzeugt werden
		
		LinKongruenz random = new LinKongruenz();
		
		for(int i=0; i< anz; i++){
			
			rand = random.naechste(von,bis);
		
			
			
			if(rand == 0){
				zahlen[0]++;
			}
			if(rand == 1){
				zahlen[1]++;
			}
			if(rand == 2){
				zahlen[2]++;
			}
			if(rand == 3){
				zahlen[3]++;
			}
			if(rand == 4){
				zahlen[4]++;
			}
			if(rand == 5){	
				zahlen[5]++;
			}
			if(rand == 6){
				zahlen[6]++;
			}
			
			
			
		}
		System.out.println(zahlen[0]);
		System.out.println(zahlen[1]);
		System.out.println(zahlen[2]);
		System.out.println(zahlen[3]);
		System.out.println(zahlen[4]);
		System.out.println(zahlen[5]);
		System.out.println(zahlen[6]);
		assertTrue(zahlen[0] <= (anz / 7 + bereich) && zahlen[0] >= (anz / 7 - bereich) );
		assertTrue(zahlen[1] <= (anz / 7 + bereich) && zahlen[1] >= (anz / 7 - bereich) );
		assertTrue(zahlen[2] <= (anz / 7 + bereich) && zahlen[2] >= (anz / 7 - bereich) );
		assertTrue(zahlen[3] <= (anz / 7 + bereich) && zahlen[3] >= (anz / 7 - bereich) );
		assertTrue(zahlen[4] <= (anz / 7 + bereich) && zahlen[4] >= (anz / 7 - bereich) );
		assertTrue(zahlen[5] <= (anz / 7 + bereich) && zahlen[5] >= (anz / 7 - bereich) );
		assertTrue(zahlen[6] <= (anz / 7 + bereich) && zahlen[6] >= (anz / 7 - bereich) );
		
		
	}

}
