package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;


public interface CaminoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Camino<V,A> {
    int getCosteTotalCamino();
}
