package nodos.terminales;

import nodos.INodo;

/**
 * Clase que implementa el nodo hoja aritmetico para los arboles de la
 * representacion de un individuo de nuestro algoritmo genetico
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class TerminalAritmetico extends Terminal {
	private static double valor;

	/**
	 * Constructor del terminal aritmetico
	 * 
	 * @param simbolo
	 *            String que representa el nodo.
	 */
	public TerminalAritmetico(String simbolo) {
		super(simbolo);
	}

	/**
	 * Asigna el valor del nodo hoja
	 * 
	 * @param double
	 *            valor del nodo hoja
	 */
	public static void setValor(double v) {
		valor = v;
	}

	/**
	 * Devuelve el valor del nodo hoja
	 * 
	 * @return double valor del nodo hoja
	 */
	public static double getValor() {
		return valor;
	}

	/**
	 * Calcula el valor del nodo. En un terminal aritmético básicamente devuelve el
	 * valor que toma la x.
	 * 
	 * @return doble con el valor que toma la x.
	 */
	@Override
	public double calcular() {
		return valor;
	}

	/**
	 * Realiza una copia del nodo.
	 * 
	 * @return una copia del nodo.
	 */
	public INodo copy() {
		TerminalAritmetico copy = new TerminalAritmetico(this.getRaiz());
		return copy;
	}

}
