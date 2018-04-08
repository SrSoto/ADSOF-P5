package p4clases;


/**
 * Clase que implementa el nodo hoja para los arboles de la representacion de un
 * individuo de nuestro algoritmo genetico
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class Terminal extends Nodo {
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
	 * Realiza una copia del nodo.
	 * 
	 * @return una copia del nodo.
	 */
	public INodo copy() {
		Terminal copy = new Terminal(this.getRaiz());
		return copy;
	}

	/**
	 * Permite devolver un valor asociado al nodo. En el caso de un terminal ser�
	 * simplemente un valor determinado, pero en el caso de las funciones deber�a
	 * resolver alguna operaci�n.
	 * 
	 * @return Valor del terminal o de la operacion recursiva.
	 */
	@Override
	public double calcular() {
		return 0;
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
