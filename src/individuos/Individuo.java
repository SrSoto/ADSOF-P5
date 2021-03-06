package individuos;

import java.util.*;

import cruces.IEtiquetable;
import nodos.INodo;
import nodos.funciones.Funcion;
import nodos.funciones.booleanas.FuncionBooleana;
import nodos.terminales.Terminal;

/**
 * Clase que implementa el individuo de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public class Individuo implements IIndividuo, Comparable<Individuo> {
	private static double minFitness;
	private INodo expresion;
	private double fitness;
	private int numeroNodos;

	/**
	 * Constructor est�ndar del individuo, reserva memoria para uno vac�o.
	 */
	public Individuo() {

	}

	/**
	 * Constructor sobrecargado del individuo.
	 * 
	 * @param expresion
	 *            Nodo que representa la ra�z del �rbol del individuo.
	 */
	public Individuo(INodo expresion) {
		this.expresion = expresion.copy();
		// Dado que empezamos etiquetando desde el cero, incrementamos en 1.
		numeroNodos = this.etiquetaNodos() + 1;
	}

	/**
	 * Constructor sobrecargado de individuo.
	 * 
	 * @param expresion
	 *            Nodo que representa la ra�z del arbol del individuo.
	 * @param fitness
	 *            Valor de fitness del individuo.
	 */
	public Individuo(INodo expresion, double fitness) {
		this.expresion = expresion.copy();
		numeroNodos = this.etiquetaNodos() + 1;
		this.fitness = fitness;
	}

	/**
	 * Establece el fitness m�nimo para premiar los individuos de menos nodos en
	 * caso de empate de fitness. Con ello se evita que individuos excesivamente
	 * peque�os se apoderen del algoritmo.
	 * 
	 * @param minFitness
	 *            Fitness m�nimo de empate para considerar en la comparaci�n el
	 *            numero de nodos del individuo
	 */
	public static void setMinFitness(int minFitness) {
		Individuo.minFitness = minFitness;
	}

	/**
	 * Devuelve un Nodo que representa la ra�z, es decir, el Nodo inicial del
	 * individuo. Denominaremos expresi�n a la representaci�n del individuo mediante
	 * nodos.
	 * 
	 * @return El nodo inicial del individuo.
	 */
	@Override
	public INodo getExpresion() {
		return expresion;
	}

	/**
	 * Setter del nodo inicial de un individuo, o nodo ra�z, para incializar un
	 * individuo.
	 * 
	 * @param expresion
	 *            El nodo inicial del individuo.
	 */
	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;

	}

	/**
	 * Devuelve el fitness del individuo, es decir, cuanto se acerca a resolver el
	 * problema.
	 * 
	 * @return Double con el grado de resolucion del problema.
	 */
	@Override
	public double getFitness() {
		return fitness;
	}

	/**
	 * Establece un valor optimo de resolucion del problema.
	 * 
	 * @param fitness
	 *            valor de resolucion del problema
	 */
	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

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
	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		Random rand = new Random();
		int funcionesSize = 0;
		if (profundidad <= 0 || terminales.isEmpty() || funciones.isEmpty()) {
			return;
		}
		funcionesSize = funciones.size();
		// El nodo ra�z es una funci�n aleatoria del dominio.
		this.expresion = funciones.get(rand.nextInt(funcionesSize)).copy();
		// Ahora el nodo crear� hijos aleatorios recursivamente hasta alcanzar la
		// profundidad deseada.
		((Funcion) this.expresion).arbolAleatorio(profundidad, terminales, funciones);
		this.etiquetar(0);
	}

	/**
	 * Realiza la operacion representada por la expresi�n.
	 * 
	 * @return double con el valor de la expresion.
	 */
	@Override
	public double calcularExpresion() {
		return this.expresion.calcular();
	}

	/**
	 * Calcula la expresi�n booleana del individuo. Se podr�a establecer una
	 * biyecci�n con el double (0, 1), pero debido a lo especificado sobre el
	 * fichero de valores en el enunciado, pensamos que era m�s correcto establecer
	 * dichos valores como booleanos.
	 */
	public boolean calcularExpresionBooleana() {
		return this.expresion.calcularBooleano();
	}

	/**
	 * Devuelve el numero de nodos totales del individuo.
	 * 
	 * @return El numero de nodos totales del individuo.
	 */
	@Override
	public int getNumeroNodos() {
		return numeroNodos;
	}

	/**
	 * Muestra la expresi�n que corresponde al individuo.
	 */
	@Override
	public void writeIndividuo() {
		System.out.println(this.expresion);
	}

	/**
	 * Devuelve la etiqueta de la clase.
	 * 
	 * @return int con la etiqueta del nodo ra�z.
	 */
	@Override
	public int getEtiqueta() {
		return expresion.getEtiqueta();
	}

	/**
	 * Setter de la etiqueta de la entidad.
	 * 
	 * @param e
	 *            entero para etiquetar.
	 */
	@Override
	public void setEtiqueta(int e) {
		expresion.setEtiqueta(e);
	}

	/**
	 * Etiqueta el �rbol del individuo.
	 * 
	 * @param etiqueta
	 *            Entero desde el que se comienza a etiquetar.
	 * @return int con la �ltima etiqueta establecida.
	 */
	@Override
	public int etiquetar(int etiqueta) {
		int retornoNNodos;
		retornoNNodos = expresion.etiquetar(0);
		numeroNodos = retornoNNodos;

		return retornoNNodos;
	}

	/**
	 * Etiqueta los nodos de la clase etiquetable.
	 * 
	 * @return int con la �ltima etiqueta establecida.
	 */
	@Override
	public int etiquetaNodos() {
		return etiquetar(0);
	}

	/**
	 * Devuelve la entidad cuya etiqueta coincide con la dada.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @return Objeto etiquetable cuya etiqueta coincide con la dada.
	 */
	@Override
	public IEtiquetable buscarPorEtiqueta(int etiqueta) {
		if (etiqueta < 0 || etiqueta >= numeroNodos) {
			System.out.println("Error buscando el nodo por etiqueta");
		}
		return (INodo) expresion.buscarPorEtiqueta(etiqueta);
	}

	/**
	 * Devuelve una copia del individuo.
	 * 
	 * @return Copia del individuo.
	 */
	public Individuo copy() {
		Individuo copia = new Individuo(this.expresion, fitness);
		return copia;
	}

	/**
	 * Sustituye el objeto cuya etiqueta es la dada por otro.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @param sustituto
	 *            objeto etiquetable que reemplazar� al encontrado.
	 */
	@Override
	public void reemplazar(int etiqueta, IEtiquetable sustituto) {
		if (etiqueta == 0) {
			this.expresion = ((INodo) sustituto).copy();
		} else {
			expresion.reemplazar(etiqueta, sustituto);
		}
		this.etiquetaNodos();
	}

	/**
	 * Compara dos individuos en funcion de su fitness y su numero de nodos.
	 * 
	 * @param individuo
	 *            el otro individuo con el que se compara.
	 */
	@Override
	public int compareTo(Individuo individuo) {
		if (this.fitness == individuo.fitness) {
			// Aqu� tiene lugar el parametro de fitness minimo:
			if (this.fitness > minFitness) {
				return this.getNumeroNodos() - individuo.getNumeroNodos();
			}
		}

		return ((int) (individuo.fitness - this.fitness));
	}
}
