package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;

/**
 * This filter will check to see if the total weight of the given path is less
 * than the value specified on the constructor
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class WeightPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maxWeight;

    public WeightPathFilter(final int maxWeight) {
        super();
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return ((CaminoDirigido)path).getPathTotalWeight() < maxWeight;
    }

}
