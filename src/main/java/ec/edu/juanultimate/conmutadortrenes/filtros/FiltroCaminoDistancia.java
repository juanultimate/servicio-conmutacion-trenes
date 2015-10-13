package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.CaminoDirigido;

public class FiltroCaminoDistancia<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maximaDistancia;

    public FiltroCaminoDistancia(final int maximaDistancia) {
        this.maximaDistancia = maximaDistancia;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> camino) {
        return ((CaminoDirigido)camino).getCosteTotalCamino() < maximaDistancia;
    }

}
