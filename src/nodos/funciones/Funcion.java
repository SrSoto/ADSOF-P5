package nodos.funciones;

import java.util.List;
import java.util.Random;

import nodos.INodo;
import nodos.Nodo;
import nodos.terminales.Terminal;

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
		getDescendientes().add(nodo.copy());
	}

	/**
	 * Devuelve el número de hijos con los que opera la función.
	 * 
	 * @return int con el número de hijos.
	 */
	public int getNHijos() {
		return this.nHijos;
	}

	/**
	 * Devuelve la String que representa el nodo y sus descendientes en notación
	 * infijo.
	 * 
	 * @return String con la expresión infijo del nodo.
	 */
	public String toString() {
		String ret = "(";
		List<INodo> descendientes = this.getDescendientes();
		for (int i = 0; i < nHijos - 1; i++) {
			ret += descendientes.get(i) + this.getRaiz();
		}
		return ret + descendientes.get(nHijos - 1) + ")";
	}

	/**
	 * Construye un arbol aleatorio de profundidad dada.
	 * 
	 * @param profundidad
	 *            Hasta qué profundidad llamar a esta funcion recursivamente
	 * @param terminales
	 *            Lista de posibles terminales
	 * @param funciones
	 *            Lista de posible funciones.
	 */
	public void arbolAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		Random rand = new Random();
		int funcionesSize = funciones.size();
		int terminalesSize = terminales.size();

		if (profundidad == 0) {
			return;
		} else if (profundidad == 1) {
			for (int i = 0; i < this.nHijos; i++) {
				this.incluirDescendiente(terminales.get(rand.nextInt(terminalesSize)));
			}
		} else {
			for (int i = 0; i < nHijos; i++) {
				this.incluirDescendiente(funciones.get(rand.nextInt(funcionesSize)));
			}
			for (INodo descendiente : this.getDescendientes()) {
				((Funcion) descendiente).arbolAleatorio(profundidad - 1, terminales, funciones);
			}
		}
		return;
	}

}
