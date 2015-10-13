package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.CaminoDirigido;


public class FiltroCaminoConAristasRepetidas<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> camino) {
        return !camino.tieneAristasRepetidas();
    }

}
