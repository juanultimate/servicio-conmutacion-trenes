package ec.edu.juanultimate.conmutadortrenes.filtros.composite;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

/**
 * This filter allows to combine two other filters and will return true only if
 * both filters return true and false in any other case. By using the
 * {@link } interface for the type of its parameters we can combine
 * simple and other composite filters indistinctively. This use of the Composite
 * pattern gives a great flexibility to create arbitrarily complex filters from
 * simple ones
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class AndPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final FiltroCamino<V,A> firstFilter;
    private final FiltroCamino<V,A> secondFilter;

    public AndPathFilter(final FiltroCamino<V,A> firstFilter, final FiltroCamino<V,A> secondFilter) {
        this.firstFilter = firstFilter;
        this.secondFilter = secondFilter;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return firstFilter.passFilter(path) && secondFilter.passFilter(path);
    }

}
