/**
 * 
 */
package nodos;

import java.util.*;

/**
 * Clase que implementa el nodo para los arboles de la representacion de un
 * individuo de nuestro algoritmo genetico
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public abstract class Nodo implements INodo {

	private String raiz;
	private int etiqueta;
	private List<INodo> descendientes = new ArrayList<INodo>();

	public Nodo(String raiz) {
		this.raiz = raiz;
	}

	/**
	 * Devuelve el simbolo que representa el nodo, es decir, el símbolo del Terminal
	 * o la Función.
	 * 
	 * @return String el simbolo del nodo.
	 */
	@Override
	public String getRaiz() {
		return raiz;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(int e) {
		etiqueta = e;
	}

	/**
	 * Devuelve los argumentos, en el caso de las funciones. En el caso de los
	 * terminales, la lista de descendientes estará vacía.
	 * 
	 * @return Lista con los descendientes del nodo.
	 */
	@Override
	public List<INodo> getDescendientes() {
		return descendientes;
	}

	public int etiquetar(int etiqueta) {
		setEtiqueta(etiqueta);
		etiqueta++;
		for (INodo nodo : descendientes) {
			etiqueta = nodo.etiquetar(etiqueta);
		}
		return etiqueta;
	}

	@Override
	public INodo buscarPorEtiqueta(int etiqueta) {
		System.out.println(etiqueta + " == " + this.etiqueta + "?");
		if (etiqueta == this.etiqueta) {
			System.out.println("Encontrado! " + this);
			return this;
		}
		for (int i = 1; i < descendientes.size(); i++) {
			System.out.println("Etiqueta del posible nodo " + descendientes.get(i) + ": " + ((Nodo)descendientes.get(i)).etiqueta);
			if (etiqueta < ((Nodo) descendientes.get(i)).etiqueta) {
				System.out.println("Buscaremos en el nodo: " + descendientes.get(i - 1));
				return descendientes.get(i - 1).buscarPorEtiqueta(etiqueta);
			}
		}
		System.out.println("Buscaremos en el nodo: " + descendientes.get(descendientes.size() - 1));
		return descendientes.get(descendientes.size() - 1).buscarPorEtiqueta(etiqueta);
	}

	@Override
	public void reemplazarNodo(int etiqueta, INodo sustituto) {
		System.out.println(etiqueta + " == " + this.etiqueta + "?");
		if (etiqueta == this.etiqueta) {
			Nodo swap = (Nodo) sustituto.copy();
			System.out.println("Encontrado! " + this + " <--> " + swap);
			this.descendientes = swap.getDescendientes();
			this.raiz = swap.raiz;
			return;
		}
		for (int i = 1; i < descendientes.size(); i++) {
			System.out.println("Etiqueta del posible nodo " + descendientes.get(i) + ": " + ((Nodo)descendientes.get(i)).etiqueta);
			if (etiqueta < ((Nodo) descendientes.get(i)).etiqueta) {
				System.out.println("Buscaremos en el nodo: " + descendientes.get(i - 1));
				descendientes.get(i - 1).reemplazarNodo(etiqueta, sustituto);
				return;
			}
		}
		System.out.println("Buscaremos en el nodo: " + descendientes.get(descendientes.size() - 1));
		descendientes.get(descendientes.size() - 1).reemplazarNodo(etiqueta, sustituto);
	}

}
