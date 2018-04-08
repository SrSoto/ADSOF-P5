package p4clases;


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

	/**
	 * Devuelve la String que representa al terminal, es decir, su símbolo.
	 * 
	 * @return String con el símbolo del terminal
	 */
	public String toString() {
		return getRaiz();
	}
}
