package dominio;

import java.io.*;
import java.util.*;
import individuos.*;
import nodos.funciones.*;
import nodos.terminales.*;

/**
 * Interfaz de metodos para los dominios de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IDominio {
	/**
	 * Define el conjunto de terminales a partir de los s�mbolos de los mismos.
	 * 
	 * @param terminales
	 *            Strings con el s�mbolo de cada terminal
	 * @return Lista de nodos terminales, construidos a partir de los s�mbolos
	 *         dados.
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);

	/**
	 * Define el conjunto de funciones a partir del n�mero de argumentos y los
	 * s�mbolos de las funciones.
	 * 
	 * @param argumentos
	 *            Lista de enteros que indican el n�mero de argumentos que acepta
	 *            cada funci�n.
	 * @param funciones
	 *            S�mbolos de las funciones a establecer en el dominio
	 * @return Lista con los nodos funci�n del dominio, creados sabiendo los
	 *         argumentos y s�mbolos de cada funci�n.
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
	 *             En caso de excepci�n de entrada/salida.
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;

	/**
	 * Devuelve el fitness objetivo del dominio, es decir, el objetivo que una vez
	 * alcanzado detiene el algoritmo.
	 * 
	 * @return doble con el valor de fitness m�ximo.
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
