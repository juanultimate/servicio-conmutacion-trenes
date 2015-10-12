package ec.edu.juanultimate.conmutadortrenes.dominio.grafos;

import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.List;
import java.util.Set;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public interface Grafo<V extends Vertice, A extends Arista> {
    boolean agregarArista(V inicio, V fin);
    boolean agregarVertice(V vertice);
    A getArista(V inicio, V fin);
    Set<V> getTodosVertices();



}
