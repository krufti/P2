//
// Autor: Sebastian Kruft
// zuletzt geändert: 14.06.2013
//
package ziffernfolge;

public class Ergebnis implements Comparable{
	
	String name;
	int zeit;
	int ziffernanzahl;
	


	@Override
	public int compareTo(Object in) {
		// TODO Auto-generated method stub
		Ergebnis e = (Ergebnis)in;
		
		if(this.zeit == e.zeit){
			return 0;
		}
		
		
		if(this.zeit < e.zeit){
			return -1;
		}else{ 
			return 1;
		}
		
		
		
	
	}

}
