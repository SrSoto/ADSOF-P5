package nodos.funciones;

import java.util.List;

import nodos.INodo;

/**
 * Este programa implemente el nodo función correspondiente a la multiplicación,
 * para el árbol de nodos de cada individuo de nuestro algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class FuncionMultiplicacion extends Funcion {

	/**
	 * Constructor del nodo función multiplicación.
	 * 
	 * @param raiz
	 *            String con el símbolo de la multiplicación.
	 * @param nHijos
	 *            Número de hijos de la función multiplicación.
	 */
	public FuncionMultiplicacion(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	/**
	 * Calcula el valor del nodo. Consiste en llamar recursivamente a las funciones
	 * calcular de los descendientes de este nodo función multiplicación, y calcular
	 * el producto de dichas llamadas a calcular.
	 * 
	 * @return double Resultado del producto de las llamadas recursivas a calcular
	 *         de cada descendiente.
	 */
	@Override
	public double calcular() {
		double ret = 1;
		/*
		 * Hacer el for con un entero hasta el número de hijos previene el hecho de
		 * calcular expresiones incorrectas en el remoto caso de tener la función más
		 * descendientes de los permitidos. Al ser un modelo de caja negra no ocurrirá,
		 * pero es una forma de aprovechar el parámetro del número de hijos que nos
		 * pasan por argumento de entrada al constructor en el tester.
		 */
		List<INodo> descendientes = this.getDescendientes();
		for (int i = 0; i < getNHijos(); i++) {
			ret *= descendientes.get(i).calcular();
		}
		return ret;
	}

	/**
	 * Devuelve una copia de este nodo.
	 * 
	 * @return INodo con la copia del nodo función.
	 */
	@Override
	public INodo copy() {
		FuncionMultiplicacion copy = new FuncionMultiplicacion(this.getRaiz(),this.getNHijos());
		for(INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo.copy());
		}
		return copy;
	}
}
