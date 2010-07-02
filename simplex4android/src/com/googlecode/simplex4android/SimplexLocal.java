package com.googlecode.simplex4android;

import java.util.Arrays;

/**
 * Klasse Simplex - legt eine History an, nimmt die Eingabe entgegen, verarbeitet diese, l�sst das Problem je nach Settings 
 * von SimplexLogic l�sen und sorgt f�r die Ausgabe.
 * @author Simplex4Android
 */
public class SimplexLocal {
	
	public SimplexLocal(){
	}
	
	public static void main(String[] args){
		boolean debug = true;
		SimplexHistory sh = new SimplexHistory();
		
		//Settings lesen, SimplexSettings erzeugen
		
		//Eingabe lesen
		//Beispiel-Tableau
		double[][] tableau = {{-1.5,3,0,0,1,-1,6},{0,1,0,1,0,-1,3},{0.5,-1,1,0,0,1,1},{0,0,0,0,0,0,0}}; 
		//Beispiel-Zielfunktion - Zielfunktion muss um eine 0 verl�ngert werden, um Zielwert berechnen zu k�nnen!!!
		int[] target = {1,2,7,5,0,0,0}; 
		
		//SimplexProblem erzeugen (aus Tableau, Target, SimplexSettings)
		SimplexProblem firstProblem = new SimplexProblem(tableau, target);
		if(debug == true){System.out.println("Tableau: \n" + firstProblem.tableauToString());} 
		if(debug == true){System.out.println("Zielfunktion: " + firstProblem.targetToString());}
		//if(debug == true){System.out.println("HTML: "+ firstProblem.tableauToHtml());}

		//SimplexProblem in History einf�gen
		//sh.addElement(firstProblem);
		double[] c = {1,1,1,1,1,1,1,1,1,1};
		firstProblem.addRow(c);
		
		if(debug == true){System.out.println("Tableau: \n" + firstProblem.tableauToString());} 
		if(debug == true){System.out.println("Zielfunktion: " + firstProblem.targetToString());}
		//if(debug == true){System.out.println("HTML: "+ firstProblem.tableauToHtml());}

		//SimplexLogic auf SimplexProblem(e) ausf�hren, bis optimale L�sung gefunden, dabei Ausgabe aller Zwischenschritte
//		do{
//			SimplexProblem current = sh.getLastElement();
//			current = SimplexLogic.simplex(current);
//
//			//Debug-Ausgabe
//			if(debug == true){System.out.println("Tableau: \n" + current.tableauToString());}
//			if(debug == true){System.out.println("Basisspalten: " + Arrays.toString(current.getPivots()));}
//			if(debug == true){System.out.println("Optimal: "+current.getOptimal());}
//			if(debug == true){System.out.println("HTML: "+current.tableauToHtml());}
//			
//			sh.addElement(current);
//		}
//		while(sh.getLastElement().getOptimal()!=true);
	}	
}