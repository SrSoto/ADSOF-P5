/**
 * 
 */
package nodos;

import java.util.*;

import cruces.IEtiquetable;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

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
	 *            String que representa el s�mbolo del nodo.
	 */
	public Nodo(String raiz) {
		this.raiz = raiz;
	}

	/**
	 * Devuelve el simbolo que representa el nodo, es decir, el s�mbolo del Terminal
	 * o la Funci�n.
	 * 
	 * @return String el simbolo del nodo.
	 */
	@Override
	public String getRaiz() {
		return raiz;
	}

	/**
	 * Devuelve los argumentos, en el caso de las funciones. En el caso de los
	 * terminales, la lista de descendientes estar� vac�a.
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
	 * @return int con la �ltima etiqueta establecida.
	 */
	@Override
	public int etiquetar(int etiqueta) {
		setEtiqueta(etiqueta);
		etiqueta++;
		/*
		 * Con este bucle de llamadar recursivas conseguimos etiquetar en profundidad y
		 * de izquierda a derecha.
		 */
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
		if (etiqueta == this.etiqueta) {
			return this;
		}
		/*
		 * Atencion a la condicion de parada del bucle for, mediante la cual conseguimos
		 * que nuestra funci�n sirva para individuos de �rboles N-arios
		 */
		for (int i = 1; i < descendientes.size(); i++) {
			if (etiqueta < ((Nodo) descendientes.get(i)).etiqueta) {
				return descendientes.get(i - 1).buscarPorEtiqueta(etiqueta);
			}
		}
		return descendientes.get(descendientes.size() - 1).buscarPorEtiqueta(etiqueta);
	}

	/**
	 * Sustituye el nodo, cuya etiqueta es la dada, por otro.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @param sustituto
	 *            Nodo que reemplazar� al encontrado.
	 */
	@Override
	public void reemplazar(int etiqueta, IEtiquetable sustituto) {
		/*
		 * Cabe destacar del m�todo reemplazar que se trata de uno an�logo a
		 * buscarPorEtiqueta, pero como si fuera desde un nivel de punteros anterior,
		 * para poder llevar a cabo el swap.
		 */
		for (int i = 0; i < descendientes.size(); i++) {
			Nodo descendiente = (Nodo) descendientes.get(i);
			if (etiqueta == descendiente.etiqueta) {
				Nodo swap = (Nodo) ((Nodo) sustituto).copy();
				/*
				 * Por tener un arrayList conseguimos que el orden del �rbol se mantenga. De lo
				 * contrario, tendr�a malas consecuencias espejar un nodo en un punto de cruce
				 * que se tratara de una resta.
				 */
				this.getDescendientes().remove(i);
				this.getDescendientes().add(i, swap);
				return;
			}
			if (etiqueta < descendiente.etiqueta) {
				descendientes.get(i - 1).reemplazar(etiqueta, sustituto);
				return;
			}
		}
		int i = descendientes.size() - 1;
		Nodo descendiente = (Nodo) descendientes.get(i);
		if (etiqueta == descendiente.etiqueta) {
			Nodo swap = (Nodo) ((Nodo) sustituto).copy();
			this.getDescendientes().remove(i);
			this.getDescendientes().add(i, swap);
			return;
		}
		descendientes.get(descendientes.size() - 1).reemplazar(etiqueta, sustituto);
	}

}
