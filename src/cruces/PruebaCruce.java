package cruces;

import java.util.*;

import individuos.IIndividuo;
import individuos.Individuo;
import nodos.Nodo;

public class PruebaCruce {

	public static List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		Random rand = new Random();
		List<IIndividuo> retorno = new ArrayList<IIndividuo>();

		int etiqueta1 = rand.nextInt(prog1.getNumeroNodos()-1);
		int etiqueta2 = rand.nextInt(prog2.getNumeroNodos()-1);
		
		if(etiqueta1 + etiqueta2 == 0) {
			throw new CruceNuloException();
		}

		System.out.println("Punto de cruce del progenitor 1: " + etiqueta1);
		System.out.println("Punto de cruce del progenitor 2: " + etiqueta2);

		Nodo nodo1 = (Nodo) ((Individuo) prog1).buscarPorEtiqueta(etiqueta1);
		Nodo nodo2 = (Nodo) ((Individuo) prog2).buscarPorEtiqueta(etiqueta2);
		Individuo copia1 = ((Individuo) prog1).copy();
		Individuo copia2 = ((Individuo) prog2).copy();

		copia1.remplazarNodo(etiqueta1, nodo2);
		copia2.remplazarNodo(etiqueta2, nodo1);

		System.out.println("\nDESCENDIENTE 1 (Prueba Cruce)");
		copia1.writeIndividuo();
		System.out.println("DESCENDIENTE 2 (Prueba Cruce)");
		copia2.writeIndividuo();
		
		retorno.add(copia1);
		retorno.add(copia2);

		return retorno;
	}
}
