package ec.edu.juanultimate.conmutadortrenes.grafos;

import java.util.Set;


public interface Grafo<V extends Vertice, A extends Arista> {
    boolean agregarArista(V inicio, V fin);
    boolean agregarVertice(V vertice);
    A getArista(V inicio, V fin);
    Set<V> getTodosVertices();



}
