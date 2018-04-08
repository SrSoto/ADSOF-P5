package p4clases;

import java.util.List;

public class Individuo implements IIndividuo {
	private INodo expresion;
	private double fitness;
	private int numeroNodos;
	

	@Override
	public INodo getExpresion() {
		return expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion=expresion;

	}

	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness=fitness;

	}

	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub

	}

	@Override
	public double calcularExpresion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroNodos() {
		return numeroNodos;
	}

	@Override
	public void writeIndividuo() {
		// TODO Auto-generated method stub

	}

}
