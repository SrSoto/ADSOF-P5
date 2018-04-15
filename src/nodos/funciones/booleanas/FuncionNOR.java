package nodos.funciones.booleanas;

import java.util.List;

import nodos.INodo;

public class FuncionNOR extends FuncionBooleana {

	
	public FuncionNOR(String raiz, int nHijos) {
		super(raiz, nHijos);
	}
	
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

	@Override
	public INodo copy() {
		FuncionNOR copy = new FuncionNOR(" NOR ",this.getNHijos());
		for(INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}

}
