package nodos.terminales;

import java.util.*;

import nodos.INodo;

public class TerminalBooleano extends Terminal {

	private static TreeMap<String, Boolean> valores = new TreeMap<String, Boolean>();

	public TerminalBooleano(String simbolo) {
		super(simbolo);
		if (!(valores.containsKey(simbolo))) {
			valores.put(simbolo, null);
		}
	}
	
	public static void setValor(String simbolo, boolean v) {
		valores.replace(simbolo, new Boolean(v));
	}
	
	public static boolean getValor(String simbolo) {
		return valores.get(simbolo).booleanValue();
	}

	public boolean calcularBooleano() {
		return getValor(getRaiz());
	}

	@Override
	public INodo copy() {
		TerminalBooleano copy = new TerminalBooleano(new String(this.getRaiz()));
		return copy;
	}

	@Override
	public double calcular() {
		return 0;
	}

}
