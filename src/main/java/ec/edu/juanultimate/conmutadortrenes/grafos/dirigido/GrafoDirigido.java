package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Grafo;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.List;


public interface GrafoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Grafo<V,A> {


    boolean agregarArista(final V inicio, final V fin, final int ponderacion);
    List<CaminoDirigido<V,A>> getCaminosFiltrados(V inicio, V fin, FiltroCamino<V,A> criterioFiltro);



}
