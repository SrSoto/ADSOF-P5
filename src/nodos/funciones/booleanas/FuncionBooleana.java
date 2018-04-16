package nodos.funciones.booleanas;

import nodos.funciones.Funcion;

/**
 * Este programa implementa el nodo funci�n correspondiente a las operaciones
 * booleanas, para el apartado opcional de nuestra pr�ctica sobre algoritmos
 * gen�ticos.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public abstract class FuncionBooleana extends Funcion {

	/**
	 * Constructor de una funci�n booleana
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
	 * Calcula el resultado aritm�tico de la funci�n.
	 * 
	 * @return un double, en nuestro caso cero dado que no har� uso de esta funci�n
	 *         las funciones booleanas.
	 */
	@Override
	public double calcular() {
		return 0;
	}

	/**
	 * Calcula el valor booleano de la expresi�n.
	 * 
	 * @return booleano con el valor de la expresi�n.
	 */
	public abstract boolean calcularBooleano();

}
