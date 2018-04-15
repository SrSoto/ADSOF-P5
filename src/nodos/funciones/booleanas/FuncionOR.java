package nodos.funciones.booleanas;

import java.util.List;

import nodos.INodo;

public class FuncionOR extends FuncionBooleana {

	
	public FuncionOR(String raiz, int nHijos) {
		super(raiz, nHijos);
	}
	
	@Override
	public boolean calcularBooleano() {
		boolean ret = false;
		List<INodo> descendientes = this.getDescendientes();
		for (int i = 0; i < getNHijos(); i++) {
			ret = (ret)||(descendientes.get(i).calcularBooleano());
		}
		return ret;
	}

	@Override
	public INodo copy() {
		FuncionOR copy = new FuncionOR(" OR ",this.getNHijos());
		for(INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}

}
