package ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Grafo;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.List;
import java.util.Set;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public interface GrafoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Grafo<V,A> {


    public boolean agregarArista(final V from, final V to, final int weight);
    List<CaminoDirigido<V,A>> getCaminosFiltrados(V inicio, V fin, FiltroCamino<V,A> criterioFiltro);



}
