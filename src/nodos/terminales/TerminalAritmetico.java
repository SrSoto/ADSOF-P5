package nodos.terminales;

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

	public TerminalAritmetico(String simbolo) {
		super(simbolo);
	}
	
	/**
	 * Asigna el valor del nodo hoja
	 * 
	 * @param double valor del nodo hoja
	 */
	public static void setValor(double v) {
		valor=v;
	}
	
	/**
	 * Devuelve el valor del nodo hoja
	 * 
	 * @return double valor del nodo hoja
	 */
	public static double getValor() {
		return valor;
	}

}