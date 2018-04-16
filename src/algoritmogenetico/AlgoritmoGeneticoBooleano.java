package algoritmogenetico;

import java.io.FileNotFoundException;
import java.io.IOException;

import dominio.*;
import individuos.Individuo;

/**
 * Este programa contiene la ejecución de un algoritmo genético para hallar una
 * función de paridad booleana, del apartado opcional de nuestra práctica.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class AlgoritmoGeneticoBooleano {
	public static void main(String[] args) throws ArgsDistintosFuncionesException, FileNotFoundException, IOException {
		DominioBooleano dominio = new DominioBooleano();
		int[] argumentos = { 2, 2, 2, 2 };
		String[] funciones = new String[] { " AND ", " OR ", " NAND ", " NOR " };
		dominio.definirValoresPrueba("valoresBooleanos.txt");
		AlgoritmoGenetico booleanos = new AlgoritmoGenetico(50, 5000, 3, 10, 6);
		booleanos.defineConjuntoTerminales(dominio.definirConjuntoTerminales("X", "Y", "Z"));
		booleanos.defineConjuntoFunciones(dominio.definirConjuntoFunciones(argumentos, funciones));
		Individuo.setMinFitness(5);
		booleanos.ejecutar(dominio);
	}
}
