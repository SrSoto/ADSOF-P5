package algoritmogenetico;

import java.util.List;

import cruces.CruceNuloException;
import dominio.ArgsDistintosFuncionesException;
import dominio.IDominio;
import individuos.IIndividuo;
import nodos.funciones.Funcion;
import nodos.terminales.Terminal;

public interface IAlgoritmo {
	public void defineConjuntoTerminales(List<Terminal> terminales);

	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	public void crearPoblacion();

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	public void crearNuevaPoblacion();

	public void ejecutar(IDominio dominio);
}
