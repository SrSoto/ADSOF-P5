package dominio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import individuos.IIndividuo;
import nodos.funciones.*;
import nodos.funciones.booleanas.*;
import nodos.terminales.*;

public class DominioBooleano extends Dominio {
	private HashMap<List<Boolean>, Boolean> valoresPrueba = new HashMap<List<Boolean>, Boolean>();

	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> retorno = new ArrayList<Terminal>();
		for (String terminal : terminales) {
			retorno.add(new TerminalBooleano(terminal));
		}
		return retorno;
	}

	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		List<Funcion> ret = new ArrayList<Funcion>();
		if (argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		for (int i = 0; i < funciones.length; i++) {
			switch (funciones[i]) {
			case " AND ": {
				ret.add(new FuncionAND(funciones[i], argumentos[i]));
			}
			case " OR ": {
				ret.add(new FuncionOR(funciones[i], argumentos[i]));
			}
			case " NAND ": {
				ret.add(new FuncionNAND(funciones[i], argumentos[i]));
			}
			case " NOR ": {
				ret.add(new FuncionNOR(funciones[i], argumentos[i]));
			}
			}
		}
		return ret;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		String linea;
		String[] token;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
		while ((linea = buffer.readLine()) != null) {
			token = linea.split("\t");

			valoresPrueba.put(Arrays.asList(Boolean.parseBoolean(token[0]), Boolean.parseBoolean(token[1]),
					Boolean.parseBoolean(token[2])), Boolean.parseBoolean(token[3]));
		}
		buffer.close();
	}

	@Override
	public double fitnessObjetivo() {
		return valoresPrueba.keySet().size();
	}

	@Override
	public double calcularFitness(IIndividuo individuo) {
		int fitness = 0;
		boolean valor;
		Set<List<Boolean>> valores = valoresPrueba.keySet();
		for (List<Boolean> l : valores) {
			TerminalBooleano.setValor("X", l.get(0));
			TerminalBooleano.setValor("Y", l.get(1));
			TerminalBooleano.setValor("Z", l.get(2));
			valor = individuo.calcularExpresionBooleana();
			if (valor == valoresPrueba.get(l)) {
				fitness++;
			}
			//System.out.println(	"Valor " + d + "<-> Rdo estimado: " + valor + " <-> Rdo real: " + this.valoresPrueba.get(d));
		}
		// System.out.println("Fitness en calcularFitness: " + fitness);
		individuo.setFitness(fitness);
		return fitness;
	}

	@Override
	public double calcularFitnessDebug(IIndividuo individuo) {
		int fitness = 0;
		boolean valor;
		Set<List<Boolean>> valores = valoresPrueba.keySet();
		for (List<Boolean> l : valores) {
			TerminalBooleano.setValor("X", l.get(0));
			TerminalBooleano.setValor("Y", l.get(1));
			TerminalBooleano.setValor("Z", l.get(2));
			valor = individuo.calcularExpresionBooleana();
			if (valor == valoresPrueba.get(l)) {
				fitness++;
			}
			System.out.println(	"Valor " + l + "<-> Rdo estimado: " + valor + " <-> Rdo real: " + this.valoresPrueba.get(l));
		}
		// System.out.println("Fitness en calcularFitness: " + fitness);
		individuo.setFitness(fitness);
		return fitness;
	}

}
