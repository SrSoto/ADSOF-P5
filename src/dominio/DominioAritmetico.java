package dominio;

import java.io.*;
import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.*;
import nodos.terminales.Terminal;
import nodos.terminales.TerminalAritmetico;

/**
 * Este programa contiene la implementación de la clase del dominio aritmético
 * para un algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class DominioAritmetico extends Dominio {
	private static final double margen = 0;
	private TreeMap<Double, Double> valoresPrueba = new TreeMap<Double, Double>();

	/**
	 * Devuelve el conjunto de terminales a partir de la lista de sus simbolos
	 * 
	 * @param String...
	 *            conjunto de simbolos de los terminales a añadir
	 * @return List<Terminal> devuelve la lista de terminales añadidos
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> retorno = new ArrayList<Terminal>();
		for (String terminal : terminales) {
			retorno.add(new TerminalAritmetico(terminal));
		}
		return retorno;
	}

	/**
	 * Define el conjunto de funciones del dominio aritmético.
	 * 
	 * @param argumentos
	 *            Lista con el número de argumentos de cada función
	 * @param funciones
	 *            Lista con los símbolos de cada función
	 * @return Lista con los nodos de función del dominio.
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
			case "*": {
				ret.add(new FuncionMultiplicacion(funciones[i], argumentos[i]));
			}
			case "+": {
				ret.add(new FuncionSuma(funciones[i], argumentos[i]));
			}
			case "-": {
				ret.add(new FuncionResta(funciones[i], argumentos[i]));
			}
			}
		}
		return ret;
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
			token = linea.split("\t");
			valoresPrueba.put(Double.parseDouble(token[0]), Double.parseDouble(token[1]));
		}
		buffer.close();
	}

	/**
	 * Devuelve el fitness objetivo del algoritmo gen�tico, que consiste para un
	 * dominio aritmetico en el numero de valores a acertar.
	 */
	public double fitnessObjetivo() {
		return valoresPrueba.keySet().size();
	}

	/**
	 * Calcula el fitness dado un individuo en concordancia con el dominio
	 * aritmético establecido.
	 * 
	 * @param individuo
	 *            El individuo a examinar
	 * @return double con el valor del fitness, que se trata del número de valores
	 *         del polinomio coincidentes.
	 */
	@Override
	public double calcularFitness(IIndividuo individuo) {
		int fitness = 0;
		double valor;
		Set<Double> valores = valoresPrueba.keySet();
		for (Double d : valores) {
			TerminalAritmetico.setValor(d);
			valor = individuo.calcularExpresion();
			if (Math.abs(valor - this.valoresPrueba.get(d).doubleValue()) <= margen) {
				fitness++;
				//fitness+=d.doubleValue();
			}
			//System.out.println(	"Valor " + d + "<-> Rdo estimado: " + valor + " <-> Rdo real: " + this.valoresPrueba.get(d));
		}
		// System.out.println("Fitness en calcularFitness: " + fitness);
		individuo.setFitness(fitness);
		return fitness;
	}
	
	public double calcularFitnessDebug(IIndividuo individuo) {
		int fitness = 0;
		double valor;
		Set<Double> valores = valoresPrueba.keySet();
		for (Double d : valores) {
			TerminalAritmetico.setValor(d);
			valor = individuo.calcularExpresion();
			if (Math.abs(valor - this.valoresPrueba.get(d).doubleValue()) <= margen) {
				fitness++;
				//fitness+=d.doubleValue();
			}
			System.out.println(	"Valor " + d + "<-> Rdo estimado: " + valor + " <-> Rdo real: " + this.valoresPrueba.get(d));
		}
		// System.out.println("Fitness en calcularFitness: " + fitness);
		individuo.setFitness(fitness);
		return fitness;
	}

}
