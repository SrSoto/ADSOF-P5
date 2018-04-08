package nodos.funciones;

import java.util.List;

import nodos.INodo;

/**
 * Este programa implementa el nodo función correspondiente a la suma, para el
 * árbol de nodos de cada individuo de nuestro algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class FuncionSuma extends Funcion {
	/**
	 * Constructor del nodo función suma.
	 * 
	 * @param raiz
	 *            String con el símbolo de la suma.
	 * @param nHijos
	 *            Número de hijos de la función suma.
	 */
	public FuncionSuma(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	/**
	 * Calcula el valor del nodo. Consiste en llamar recursivamente a las funciones
	 * calcular de los descendientes de este nodo función suma, y calcular el
	 * sumatorio de dichas llamadas a calcular.
	 * 
	 * @return double Resultado de la suma de las llamadas recursivas a calcular de
	 *         cada descendiente.
	 */
	@Override
	public double calcular() {
		double ret = 1;
		List<INodo> descendientes = this.getDescendientes();
		for (int i = 0; i < getNHijos(); i++) {
			ret -= descendientes.get(i).calcular();
		}

		return ret;
	}

}
