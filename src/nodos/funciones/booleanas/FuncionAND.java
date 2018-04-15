package nodos.funciones.booleanas;

import java.util.List;

import nodos.INodo;

public class FuncionAND extends FuncionBooleana {

	public FuncionAND(String raiz, int nHijos) {
		super(raiz, nHijos);
	}

	@Override
	public boolean calcularBooleano() {
		boolean ret = true;
		List<INodo> descendientes = this.getDescendientes();
		for (int i = 0; i < getNHijos(); i++) {
			ret = (ret)&&(descendientes.get(i).calcularBooleano());
		}
		return ret;
	}

	@Override
	public INodo copy() {
		FuncionAND copy = new FuncionAND(" AND ",this.getNHijos());
		for(INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo);
		}
		return copy;
	}


}
