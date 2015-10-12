package ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public interface CaminoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Camino<V,A> {

    int getPathTotalWeight();
}
