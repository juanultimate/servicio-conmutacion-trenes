package ec.edu.juanultimate.conmutadortrenes.filtros;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.AristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.CaminoDirigido;


public class ContainsPathFilter<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final CaminoDirigido<V,A> objectivePath;

    public ContainsPathFilter(final CaminoDirigido<V,A> objectivePath) {
        this.objectivePath = objectivePath;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return objectivePath.comienzaCon(path);
    }

}
