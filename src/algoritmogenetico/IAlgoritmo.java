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
 * Interfaz que representa los m�todos de un algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IAlgoritmo {
	/**
	 * Define el conjunto de terminales del algoritmo gen�tico.
	 * 
	 * @param terminales
	 *            Lista de los terminales de los que dispondr�n los individuos del
	 *            algoritmo.
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);

	/**
	 * Define el conjunto de funciones del algoritmo gen�tico.
	 * 
	 * @param funciones
	 *            Lista de las funciones del dominio.
	 * @throws ArgsDistintosFuncionesException
	 *             En caso de haber distinto n�mero entre los argumentos de cada
	 *             funci�n y de las funciones.
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	/**
	 * Crea la primera poblaci�n del algoritmo.
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
	 *             Cuando se intenta realizar un cruce entre los nodos ra�z de cada
	 *             individuo.
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	/**
	 * Crea una nueva poblaci�n a partir de la anterior.
	 */
	public void crearNuevaPoblacion();

	/**
	 * Ejecuta el algoritmo gen�tico a partir de un dominio dado.
	 * @param dominio Dominio del algoritmo gen�tico.
	 */
	public void ejecutar(IDominio dominio);
}
