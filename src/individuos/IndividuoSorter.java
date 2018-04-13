package individuos;

import java.util.Comparator;

public class IndividuoSorter implements Comparator<IIndividuo>{

	
	
	@Override
	public int compare(IIndividuo o1, IIndividuo o2) {
		int diff = ((Individuo) o1).compareTo((Individuo) o2);
		if(diff<0) {
			return 1;
		}
		if(diff>0) {
			return -1;
		}
		return 0;
	}

}
