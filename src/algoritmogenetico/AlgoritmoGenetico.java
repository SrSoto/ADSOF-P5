package algoritmogenetico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import cruces.CruceNuloException;
import dominio.ArgsDistintosFuncionesException;
import dominio.Dominio;
import dominio.DominioAritmetico;
import dominio.IDominio;
import individuos.IIndividuo;
import individuos.Individuo;
import individuos.IndividuoSorter;
import nodos.Nodo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

/**
 * Clase de nuestro algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class AlgoritmoGenetico implements IAlgoritmo {
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private List<IIndividuo> individuos;
	private final static int nIndividuos = 500;
	private final static int maxGeneraciones = 5000;
	private final static int profundidadInicial = 3;
	private final static int elitismo = 50;
	private static final int kTorneo = 8;
	private static double bestFitness = 0;

	public static void main(String[] args) throws ArgsDistintosFuncionesException, FileNotFoundException, IOException {
		Dominio dominio = new DominioAritmetico();
		int[] argumentos = { 2, 2, 2 };
		String[] funciones = new String[] { "+", "*", "-" };
		dominio.definirValoresPrueba("valores.txt");
		AlgoritmoGenetico polinomios = new AlgoritmoGenetico();
		polinomios.defineConjuntoTerminales(dominio.definirConjuntoTerminales("x"));
		polinomios.defineConjuntoFunciones(dominio.definirConjuntoFunciones(argumentos, funciones));
		polinomios.ejecutar(dominio);
	}

	/**
	 * Define el conjunto de terminales del algoritmo genético.
	 * 
	 * @param terminales
	 *            Lista de los terminales de los que dispondrán los individuos del
	 *            algoritmo.
	 */
	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;

	}

	/**
	 * Define el conjunto de funciones del algoritmo genético.
	 * 
	 * @param funciones
	 *            Lista de las funciones del dominio.
	 * @throws ArgsDistintosFuncionesException
	 *             En caso de haber distinto número entre los argumentos de cada
	 *             función y de las funciones.
	 */
	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;

	}

	/**
	 * Crea la primera población del algoritmo.
	 */
	@Override
	public void crearPoblacion() {
		individuos = new ArrayList<IIndividuo>();
		for (int i = 0; i < nIndividuos; i++) {
			IIndividuo individuo = new Individuo();
			individuo.crearIndividuoAleatorio(profundidadInicial, terminales, funciones);
			individuos.add(individuo);
		}
	}

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
	@Override
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		Random rand = new Random();
		List<IIndividuo> retorno = new ArrayList<IIndividuo>();

		int etiqueta1 = rand.nextInt(prog1.getNumeroNodos() - 1);
		int etiqueta2 = rand.nextInt(prog2.getNumeroNodos() - 1);

		if (etiqueta1 + etiqueta2 == 0) {
			throw new CruceNuloException();
		}

		// System.out.println("Punto de cruce del progenitor 1: " + etiqueta1);
		// System.out.println("Punto de cruce del progenitor 2: " + etiqueta2);

		Nodo nodo1 = (Nodo) ((Individuo) prog1).buscarPorEtiqueta(etiqueta1);
		Nodo nodo2 = (Nodo) ((Individuo) prog2).buscarPorEtiqueta(etiqueta2);
		Individuo copia1 = ((Individuo) prog1).copy();
		Individuo copia2 = ((Individuo) prog2).copy();

		copia1.reemplazar(etiqueta1, nodo2);
		copia2.reemplazar(etiqueta2, nodo1);

		// System.out.println("\nDESCENDIENTE 1 (Prueba Cruce)");
		// copia1.writeIndividuo();
		// System.out.println("DESCENDIENTE 2 (Prueba Cruce)");
		// copia2.writeIndividuo();

		retorno.add(copia1);
		retorno.add(copia2);

		return retorno;
	}

	void evaluarPoblacion(IDominio dominio) {
		for (int j = 0; j < nIndividuos; j++) {
			dominio.calcularFitness(individuos.get(j));
		}
		Collections.sort(individuos, new IndividuoSorter());
		Individuo mejorIndividuo = (Individuo) individuos.get(0);
		bestFitness = mejorIndividuo.getFitness();

		System.out.println("Mejor individuo: ");
		mejorIndividuo.writeIndividuo();
		System.out.println("Fitness: " + bestFitness);
	}

	/**
	 * Crea una nueva población a partir de la anterior.
	 */
	@Override
	public void crearNuevaPoblacion() {
		Random rand = new Random();
		List<IIndividuo> nuevosIndividuos = new ArrayList<IIndividuo>();
		List<IIndividuo> torneo = new ArrayList<IIndividuo>();

		// System.out.println("Peor individuo:");
		// Individuo peorIndividuo = (Individuo) individuos.get(nIndividuos-1);
		// System.out.println("Fitness: " + peorIndividuo.getFitness());
		// peorIndividuo.writeIndividuo();

		for (int i = 0; i < elitismo; i++) {
			nuevosIndividuos.add(((Individuo) individuos.get(nIndividuos - (i + 1))).copy());
		}

		for (int i = elitismo; i < nIndividuos; i += 2) {
			torneo.clear();
			for (int j = 0; j < kTorneo; j++) {
				torneo.add(((Individuo) individuos.get(rand.nextInt(nIndividuos))).copy());
			}
			Collections.sort(torneo, new IndividuoSorter());
			Individuo prog1 = (Individuo) torneo.get(0);
			Individuo prog2 = (Individuo) torneo.get(1);
			try {
				nuevosIndividuos.addAll(cruce(prog1, prog2));
			} catch (CruceNuloException e) {
				nuevosIndividuos.add(prog1.copy());
				nuevosIndividuos.add(prog2.copy());
			}
		}
		this.individuos = nuevosIndividuos;
	}

	/**
	 * Ejecuta el algoritmo genético a partir de un dominio dado.
	 * 
	 * @param dominio
	 *            Dominio del algoritmo genético.
	 */
	@Override
	public void ejecutar(IDominio dominio) {
		double fitnessObjetivo = dominio.fitnessObjetivo();
		crearPoblacion();

		int i;
		for (i = 0; i < maxGeneraciones; i++) {
			System.out.println("Generacion " + i);
			evaluarPoblacion(dominio);
			if (bestFitness == fitnessObjetivo) {
				break;
			}
			crearNuevaPoblacion();
		}

		if (i == maxGeneraciones) {
			System.out.println("Se ha alcanzado el maximo de iteraciones: fin del programa.");
		} else {
			dominio.calcularFitnessDebug(individuos.get(0));

			System.out.println("¡FIN DEL PROGRAMA!");
		}

	}

}
