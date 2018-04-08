/**
 * 
 */
package nodos;

import java.util.*;

/**
 * Clase que implementa el nodo para los arboles de la representacion de un
 * individuo de nuestro algoritmo genetico
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public abstract class Nodo implements INodo {

	private final String raiz;
	private List<INodo> descendientes = new ArrayList<INodo>();

	public Nodo(String raiz) {
		this.raiz = raiz;
	}

	/**
	 * Devuelve el simbolo que representa el nodo, es decir, el símbolo del Terminal
	 * o la Función.
	 * 
	 * @return String el simbolo del nodo.
	 */
	@Override
	public String getRaiz() {
		return raiz;
	}
	

	/**
	 * Devuelve los argumentos, en el caso de las funciones. En el caso de los
	 * terminales, la lista de descendientes estará vacía.
	 * 
	 * @return Lista con los descendientes del nodo.
	 */
	@Override
	public List<INodo> getDescendientes() {
		return descendientes;
	}
}
