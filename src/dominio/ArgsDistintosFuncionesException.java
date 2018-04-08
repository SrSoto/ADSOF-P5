package dominio;

/**
 * Este programa contiene la implementacion de la excepcion de argumento
 * distintos para la obtencion de las funciones del dominio. Dicha excepcion se
 * crea si tenemos un n�mero distinto de n�mero de argumentos de cada funci�n
 * frente al n�mero de s�mbolos dados.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public class ArgsDistintosFuncionesException extends Exception {
	private static final long serialVersionUID = -8743806371837311334L;

	/**
	 * Convierte la excepcion en una String, informando acerca del problema causado.
	 */
	public String toString() {
		return "El numero de argumentos por funci�n y de s�mbolos dado no coinciden.";
	}
}
