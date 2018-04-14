package dominio;

import java.io.*;
import java.util.*;
import individuos.*;
import nodos.funciones.*;
import nodos.terminales.*;

/**
 * Interfaz de metodos para los dominios de nuestro algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IDominio {
	/**
	 * Define el conjunto de terminales a partir de los símbolos de los mismos.
	 * 
	 * @param terminales
	 *            Strings con el símbolo de cada terminal
	 * @return Lista de nodos terminales, construidos a partir de los símbolos
	 *         dados.
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);

	/**
	 * Define el conjunto de funciones a partir del número de argumentos y los
	 * símbolos de las funciones.
	 * 
	 * @param argumentos
	 *            Lista de enteros que indican el número de argumentos que acepta
	 *            cada función.
	 * @param funciones
	 *            Símbolos de las funciones a establecer en el dominio
	 * @return Lista con los nodos función del dominio, creados sabiendo los
	 *         argumentos y símbolos de cada función.
	 * @throws ArgsDistintosFuncionesException
	 *             Cuando la longitud de la lista de argumentos no coincide con la
	 *             de funciones.
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException;

	/**
	 * Define los valores de prueba del dominio a partir del path de un fichero de
	 * texto que incluye los datos a obtener.
	 * 
	 * @param ficheroDatos
	 *            Path del fichero para obtener los datos.
	 * @throws FileNotFoundException
	 *             Si no se encuentra el archivo.
	 * @throws IOException
	 *             En caso de excepción de entrada/salida.
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;

	/**
	 * Devuelve el fitness objetivo del dominio, es decir, el objetivo que una vez
	 * alcanzado detiene el algoritmo.
	 * 
	 * @return doble con el valor de fitness máximo.
	 */
	public double fitnessObjetivo();

	/**
	 * Calcula el fitness de un individuo dado, a partir de los valores de prueba
	 * obtenidos previamente.
	 * 
	 * @param individuo
	 *            El individuo a evaluar.
	 * @return double con el fitness correspondiente al individuo.
	 */
	public double calcularFitness(IIndividuo individuo);
}
