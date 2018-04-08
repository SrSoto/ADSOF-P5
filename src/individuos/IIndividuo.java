package individuos;

import java.util.*;

import nodos.INodo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

/**
 * Interfaz de metodos para cada individuo de cada generacion.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IIndividuo {
	/**
	 * Devuelve un Nodo que representa la ra�z, es decir, el Nodo inicial del
	 * individuo. Denominaremos expresi�n a la representaci�n del individuo mediante
	 * nodos.
	 * 
	 * @return El nodo inicial del individuo.
	 */
	public INodo getExpresion();

	/**
	 * Setter del nodo inicial de un individuo, o nodo ra�z, para incializar un
	 * individuo.
	 * 
	 * @param expresion
	 *            El nodo inicial del individuo.
	 */
	public void setExpresion(INodo expresion);

	/**
	 * Devuelve el fitness del individuo, es decir, cuanto se acerca a resolver el
	 * problema.
	 * 
	 * @return Double con el grado de resolucion del problema.
	 */
	public double getFitness();

	/**
	 * Establece un valor optimo de resolucion del problema.
	 * 
	 * @param fitness
	 *            valor de resolucion del problema
	 */
	public void setFitness(double fitness);

	/**
	 * Construye un individuo aleatorio. Se utilizar� cuando se cree la poblaci�n
	 * inicial.
	 * 
	 * @param profundidad
	 *            profundidad m�xima del arbol que representa al individuo
	 * @param terminales
	 *            Terminales que puede tener un individuo
	 * @param funciones
	 *            Funciones que puede tener un individuo
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);

	/**
	 * Realiza la operacion representada por la expresi�n.
	 * 
	 * @return double con el valor de la expresion.
	 */
	public double calcularExpresion();

	/**
	 * Devuelve el numero de nodos totales del individuo.
	 * 
	 * @return El numero de nodos totales del individuo.
	 */
	public int getNumeroNodos();

	/**
	 * Muestra la expresi�n que corresponde al individuo.
	 */
	public void writeIndividuo();
}
