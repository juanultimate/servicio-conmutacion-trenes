package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.CaminoDirigido;


public class FiltroMaximoParadas<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maximoParadas;

    public FiltroMaximoParadas(final int maximoParadas) {
        this.maximoParadas = maximoParadas;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return path.getNumeroSaltos() <= maximoParadas;
    }

}
