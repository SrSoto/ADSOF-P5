package algoritmogenetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cruces.CruceNuloException;
import dominio.ArgsDistintosFuncionesException;
import dominio.IDominio;
import individuos.IIndividuo;
import individuos.Individuo;
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
public class AlgoritmoGenetico implements IAlgoritmo{
	
	public static void main(String[] args) {
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * Crea la primera población del algoritmo.
	 */
	@Override
	public void crearPoblacion() {
		// TODO Auto-generated method stub
		
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

		int etiqueta1 = rand.nextInt(prog1.getNumeroNodos()-1);
		int etiqueta2 = rand.nextInt(prog2.getNumeroNodos()-1);
		
		if(etiqueta1 + etiqueta2 == 0) {
			throw new CruceNuloException();
		}

		System.out.println("Punto de cruce del progenitor 1: " + etiqueta1);
		System.out.println("Punto de cruce del progenitor 2: " + etiqueta2);

		Nodo nodo1 = (Nodo) ((Individuo) prog1).buscarPorEtiqueta(etiqueta1);
		Nodo nodo2 = (Nodo) ((Individuo) prog2).buscarPorEtiqueta(etiqueta2);
		Individuo copia1 = ((Individuo) prog1).copy();
		Individuo copia2 = ((Individuo) prog2).copy();

		copia1.reemplazar(etiqueta1, nodo2);
		copia2.reemplazar(etiqueta2, nodo1);

		System.out.println("\nDESCENDIENTE 1 (Prueba Cruce)");
		copia1.writeIndividuo();
		System.out.println("DESCENDIENTE 2 (Prueba Cruce)");
		copia2.writeIndividuo();
		
		retorno.add(copia1);
		retorno.add(copia2);

		return retorno;
	}

	/**
	 * Crea una nueva población a partir de la anterior.
	 */
	@Override
	public void crearNuevaPoblacion() {
		 // TODO Auto-generated method stub
		
	}

	/**
	 * Ejecuta el algoritmo genético a partir de un dominio dado.
	 * @param dominio Dominio del algoritmo genético.
	 */
	@Override
	public void ejecutar(IDominio dominio) {
		// TODO Auto-generated method stub
		
	}

}
