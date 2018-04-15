package nodos.funciones.booleanas;

import nodos.funciones.Funcion;

public abstract class FuncionBooleana extends Funcion {

	public FuncionBooleana(String raiz, int nHijos) {
		super(raiz,nHijos);
	}

	@Override
	public double calcular() {
		return 0;
	}

	public abstract boolean calcularBooleano();

}
