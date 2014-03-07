package ziffernfolge.interfaces;

import java.io.FileNotFoundException;

import ziffernfolge.Ergebnisliste;
import ziffernfolge.Liste;

public interface IDatenspeicher {

	public Liste load(String filename) throws FileNotFoundException;

	public void save(String filename, Ergebnisliste ErgList)
			throws FileNotFoundException;	
	
}