package individuos;

import java.util.Comparator;

/**
 * Clase que implementa el comparador entre individuos, usado para obtener la
 * élite de cada generación.
 * 
 * @author Manuel Soto manuel.sotoj@estudiante.uam.es Miguel Baquedano
 *         miguel.baquedano@estudiante.uam.es
 */
public class IndividuoSorter implements Comparator<IIndividuo> {

	/**
	 * Compara dos individuos.
	 * 
	 * @param o1
	 *            individuo 1 a comparar.
	 * @param o2
	 *            individuo 2 a comparar.
	 * @return entero con -1 si o1<o2, 0 si o1=02, 1 si o1>o2
	 */
	@Override
	public int compare(IIndividuo o1, IIndividuo o2) {
		int diff = ((Individuo) o1).compareTo((Individuo) o2);
		if (diff < 0) {
			return -1;
		}
		if (diff > 0) {
			return 1;
		}
		return 0;
	}

}
