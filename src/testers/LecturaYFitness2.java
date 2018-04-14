package testers;


import java.io.*;

import dominio.DominioAritmetico;
import dominio.IDominio;
import individuos.*;
import nodos.funciones.*;
import nodos.terminales.*;

/**
 * Clase que prueba el correcto funcionamiento de calcular el fitness de los
 * individuos, usado para el algoritmo genético.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public class LecturaYFitness2 {

	public static void main(String[] args) throws IOException, IOException {
		IDominio domAritm;
		double fitness;

		domAritm = new DominioAritmetico();
		domAritm.definirValoresPrueba("valores.txt");
		Terminal x = new TerminalAritmetico("x");
		Funcion suma = new FuncionSuma("+", 2);
		Funcion multi1 = new FuncionMultiplicacion("*", 2);
		Funcion multi2 = new FuncionMultiplicacion("*", 2);
		Funcion multi3 = new FuncionMultiplicacion("*", 2);
		Funcion multi4 = new FuncionMultiplicacion("*", 2);
		Funcion multi5 = new FuncionMultiplicacion("*", 2);
		
		multi1.incluirDescendiente(x);
		multi1.incluirDescendiente(x);
		multi2.incluirDescendiente(multi1);
		multi2.incluirDescendiente(x);
		multi3.incluirDescendiente(multi2);
		multi3.incluirDescendiente(x);
		multi4.incluirDescendiente(multi3);
		multi4.incluirDescendiente(x);
		multi5.incluirDescendiente(multi4);
		multi5.incluirDescendiente(x);
		suma.incluirDescendiente(multi5);
		suma.incluirDescendiente(x);

		IIndividuo indiv = new Individuo();
		indiv.setExpresion(suma);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv.writeIndividuo();
		System.out.println();
		fitness = domAritm.calcularFitness(indiv);
		System.out.println("\nFITNESS= " + fitness);
	}

}
