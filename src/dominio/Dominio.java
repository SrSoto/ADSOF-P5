package dominio;

import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

public abstract class Dominio implements IDominio {
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> ret = new ArrayList<Terminal>();
		for(String s : terminales) {
			
		}
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularFitness(IIndividuo individuo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
