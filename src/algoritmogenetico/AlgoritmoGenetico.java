package algoritmogenetico;

import java.io.*;
import java.util.*;

import cruces.CruceNuloException;
import dominio.*;
import individuos.*;
import nodos.Nodo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

/**
 * Clase de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class AlgoritmoGenetico implements IAlgoritmo {
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private List<IIndividuo> individuos;
	private static int nIndividuos;
	private static int maxGeneraciones;
	private static int profundidadInicial;
	private static int elitismo;
	private static int kTorneo;
	private static double bestFitness = 0;

	/**
	 * Constructor del algoritmo genetico.
	 * 
	 * @param nIndividuos
	 *            N�mero de individuos por generaci�n
	 * @param maxGeneraciones
	 *            M�ximo de generaciones de la ejecuci�n
	 * @param profundidadInicial
	 *            Profundidad de los individuos de la primera poblacion
	 * @param elitismo
	 *            N�mero de individuos que por tener mejor fitness pasar�n a la
	 *            siguiente poblacion directamente.
	 * @param kTorneo
	 *            N�mero de individuos que compiten en cada torneo a la hora de
	 *            crear una nueva poblacion.
	 */
	public AlgoritmoGenetico(int nIndividuos, int maxGeneraciones, int profundidadInicial, int elitismo, int kTorneo) {
		AlgoritmoGenetico.nIndividuos = nIndividuos;
		AlgoritmoGenetico.maxGeneraciones = maxGeneraciones;
		AlgoritmoGenetico.profundidadInicial = profundidadInicial;
		AlgoritmoGenetico.elitismo = elitismo;
		AlgoritmoGenetico.kTorneo = kTorneo;
	}

	public static void main(String[] args) throws ArgsDistintosFuncionesException, FileNotFoundException, IOException {
		DominioAritmetico dominio = new DominioAritmetico();
		int[] argumentos = { 2, 2, 2 };
		String[] funciones = new String[] { "+", "*", "-" };
		dominio.definirValoresPrueba("valores.txt");
		/*
		 * Nuestros par�metros de ejecuci�n se inicializan aqu�: nIndividuos,
		 * maxGeneraciones, profundidadInicial, elitismo y kTorneo.
		 */
		AlgoritmoGenetico polinomios = new AlgoritmoGenetico(500, 7000, 3, 50, 8);
		polinomios.defineConjuntoTerminales(dominio.definirConjuntoTerminales("x"));
		polinomios.defineConjuntoFunciones(dominio.definirConjuntoFunciones(argumentos, funciones));
		//Atenci�n al setter de un fitness razonable para premiar a los individuos de menor n�mero de nodos.
		Individuo.setMinFitness(2);
		polinomios.ejecutar(dominio);
	}

	/**
	 * Define el conjunto de terminales del algoritmo gen�tico.
	 * 
	 * @param terminales
	 *            Lista de los terminales de los que dispondr�n los individuos del
	 *            algoritmo.
	 */
	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;

	}

	/**
	 * Define el conjunto de funciones del algoritmo gen�tico.
	 * 
	 * @param funciones
	 *            Lista de las funciones del dominio.
	 * @throws ArgsDistintosFuncionesException
	 *             En caso de haber distinto n�mero entre los argumentos de cada
	 *             funci�n y de las funciones.
	 */
	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;

	}

	/**
	 * Crea la primera poblaci�n del algoritmo.
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
	 *             Cuando se intenta realizar un cruce entre los nodos ra�z de cada
	 *             individuo.
	 */
	@Override
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		Random rand = new Random();
		List<IIndividuo> retorno = new ArrayList<IIndividuo>();

		// Obtenemos aqu� los puntos del cruce.
		int etiqueta1 = rand.nextInt(prog1.getNumeroNodos() - 1);
		int etiqueta2 = rand.nextInt(prog2.getNumeroNodos() - 1);

		// Si salen la etiqueta ra�z de ambos padres, excepci�n de cruce nulo
		if (etiqueta1 + etiqueta2 == 0) {
			throw new CruceNuloException();
		}

		// Obtenemos los nodos de cada punto de cruce.
		Nodo nodo1 = (Nodo) ((Individuo) prog1).buscarPorEtiqueta(etiqueta1);
		Nodo nodo2 = (Nodo) ((Individuo) prog2).buscarPorEtiqueta(etiqueta2);
		/*
		 * Creamos las copias de los progenitores, que tras reemplazar los nodos seg�n
		 * el cruce ser�n los nuevos hijos
		 */
		Individuo copia1 = ((Individuo) prog1).copy();
		Individuo copia2 = ((Individuo) prog2).copy();

		copia1.reemplazar(etiqueta1, nodo2);
		copia2.reemplazar(etiqueta2, nodo1);

		retorno.add(copia1);
		retorno.add(copia2);

		return retorno;
	}

	/**
	 * Evalua la poblacion en acorde con un dominio dado.
	 * 
	 * @param dominio
	 *            Dominio del cual se evalua el fitness de cada individuo.
	 */
	void evaluarPoblacion(IDominio dominio) {
		// Calculamos el fitness dado el dominio
		for (int j = 0; j < nIndividuos; j++) {
			dominio.calcularFitness(individuos.get(j));
		}
		/*
		 * La lista de individuos queda ordenada mediante individuoSorter de mayor a
		 * menor fitness. En caso de empate de fitness (trat�ndose de un fitness
		 * razonable o (x*x) se apoderar�a de la poblaci�n) se premia al individuo con
		 * menos nodos.
		 */
		Collections.sort(individuos, new IndividuoSorter());
		Individuo mejorIndividuo = (Individuo) individuos.get(0);
		bestFitness = mejorIndividuo.getFitness();
		// Mostramos por pantalla los datos del mejor individuo de la poblaci�n
		// evaluada.
		System.out.println("Mejor individuo: ");
		mejorIndividuo.writeIndividuo();
		System.out.println("Fitness: " + bestFitness);
	}

	/**
	 * Crea una nueva poblaci�n a partir de la anterior.
	 */
	@Override
	public void crearNuevaPoblacion() {
		Random rand = new Random();
		List<IIndividuo> nuevosIndividuos = new ArrayList<IIndividuo>();
		List<IIndividuo> torneo = new ArrayList<IIndividuo>();
		/*
		 * De los individuos cogemos tantos de mejor fitness como par�metro de elitismo
		 * hayamos establecido. Estos individuos pasan directamente a la nueva
		 * poblaci�n.
		 */
		for (int i = 0; i < elitismo; i++) {
			nuevosIndividuos.add(((Individuo) individuos.get(nIndividuos - (i + 1))).copy());
		}
		// Este bucle a�ade los individuos restantes mediante torneo.
		for (int i = elitismo; i < nIndividuos; i += 2) {
			// Limpiamos la lista de torneo, no necesitamos los seleccionados anteriormente.
			torneo.clear();
			// Elegimos ahora al azar a los individuos que participan (depende del par�metro
			// kTorneo)
			for (int j = 0; j < kTorneo; j++) {
				torneo.add(((Individuo) individuos.get(rand.nextInt(nIndividuos))).copy());
			}
			// Se vuelve a ordenar segun individuoSorter (explicado en evaluarPoblacion)
			Collections.sort(torneo, new IndividuoSorter());
			// Obtenemos los dos mejores y el resultado de su cruce va a parar a la nueva
			// poblaci�n.
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
	 * Ejecuta el algoritmo gen�tico a partir de un dominio dado.
	 * 
	 * @param dominio
	 *            Dominio del algoritmo gen�tico.
	 */
	@Override
	public void ejecutar(IDominio dominio) {
		// Obtenemos el fitness objetivo, la principal condici�n de parada del
		// algoritmo.
		double fitnessObjetivo = dominio.fitnessObjetivo();

		// Creamos la primera poblaci�n al azar.
		crearPoblacion();

		// Bucle principal del algoritmo gen�tico.
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
			// calcularFitnessDetallado muestra por pantalla los valores del polinomio
			// encontrado en los puntos de valores.txt
			dominio.calcularFitnessDetallado(individuos.get(0));

			System.out.println("�FIN DEL PROGRAMA!");
		}

	}

}
