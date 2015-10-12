package ec.edu.juanultimate.conmutadortrenes.filtros.composite;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

/**
 * This filter allows to combine two other filters and will return false only if
 * both filters return false and true in any other case. By using the
 * {@link PathFilter} interface for the type of its parameters we can combine
 * simple and other composite filters indistinctively. This use of the Composite
 * pattern gives a great flexibility to create arbitrarily complex filters from
 * simple ones
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class OrPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final FiltroCamino<V,A> firstFilter;
    private final FiltroCamino<V,A> secondFilter;

    public OrPathFilter(final FiltroCamino<V,A> firstFilter, final FiltroCamino<V,A> secondFilter) {
        super();
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return firstFilter.passFilter(path) || secondFilter.passFilter(path);
    }

}
