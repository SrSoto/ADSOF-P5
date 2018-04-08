package p4clases;


public abstract class Funcion extends Nodo{

	private int nHijos;
	
	public Funcion(String raiz, int nHijos) {
		super(raiz);
		this.nHijos = nHijos;
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		if(nodo == null || getDescendientes().size()==nHijos) {
			return;
		}
		getDescendientes().add(nodo);		
	}

	@Override
	public INodo copy() {
		Terminal copy = new Terminal(this.getRaiz());
		copy.getDescendientes().addAll(this.getDescendientes());
		return copy;
	}	

	public int getNHijos() {
		return this.nHijos;
	}
	
}
