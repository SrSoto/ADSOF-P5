package p4clases;


public class Terminal extends Nodo{
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
