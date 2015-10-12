package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;

/**
 * This filter will check to see if the given path has exactly the amount of
 * hops, i.e., edges, as the value specified on its constructor
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class ExactHopsPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int hopsNumber;

    public ExactHopsPathFilter(final int hopsNumber) {
        super();
        this.hopsNumber = hopsNumber;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return path.getNumeroSaltos() == hopsNumber;
    }

}
