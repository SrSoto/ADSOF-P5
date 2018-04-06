/**
 * 
 */
package p4clases;

import java.util.*;

/**
 * @author manue
 *
 */
public abstract class Nodo implements INodo{

	private final String simbolo;
	private List<INodo> descendientes = new ArrayList<INodo>();
	
	
	public Nodo(String simbolo) {
		this.simbolo = simbolo;
	}
	

}
