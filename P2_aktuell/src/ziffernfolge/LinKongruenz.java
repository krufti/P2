package ziffernfolge;

import ziffernfolge.interfaces.Zufallszahl;

public class LinKongruenz implements Zufallszahl{
		
    int a, b, m, m1, N;
    int x;
    int[] vo = new int[1],bi = new int[1];
    
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
		vo[0]=von;
		bi[0]=bis;
		if (vo[0] < 0){
			vo[0] =0;
		}
		if (bi[0] < 0){
			bi[0] =0;
		}
		if (vo[0] > bi[0]){
			
			swap(vo,bi);
		}
		
		bi[0]++;		
		a = ((mult(a,b)+1) % m);
		
		zw = ((a / m1)*(bi[0])) / m1;
		
    	return zw % (bi[0]-vo[0]) + vo[0];	
    	
		
	}
	
	public static void swap(int[] a, int[] b) {
	    int t = a[0]; a[0] = b[0]; b[0] = t;
	}
	

	
	private int longToInt(long zahl) {
		return Math.abs((int) zahl);
		
	}

}
