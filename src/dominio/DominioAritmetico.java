package dominio;

import java.io.*;
import java.util.List;

import individuos.IIndividuo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

public class DominioAritmetico extends Dominio {
	private HashMap<>
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
		
	}

	@Override
	public double calcularFitness(IIndividuo individuo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
