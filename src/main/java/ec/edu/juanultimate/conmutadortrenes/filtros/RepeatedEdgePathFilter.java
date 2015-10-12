package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;

/**
 * This filter will return true if and only if the given path contains no
 * repeated edges.
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 * @param <V>
 *            The type of the nodes in the path
 */
public class RepeatedEdgePathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return !path.tieneAristasRepetidas();
    }

}
