package cruces;

/**
 * Este programa contiene la implementacion de la excepcion de un cruce nulo,
 * que tiene lugar en el momento de querer hacer un cruce entre los nodos raíz
 * de ambos progenitores.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class CruceNuloException extends Exception {

	private static final long serialVersionUID = -2437659787600344638L;

	/**
	 * Convierte la excepcion en una String, informando acerca del problema causado.
	 */
	public String toString() {
		return "Se ha intentado hacer un cruce entre el nodo 0 de los dos progenitores.";
	}
}
