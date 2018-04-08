package p4clases;

/**
 * Clase abstracta de funciones, que son nodos con descendientes que forman el
 * �rbol que representa un individuo.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public abstract class Funcion extends Nodo {

	private int nHijos;

	/**
	 * Constructor de un nodo funci�n.
	 * 
	 * @param raiz
	 *            S�mbolo que representa la funci�n (String)
	 * @param nHijos
	 *            Entero con el n�mero de hijos de la funci�n
	 */
	public Funcion(String raiz, int nHijos) {
		super(raiz);
		this.nHijos = nHijos;
	}

	/**
	 * A�ade un descendiente a la lista de descendientes de la funci�n.
	 * 
	 * @param nodo
	 *            El nodo a a�adir. Un terminal o bien otro nodo de funci�n.
	 */
	@Override
	public void incluirDescendiente(INodo nodo) {
		if (nodo == null || getDescendientes().size() == nHijos) {
			return;
		}
		getDescendientes().add(nodo);
	}

	/**
	 * Devuelve una copia de este nodo.
	 * 
	 * @return INodo con la copia del nodo funci�n.
	 */
	@Override
	public INodo copy() {
		Terminal copy = new Terminal(this.getRaiz());
		copy.getDescendientes().addAll(this.getDescendientes());
		return copy;
	}

	/**
	 * Devuelve el n�mero de hijos con los que opera la funci�n.
	 * 
	 * @return int con el n�mero de hijos.
	 */
	public int getNHijos() {
		return this.nHijos;
	}

}
