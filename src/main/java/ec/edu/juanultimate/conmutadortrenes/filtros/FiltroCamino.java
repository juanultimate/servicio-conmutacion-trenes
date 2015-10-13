package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.CaminoDirigido;


public interface FiltroCamino<V extends Vertice, A extends Arista & AristaDirigida> {
    boolean passFilter(final CaminoDirigido<V,A> camino);
}
