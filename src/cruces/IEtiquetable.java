package cruces;

/**
 * Interfaz de metodos para etiquetar clases. En nuestro caso, usada para
 * etiquetar nodos e individuos.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 *
 */
public interface IEtiquetable {

	/**
	 * Etiqueta la entidad.
	 * 
	 * @param etiqueta
	 *            Entero desde el que se comienza a etiquetar.
	 * @return int con la última etiqueta establecida.
	 */
	public int etiquetar(int etiqueta);

	/**
	 * Devuelve la etiqueta de la clase.
	 * 
	 * @return int con la etiqueta.
	 */
	public int getEtiqueta();

	/**
	 * Setter de la etiqueta de la entidad.
	 * 
	 * @param e
	 *            entero para etiquetar.
	 */
	public void setEtiqueta(int e);

	/**
	 * Devuelve la entidad cuya etiqueta coincide con la dada.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @return Objeto etiquetable cuya etiqueta coincide con la dada.
	 */
	public IEtiquetable buscarPorEtiqueta(int etiqueta);

	/**
	 * Sustituye el objeto, cuya etiqueta es la dada, por otro.
	 * 
	 * @param etiqueta
	 *            entero con la etiqueta a buscar.
	 * @param sustituto
	 *            objeto etiquetable que reemplazará al encontrado.
	 */
	public void reemplazar(int etiqueta, IEtiquetable sustituto);
}
