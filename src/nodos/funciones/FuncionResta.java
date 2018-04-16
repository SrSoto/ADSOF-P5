package nodos.funciones;

import java.util.List;

import nodos.INodo;

/**
 * Este programa implementa el nodo funci�n correspondiente a la resta, para el
 * �rbol de nodos de cada individuo de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class FuncionResta extends Funcion {

	/**
	 * Constructor del nodo funci�n resta.
	 * 
	 * @param raiz
	 *            String con el s�mbolo de la resta.
	 * @param nHijos
	 *            N�mero de hijos de la funci�n resta.
	 */
	public FuncionResta(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	/**
	 * Calcula el valor del nodo. Consiste en llamar recursivamente a las funciones
	 * calcular de los descendientes de este nodo funci�n resta, y calcular la resta
	 * de dichas llamadas a calcular.
	 * 
	 * @return double Resultado de restar al primer descendiente el resto de las
	 *         llamadas recursivas a calcular de cada descendiente.
	 */
	@Override
	public double calcular() {
		double ret = 0;
		List<INodo> descendientes = this.getDescendientes();
		/*
		 * Atenci�n aqu� al hecho de inicializar ret con el resultado del primer hijo.
		 * La resta N-aria como tal no tiene sentido, pero la hemos definido como
		 * aplicar N-1 restas (a - b - c - ... - z).
		 */
		ret = descendientes.get(0).calcular();
		for (int i = 1; i < getNHijos(); i++) {
			ret -= descendientes.get(i).calcular();
		}
		return ret;
	}

	/**
	 * Devuelve una copia de este nodo.
	 * 
	 * @return INodo con la copia del nodo funci�n.
	 */
	@Override
	public INodo copy() {
		FuncionResta copy = new FuncionResta("-", this.getNHijos());
		for (INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}

}
