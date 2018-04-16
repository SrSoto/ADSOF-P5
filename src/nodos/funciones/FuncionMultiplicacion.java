package nodos.funciones;

import java.util.List;

import nodos.INodo;

/**
 * Este programa implemente el nodo funci�n correspondiente a la multiplicaci�n,
 * para el �rbol de nodos de cada individuo de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class FuncionMultiplicacion extends Funcion {

	/**
	 * Constructor del nodo funci�n multiplicaci�n.
	 * 
	 * @param raiz
	 *            String con el s�mbolo de la multiplicaci�n.
	 * @param nHijos
	 *            N�mero de hijos de la funci�n multiplicaci�n.
	 */
	public FuncionMultiplicacion(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	/**
	 * Calcula el valor del nodo. Consiste en llamar recursivamente a las funciones
	 * calcular de los descendientes de este nodo funci�n multiplicaci�n, y calcular
	 * el producto de dichas llamadas a calcular.
	 * 
	 * @return double Resultado del producto de las llamadas recursivas a calcular
	 *         de cada descendiente.
	 */
	@Override
	public double calcular() {
		double ret = 1;
		/*
		 * Hacer el for con un entero hasta el n�mero de hijos previene el hecho de
		 * calcular expresiones incorrectas en el remoto caso de tener la funci�n m�s
		 * descendientes de los permitidos. Al ser un modelo de caja negra no ocurrir�,
		 * pero es una forma de aprovechar el par�metro del n�mero de hijos que nos
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
	 * @return INodo con la copia del nodo funci�n.
	 */
	@Override
	public INodo copy() {
		/*
		 * Aqu� hay un peque�o pero bastante importante detalle a la hora de crear una
		 * copia: El simbolo establecido debe introducirse como par�metro como la String
		 * que es, no con el m�todo de calcularRaiz. De lo contrario, pasariamos un
		 * puntero a una String y a la hora de aplicar cruces cabe la posibilidad de dar
		 * lugar a que funciones distintas a la multiplicaci�n tengan este signo, lo
		 * cual da a confusi�n en writeIndividuo.
		 */
		FuncionMultiplicacion copy = new FuncionMultiplicacion("*", this.getNHijos());
		for (INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}
}
