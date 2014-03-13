package ziffernfolge;

import ziffernfolge.interfaces.Zufallszahl;

public class LinKongruenz implements Zufallszahl{
		
    int a, b, m, m1, N;
    int x;
    
    public LinKongruenz(){
    	
    	m = 100000000;
    	m1 = 10000;
    	b = 31415821;
    	a = longToInt(System.currentTimeMillis());
    	
    }
    
    public int mult(int p, int q){
    	int p1,p0,q1,q0;
    	
    	p1=p / m1; 
    	p0=p % m1;
    	
    	q1=q / m1; 
    	q0=q % m1;
    	
    	return ((((p0*q1+p1*q0) % m1)*m1+p0*q0) % m);
    }
       

	@Override
	public int naechste() {
		
		a = ((mult(a,b)+1) % m);				
    	
		//return a % 100;
    	return ((a / m1)*101) / m1;
		
	}

	@Override
	public int naechste(int von, int bis) {
		int zw;
		if (von < 0){
			von =0;
		}
		if (bis < 0){
			bis =0;
		}
		if (von > bis){
			von = bis-1;
			
		}
		bis++;		
		a = ((mult(a,b)+1) % m);
		
		zw = ((a / m1)*(bis)) / m1;
		
    	return zw % (bis-von) + von;	
    	
		
	}
	
	private int longToInt(long zahl) {
		return Math.abs((int) zahl);
		
	}

}
