package p4clases;

import java.util.List;

public class Funcion extends Nodo{

	public Funcion(String raiz) {
		super(raiz);
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		if(nodo == null) {
			return;
		}
		getDescendientes().add(nodo);
		
	}

	@Override
	public double calcular() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public INodo copy() {
		Terminal copy = new Terminal(this.getRaiz());
		List<INodo> descendientes = this.getDescendientes();
		for(INodo descendiente: descendientes) {
			copy.incluirDescendiente(descendiente);
		}
		return copy;
	}
	
	
	
	
}
