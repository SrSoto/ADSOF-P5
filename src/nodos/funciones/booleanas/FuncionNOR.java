package nodos.funciones.booleanas;

import java.util.List;

import nodos.INodo;

/**
 * Este programa implementa el nodo funci�n correspondiente al NOR, para el
 * apartado opcional de nuestra pr�ctica sobre algoritmos gen�ticos.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class FuncionNOR extends FuncionBooleana {

	/**
	 * Constructor de una funci�n NOR
	 * 
	 * @param raiz
	 *            Simbolo del nodo
	 * @param nHijos
	 *            Numero de hijos con los que opera la funcion
	 */
	public FuncionNOR(String raiz, int nHijos) {
		super(raiz, nHijos);
	}
	
	/**
	 * Calcula el resultado booleano de la funci�n.
	 * 
	 * @return NOR de todos los resultados de la expresi�n booleana en los hijos del
	 *         nodo.
	 */
	@Override
	public boolean calcularBooleano() {
		boolean ret;
		List<INodo> descendientes = this.getDescendientes();
		ret = descendientes.get(0).calcularBooleano();
		for (int i = 1; i < getNHijos(); i++) {
			ret = (ret)||(descendientes.get(i).calcularBooleano());
		}
		return !ret;
	}

	/**
	 * Devuelve una copia de este nodo.
	 * 
	 * @return INodo con la copia del nodo funci�n.
	 */
	@Override
	public INodo copy() {
		FuncionNOR copy = new FuncionNOR(" NOR ",this.getNHijos());
		for(INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}

}
