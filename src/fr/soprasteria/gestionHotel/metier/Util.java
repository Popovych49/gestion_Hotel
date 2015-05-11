package fr.soprasteria.gestionHotel.metier;

import java.util.Scanner;

public class Util {
		
	public static Scanner sc;

	// Afficher du texte
	public static void afficher(String Texte) {
		System.out.println(Texte);
		
	}
	// Afficher du texte
	public static void afficher(double nb) {
		System.out.println(nb);	
	}
	
	// Afficher du texte
	public static void afficher(int[] tab) {
		System.out.println(tab);
			
	}
	
	//Saisir du texte
	public static String lire(){
		Util.sc = new Scanner(System.in);
		String result="";
		result=sc.next();
		return result;
	}
	
	//Saisir du texte
	public static int lirenb(){
		Util.sc = new Scanner(System.in);
		int result=0;
		result=sc.nextInt();
		return result;
	}
	public static void afficher(StringBuffer Texte) {
		System.out.println(Texte);
		
	}	
}
