package ec.edu.juanultimate.conmutadortrenes.filtros.composite;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

/**
 * This filter allows to negate the result of other {@link FiltroCamino}. Using
 * this composite filter we can easily reverse the effect of any given filter
 * without the need to create new ones.
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class NotPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final FiltroCamino<V,A> originalFilter;

    public NotPathFilter(final FiltroCamino<V,A> originalFilter) {
        super();
        this.originalFilter = originalFilter;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return !originalFilter.passFilter(path);
    }

}
