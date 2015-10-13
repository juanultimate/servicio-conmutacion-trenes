package ec.edu.juanultimate.conmutadortrenes.grafos;

import java.util.List;


public interface Camino<V extends Vertice, A extends Arista> extends Comparable<Camino<V,A>>{
    void agregarArista(A arista);
    void removerUltimaArista();
    List<A> getListaAristas();
    //int getCosteCamino();
    int getNumeroSaltos();
    V getVerticeFin();
    boolean tieneAristasRepetidas();
    boolean comienzaCon(Camino<V, A> otherPath);
}
