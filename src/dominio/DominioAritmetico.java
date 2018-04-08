package dominio;

import java.io.*;
import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;
import nodos.terminales.TerminalAritmetico;

public class DominioAritmetico extends Dominio {
	private HashMap<Double, Double> valoresPrueba = new HashMap<Double, Double>();

	/**
	 * Devuelve el conjunto de terminales a partir de la lista de sus simbolos
	 * 
	 * @param String...
	 *            conjunto de simbolos de los terminales a añadir
	 * @return List<Terminal> 
	 * 			  devuelve la lista de terminales añadidos
	 */
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> retorno = new ArrayList<Terminal>();
		for (String terminal : terminales) {
			retorno.add(new TerminalAritmetico(terminal));
		}
		return retorno;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Define los valores para la prueba
	 * 
	 * @param String
	 *            ficheroDatos fichero de donde se carga los datos
	 */
	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		String linea;
		String[] token;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));

		while ((linea = buffer.readLine()) != null) {
			System.out.println(linea);
			token = linea.split("\t");
			valoresPrueba.put(Double.parseDouble(token[0]), Double.parseDouble(token[1]));
		}
		buffer.close();
	}

	@Override
	public double calcularFitness(IIndividuo individuo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
