package nodos.terminales;

import nodos.INodo;
import nodos.Nodo;

/**
 * Clase que implementa el nodo hoja para los arboles de la representacion de un
 * individuo de nuestro algoritmo genetico
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public abstract class Terminal extends Nodo {
	public Terminal(String simbolo) {
		super(simbolo);
	}

	/**
	 * A�ade un nuevo nodo (Terminal o Funci�n) a un nodo existente.
	 * 
	 * @param nodo
	 *            nodo a incluir en la lista de descendientes.
	 */
	public void incluirDescendiente(INodo nodo) {
		return;
	}


	/**
	 * Devuelve la String que representa al terminal, es decir, su s�mbolo.
	 * 
	 * @return String con el s�mbolo del terminal
	 */
	public String toString() {
		return getRaiz();
	}
}
