package ec.edu.juanultimate.conmutadortrenes.dominio.grafos;

import java.util.List;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
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
