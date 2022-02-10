package it.unisa.lascopa.util;

public class Utility {

	
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
