package dominio;

import java.io.*;
import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.*;
import nodos.terminales.Terminal;
import nodos.terminales.TerminalAritmetico;

/**
 * Este programa contiene la implementaci�n de la clase del dominio aritm�tico
 * para un algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class DominioAritmetico extends Dominio {
	private HashMap<Double, Double> valoresPrueba = new HashMap<Double, Double>();

	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Define el conjunto de funciones del dominio aritm�tico.
	 * 
	 * @param argumentos
	 *            Lista con el n�mero de argumentos de cada funci�n
	 * @param funciones
	 *            Lista con los s�mbolos de cada funci�n
	 * @return Lista con los nodos de funci�n del dominio.
	 */
	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		List<Funcion> ret = new ArrayList<Funcion>();
		if (argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		for (int i = 0; i < funciones.length; i++) {
			switch (funciones[i]) {
			case ("*"): {
				ret.add(new FuncionMultiplicacion(funciones[i], argumentos[i]));
			}
			case ("+"): {
				ret.add(new FuncionSuma(funciones[i], argumentos[i]));
			}
			case ("-"): {
				ret.add(new FuncionResta(funciones[i], argumentos[i]));
			}
			}
		}
		return ret;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));

	}

	/**
	 * Calcula el fitness dado un individuo en concordancia con el dominio
	 * aritm�tico establecido.
	 * 
	 * @param individuo
	 *            El individuo a examinar
	 * @return double con el valor del fitness, que se trata del n�mero de valores
	 *         del polinomio coincidentes.
	 */
	@Override
	public double calcularFitness(IIndividuo individuo) {
		double fitness = 0;
		double valor;
		Set<Double> valores = valoresPrueba.keySet();
		for (Double d : valores) {
			TerminalAritmetico.setValor(d);
			valor = individuo.calcularExpresion();
			if (valor == valoresPrueba.get(d)) {
				fitness++;
			}
		}
		return fitness;
	}

}
