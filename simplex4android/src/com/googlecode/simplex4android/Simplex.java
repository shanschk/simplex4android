package com.googlecode.simplex4android;

import java.io.IOException;
import java.util.Arrays;

/**
 * Klasse Simplex - legt eine History an, nimmt die Eingabe entgegen, verarbeitet diese, l�sst das Problem je nach Settings 
 * von SimplexLogic l�sen und sorgt f�r die Ausgabe.
 * @author Simplex4Android
 */
public class Simplex {
	
	public Simplex(){
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
		firstProblem.setPivots(SimplexLogic.findPivots(firstProblem));
		firstProblem.addPivotColumn(1);
		if(debug == true){System.out.println("Tableau: \n" + firstProblem.tableauToString());}
		if(debug == true){System.out.println("Zielfunktion: " + firstProblem.targetToString());}
			
		//SimplexProblem in History einf�gen
		sh.addElement(firstProblem);
		firstProblem = SimplexLogic.calcDeltas(firstProblem);
		
		if(debug == true){System.out.println("Tableau: \n" + firstProblem.tableauToString());} 
		if(debug == true){System.out.println("Zielfunktion: " + firstProblem.targetToString());}

		//SimplexLogic auf SimplexProblem(e) ausf�hren, bis optimale L�sung gefunden, dabei Ausgabe aller Zwischenschritte
		for(int i=0;i<2;i++){
			SimplexProblem current = sh.getLastElement();
			current = SimplexLogic.simplex(current);
			
			//Debug-Ausgabe
			if(debug == true){System.out.println("Tableau: \n" + current.tableauToString());}
			if(debug == true){System.out.println("Basisspalten: " + Arrays.toString(current.getPivots()));}
			if(debug == true){System.out.println("Aktuell gew�hlte Pivotspalte: "+SimplexLogic.choosePivotRow(current));}
			
			sh.addElement(current);
		}
	}

	
	
}
