package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;

/**
 * This filter will check to see if the number of hops or edges on the given
 * path is less than or equal to the value specified on the constructor
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class MaxHopsPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maxHops;

    public MaxHopsPathFilter(final int maxHops) {
        super();
        this.maxHops = maxHops;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return path.getNumeroSaltos() <= maxHops;
    }

}
