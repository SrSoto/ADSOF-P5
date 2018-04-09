/**
 * 
 */
package nodos;

import java.util.*;

import cruces.IEtiquetable;

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

	/**
	 * Constructor de un nodo cualquiera.
	 * 
	 * @param raiz
	 *            String que representa el símbolo del nodo.
	 */
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

	/**
	 * Devuelve la etiqueta del nodo.
	 * 
	 * @return int con la etiqueta.
	 */
	@Override
	public int getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Setter de la etiqueta del nodo.
	 * 
	 * @param e
	 *            entero para etiquetar.
	 */
	@Override
	public void setEtiqueta(int e) {
		etiqueta = e;
	}

	/**
	 * Etiqueta recursivamente el nodo y sus descendientes.
	 * 
	 * @param etiqueta
	 *            Entero desde el que se comienza a etiquetar.
	 * @return int con la última etiqueta establecida.
	 */
	@Override
	public int etiquetar(int etiqueta) {
		setEtiqueta(etiqueta);
		etiqueta++;
		for (INodo nodo : descendientes) {
			etiqueta = nodo.etiquetar(etiqueta);
		}
		return etiqueta;
	}

	/**
	 * Devuelve el nodo cuya etiqueta coincide con la dada, buscando recursivamente
	 * en los descendientes.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @return Objeto etiquetable cuya etiqueta coincide con la dada.
	 */
	@Override
	public IEtiquetable buscarPorEtiqueta(int etiqueta) {
		System.out.println(etiqueta + " == " + this.etiqueta + "?");
		if (etiqueta == this.etiqueta) {
			System.out.println("Encontrado! " + this);
			return this;
		}
		for (int i = 1; i < descendientes.size(); i++) {
			System.out.println("Etiqueta del posible nodo " + descendientes.get(i) + ": "
					+ ((Nodo) descendientes.get(i)).etiqueta);
			if (etiqueta < ((Nodo) descendientes.get(i)).etiqueta) {
				System.out.println("Buscaremos en el nodo: " + descendientes.get(i - 1));
				return descendientes.get(i - 1).buscarPorEtiqueta(etiqueta);
			}
		}
		System.out.println("Buscaremos en el nodo: " + descendientes.get(descendientes.size() - 1));
		return descendientes.get(descendientes.size() - 1).buscarPorEtiqueta(etiqueta);
	}

	/**
	 * Sustituye el nodo, cuya etiqueta es la dada, por otro.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @param sustituto
	 *            Nodo que reemplazará al encontrado.
	 */
	@Override
	public void reemplazar(int etiqueta, IEtiquetable sustituto) {
		for (int i = 0; i < descendientes.size(); i++) {
			// System.out.println("Etiqueta del posible nodo " + descendientes.get(i) + ": "
			// + ((Nodo)descendientes.get(i)).etiqueta);
			Nodo descendiente = (Nodo) descendientes.get(i);
			System.out.println(etiqueta + " == " + descendiente.etiqueta + "?");
			if (etiqueta == descendiente.etiqueta) {
				Nodo swap = (Nodo) ((Nodo) sustituto).copy();
				System.out.println("Encontrado! " + this + " <--> " + swap);
				this.getDescendientes().remove(i);
				this.getDescendientes().add(i, swap);
				return;
			}
			if (etiqueta < descendiente.etiqueta) {
				// System.out.println("Buscaremos en el nodo: " + descendientes.get(i - 1));
				descendientes.get(i - 1).reemplazar(etiqueta, sustituto);
				return;
			}
		}
		int i = descendientes.size() - 1;
		Nodo descendiente = (Nodo) descendientes.get(i);
		System.out.println(etiqueta + " == " + descendiente.etiqueta + "?");
		if (etiqueta == descendiente.etiqueta) {
			Nodo swap = (Nodo) ((Nodo) sustituto).copy();
			System.out.println("Encontrado! " + this + " <--> " + swap);
			this.getDescendientes().remove(i);
			this.getDescendientes().add(i, swap);
			return;
		}
		descendientes.get(descendientes.size() - 1).reemplazar(etiqueta, sustituto);
	}

}
