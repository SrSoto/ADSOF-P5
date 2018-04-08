package p4clases;

/**
 * Clase abstracta de funciones, que son nodos con descendientes que forman el
 * árbol que representa un individuo.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public abstract class Funcion extends Nodo {

	private int nHijos;

	/**
	 * Constructor de un nodo función.
	 * 
	 * @param raiz
	 *            Símbolo que representa la función (String)
	 * @param nHijos
	 *            Entero con el número de hijos de la función
	 */
	public Funcion(String raiz, int nHijos) {
		super(raiz);
		this.nHijos = nHijos;
	}

	/**
	 * Añade un descendiente a la lista de descendientes de la función.
	 * 
	 * @param nodo
	 *            El nodo a añadir. Un terminal o bien otro nodo de función.
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
	 * @return INodo con la copia del nodo función.
	 */
	@Override
	public INodo copy() {
		Terminal copy = new Terminal(this.getRaiz());
		copy.getDescendientes().addAll(this.getDescendientes());
		return copy;
	}

	/**
	 * Devuelve el número de hijos con los que opera la función.
	 * 
	 * @return int con el número de hijos.
	 */
	public int getNHijos() {
		return this.nHijos;
	}

}
