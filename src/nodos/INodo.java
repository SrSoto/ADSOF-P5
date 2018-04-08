package nodos;

import java.util.*;

/**
 * Interfaz de funciones para cada nodo de los arboles.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface INodo {
	/**
	 * Devuelve el simbolo que representa el nodo, es decir, el s�mbolo del Terminal
	 * o la Funci�n.
	 * 
	 * @return String el simbolo del nodo.
	 */
	public String getRaiz();

	/**
	 * Devuelve los argumentos, en el caso de las funciones. En el caso de los
	 * terminales, la lista de descendientes estar� vac�a.
	 * 
	 * @return Lista con los descendientes del nodo.
	 */
	public List<INodo> getDescendientes();

	/**
	 * A�ade un nuevo nodo (Terminal o Funci�n) a un nodo existente.
	 * 
	 * @param nodo
	 *            nodo a incluir en la lista de descendientes.
	 */
	public void incluirDescendiente(INodo nodo);

	/**
	 * Permite devolver un valor asociado al nodo. En el caso de un terminal ser�
	 * simplemente un valor determinado, pero en el caso de las funciones deber�a
	 * resolver alguna operaci�n.
	 * 
	 * @return Valor del terminal o de la operacion recursiva.
	 */
	public double calcular();

	/**
	 * Realiza una copia del nodo.
	 * 
	 * @return una copia del nodo.
	 */
	public INodo copy();
}
