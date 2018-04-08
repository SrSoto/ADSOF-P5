/**
 * 
 */
package p4clases;

import java.util.*;

/**
 * @author manue
 *
 */
public abstract class Nodo implements INodo{

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
	public List<INodo> getDescendientes(){
		return descendientes;
	}
}
