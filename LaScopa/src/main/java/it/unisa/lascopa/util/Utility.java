package it.unisa.lascopa.util;

/**
 * 
 * @author fiorillo
 * Utility permette di centralizzare i messaggidi controllo in questa versione stampa semplicemente a console ma è possibile cambiare la destinazione come un file di log ad esempio
 */
public class Utility {
	/**
	 * 
	 * @param messages
	 */
	public static void print(String ...messages) {
		String message = "";
		for(String msg : messages) {
			message += msg + "\n";
		}
		System.out.println(message);
	}
	
	public static void print(Object obj,Exception exception) {
		Utility.print("["+ obj.getClass().getSimpleName() +"]EXCEPTION: " + exception.getMessage());
	}
}
