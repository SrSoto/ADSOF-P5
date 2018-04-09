package individuos;

import java.util.*;

import nodos.INodo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

public class Individuo implements IIndividuo {
	private INodo expresion;
	private double fitness;
	private int numeroNodos;
	
	public Individuo() {
		
	}

	public Individuo(INodo expresion) {
		this.expresion = expresion.copy();
		numeroNodos = this.etiquetaNodos() + 1;
	}

	@Override
	public INodo getExpresion() {
		return expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
		

	}

	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

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

	@Override
	public double calcularExpresion() {
		return this.expresion.calcular();
	}

	@Override
	public int getNumeroNodos() {
		return numeroNodos;
	}

	@Override
	public void writeIndividuo() {
		System.out.println(this.expresion);
	}

	@Override
	public int etiquetaNodos() {
		int retornoNNodos;
		retornoNNodos = expresion.etiquetar(0);
		retornoNNodos++;
		numeroNodos = retornoNNodos;

		return retornoNNodos;
	}

	public INodo buscarPorEtiqueta(int etiqueta) {
		if (etiqueta < 0 || etiqueta >= numeroNodos) {
			System.out.println("Error buscando el nodo por etiqueta");
		}
		return expresion.buscarPorEtiqueta(etiqueta);
	}

	public void remplazarNodo(int etiqueta, INodo sustituto) {
		expresion.reemplazarNodo(etiqueta, sustituto);
		this.etiquetaNodos();
	}

	public Individuo copy() {
		Individuo copia = new Individuo(this.expresion);
		copia.fitness = this.fitness;
		return copia;
	}

}
