package nodos.funciones.booleanas;

import nodos.funciones.Funcion;

/**
 * Este programa implementa el nodo función correspondiente a las operaciones
 * booleanas, para el apartado opcional de nuestra práctica sobre algoritmos
 * genéticos.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public abstract class FuncionBooleana extends Funcion {

	/**
	 * Constructor de una función booleana
	 * 
	 * @param raiz
	 *            Simbolo del nodo
	 * @param nHijos
	 *            Numero de hijos con los que opera la funcion
	 */
	public FuncionBooleana(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	/**
	 * Calcula el resultado aritmético de la función.
	 * 
	 * @return un double, en nuestro caso cero dado que no hará uso de esta función
	 *         las funciones booleanas.
	 */
	@Override
	public double calcular() {
		return 0;
	}

	/**
	 * Calcula el valor booleano de la expresión.
	 * 
	 * @return booleano con el valor de la expresión.
	 */
	public abstract boolean calcularBooleano();

}
