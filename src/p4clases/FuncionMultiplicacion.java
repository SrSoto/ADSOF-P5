package p4clases;

import java.util.List;

public class FuncionMultiplicacion extends Funcion {

	public FuncionMultiplicacion(String raiz, int nHijos) {
		super(raiz, nHijos);
	}


	@Override
	public double calcular() {
		double ret = 1;
		/*
		 * Hacer el for con un entero hasta el n�mero de hijos previene el hecho de calcular
		 * expresiones incorrectas en el remoto caso de tener la funci�n m�s descendientes de los
		 * permitidos. Al ser un modelo de caja negra no ocurrir�, pero es una forma de aprovechar
		 * el par�metro del n�mero de hijos que nos pasan por argumento de entrada al constructor
		 * en el tester.
		 */
		List<INodo> descendientes = this.getDescendientes();
		for(int i = 0; i < getNHijos(); i++) {
			ret *= descendientes.get(i).calcular();
		}
		
		return ret;
	}



}
