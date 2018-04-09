package individuos;

import java.util.*;

import cruces.IEtiquetable;
import nodos.INodo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

/**
 * Clase que implementa el individuo de nuestro algoritmo gen�tico.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public class Individuo implements IIndividuo {
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
		numeroNodos = this.etiquetaNodos() + 1;
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
		int terminalesSize = 0;
		if (profundidad <= 0 || terminales.isEmpty() || funciones.isEmpty()) {
			return;
		}
		funcionesSize = funciones.size();
		terminalesSize = terminales.size();
		this.expresion = funciones.get(rand.nextInt(funcionesSize));

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
		retornoNNodos = expresion.etiquetar(etiqueta);
		retornoNNodos++;
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
	 * @return Copia del individuo.
	 */
	public Individuo copy() {
		Individuo copia = new Individuo(this.expresion);
		copia.fitness = this.fitness;
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

}
