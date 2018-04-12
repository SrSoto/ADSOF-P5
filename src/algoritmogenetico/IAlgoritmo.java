package algoritmogenetico;

import java.util.List;

import cruces.CruceNuloException;
import dominio.ArgsDistintosFuncionesException;
import dominio.IDominio;
import individuos.IIndividuo;
import individuos.Individuo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

/**
 * Interfaz que representa los métodos de un algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IAlgoritmo {
	/**
	 * Define el conjunto de terminales del algoritmo genético.
	 * 
	 * @param terminales
	 *            Lista de los terminales de los que dispondrán los individuos del
	 *            algoritmo.
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);

	/**
	 * Define el conjunto de funciones del algoritmo genético.
	 * 
	 * @param funciones
	 *            Lista de las funciones del dominio.
	 * @throws ArgsDistintosFuncionesException
	 *             En caso de haber distinto número entre los argumentos de cada
	 *             función y de las funciones.
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	/**
	 * Crea la primera población del algoritmo.
	 */
	public void crearPoblacion();

	/**
	 * Realiza un cruce entre dos individuos, devolviendo a partir de los dos
	 * progenitores dos nuevos individuos.
	 * 
	 * @param prog1
	 *            Progenitor 1.
	 * @param prog2
	 *            Progenitor 2.
	 * @return Lista de nuevos individuos.
	 * @throws CruceNuloException
	 *             Cuando se intenta realizar un cruce entre los nodos raíz de cada
	 *             individuo.
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	/**
	 * Crea una nueva población a partir de la anterior.
	 */
	public void crearNuevaPoblacion();

	/**
	 * Ejecuta el algoritmo genético a partir de un dominio dado.
	 * @param dominio Dominio del algoritmo genético.
	 */
	public void ejecutar(IDominio dominio);
}
