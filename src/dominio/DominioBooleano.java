package dominio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.*;
import nodos.funciones.booleanas.*;
import nodos.terminales.*;

/**
 * Este programa contiene la implementacion de los dominios de algoritmos
 * gen�ticos booleanos.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class DominioBooleano implements IDominio {
	private HashMap<List<Boolean>, Boolean> valoresPrueba = new HashMap<List<Boolean>, Boolean>();

	/**
	 * Devuelve el conjunto de terminales a partir de la lista de sus simbolos
	 * 
	 * @param String...
	 *            conjunto de simbolos de los terminales a añadir
	 * @return List<Terminal> devuelve la lista de terminales añadidos
	 */
	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> retorno = new ArrayList<Terminal>();
		for (String terminal : terminales) {
			retorno.add(new TerminalBooleano(terminal));
		}
		return retorno;
	}

	/**
	 * Define el conjunto de funciones del dominio booleano.
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
		/*
		 * An�loga implementaci�n a la del dominio aritm�tico, pero no abstraible debido
		 * a las llamadas de constructores.
		 */
		for (int i = 0; i < funciones.length; i++) {
			switch (funciones[i]) {
			case " AND ": {
				ret.add(new FuncionAND(funciones[i], argumentos[i]));
			}
			case " OR ": {
				ret.add(new FuncionOR(funciones[i], argumentos[i]));
			}
			case " NAND ": {
				ret.add(new FuncionNAND(funciones[i], argumentos[i]));
			}
			case " NOR ": {
				ret.add(new FuncionNOR(funciones[i], argumentos[i]));
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
			/*
			 * La complicaci�n de los valores de prueba del dominio booleano de varios
			 * terminales consiste en preparar la lista que se introduce en el hashMap.
			 */
			valoresPrueba.put(Arrays.asList(Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),
					Boolean.parseBoolean(token[2])), Boolean.parseBoolean(token[3]));
		}
		buffer.close();
	}

	@Override
	public double fitnessObjetivo() {
		return valoresPrueba.keySet().size();
	}

	@Override
	public double calcularFitness(IIndividuo individuo) {
		int fitness = 0;
		boolean valor;
		Set<List<Boolean>> valores = valoresPrueba.keySet();
		for (List<Boolean> l : valores) {
			// Preparamos los valores booleanos que toman los tres terminales.
			TerminalBooleano.setValor("X", l.get(0));
			TerminalBooleano.setValor("Y", l.get(1));
			TerminalBooleano.setValor("Z", l.get(2));
			valor = individuo.calcularExpresionBooleana();
			if (valor == valoresPrueba.get(l)) {
				fitness++;
			}
		}
		individuo.setFitness(fitness);
		return fitness;
	}

	@Override
	public double calcularFitnessDetallado(IIndividuo individuo) {
		int fitness = 0;
		boolean valor;
		Set<List<Boolean>> valores = valoresPrueba.keySet();
		for (List<Boolean> l : valores) {
			TerminalBooleano.setValor("X", l.get(0));
			TerminalBooleano.setValor("Y", l.get(1));
			TerminalBooleano.setValor("Z", l.get(2));
			valor = individuo.calcularExpresionBooleana();
			if (valor == valoresPrueba.get(l)) {
				fitness++;
			}
			System.out.println(
					"Valor " + l + "<-> Rdo estimado: " + valor + " <-> Rdo real: " + this.valoresPrueba.get(l));
		}
		individuo.setFitness(fitness);
		return fitness;
	}

}
