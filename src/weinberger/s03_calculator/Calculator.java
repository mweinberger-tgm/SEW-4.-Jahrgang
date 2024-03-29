package weinberger.s03_calculator;

import java.util.*;

/**
 * Die abstrakte Klasse Calculator hat die Aufgabe, Werte aus einer Liste mit einem modifier zu ver�ndern und 
 * das Ergebnis als neue Liste zur�ck zu geben. 
 * 
 * Dazu dient die abstrakte Methode processCalculations, die in den konkreten Subklassen so �berschrieben wurde,
 * dass sie je nach Klasse die Werte aus der Liste mit dem modifier addiert, subtrahiert, multipliziert oder dividiert.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-11-12
 */
public class Calculator {

	private List<Double> values;
	private double modifier;
	private Calculate operator;

	/**
	 * Der Konstruktor, der Addtion als Standard-Rechenoperation setzt.
	 */
	public Calculator() {
		this.operator = new Addition();
	}
	
	/**
	 * 
	 * Fuegt einen Double-Wert der Liste hinzu.
	 * 
	 * @param value Der Wert, der hineingespeichert werden soll.
	 * 
	 */
	public void addValue(double value) {
		values.add(value);
	}

	/**
	 * 
	 * @param modifier
	 */
	public void setModifier(double modifier) {
		this.modifier = modifier;
	}

	/**
	 * 
	 * @param value
	 */
	public void removeValue(double value) {
		values.remove(""+value);
	}

	/**
	 * 
	 * @return
	 */
	public List<Double> processCalculations() {
		return operator.processCalculations(values, modifier);
	}

	/**
	 * 
	 */
	public String toString() {
		String out = "";
		Iterator<Double> in = values.iterator();
		while (in.hasNext()) {
			out = "" + in.next() + "\n";
		}
		return out;
	}
	
	/**
	 * 
	 * @param operator
	 */
	public void setCalculation(Calculate operator) {
		this.operator = operator;
	}
}
