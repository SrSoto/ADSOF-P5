import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmogenetico.AlgoritmoGenetico;
import dominio.*;
import individuos.Individuo;

public class AlgoritmoGeneticoBooleano {
	public static void main(String[] args) throws ArgsDistintosFuncionesException, FileNotFoundException, IOException {
		Dominio dominio = new DominioBooleano();
		int[] argumentos = { 2, 2, 2, 2 };
		String[] funciones = new String[] { " AND ", " OR ", " NAND ", " NOR " };
		dominio.definirValoresPrueba("valoresBooleanos.txt");
		AlgoritmoGenetico booleanos = new AlgoritmoGenetico(50,5000,3,10,6);
		booleanos.defineConjuntoTerminales(dominio.definirConjuntoTerminales("X","Y","Z"));
		booleanos.defineConjuntoFunciones(dominio.definirConjuntoFunciones(argumentos, funciones));
		Individuo.setMinFitness(5);
		booleanos.ejecutar(dominio);
	}
}
