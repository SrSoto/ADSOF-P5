package p4clases;

import java.util.List;

public class Terminal extends Nodo{
	public Terminal(String simbolo) {
		super(simbolo);
	}

	/**
	 * Añade un nuevo nodo (Terminal o Función) a un nodo existente.
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

	@Override
	public double calcular() {
		return 0;
	}
}
