package ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.DefaultCamino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.List;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultCaminoDirigido<V extends Vertice, A extends Arista & AristaDirigida> extends DefaultCamino<V,A> implements CaminoDirigido<V,A> {

    private int totalWeight = 0;
    private DefaultCaminoDirigido() {
        super();
    }

    public static <V extends Vertice,A extends Arista & AristaDirigida> CaminoDirigido<V,A> emptyPath() {
        return new DefaultCaminoDirigido<V,A>();
    }
    public static <V extends Vertice,A extends Arista & AristaDirigida> CaminoDirigido<V,A> copyPath(final CaminoDirigido<V,A> otherPath) {
        return new DefaultCaminoDirigido<V,A>(otherPath);
    }
    private DefaultCaminoDirigido(final CaminoDirigido<V,A> otherPath) {
        super(otherPath);
        this.totalWeight = otherPath.getPathTotalWeight();

    }

    @Override
    public void agregarArista(A arista) {
       super.agregarArista(arista);
        totalWeight += ((AristaDirigida)arista).getPonderacion();
    }

    @Override
    public void removerUltimaArista() {
        if (!edgeList.isEmpty()) {
            final Arista<V> lastEdge = edgeList.get(edgeList.size() - 1);
            this.totalWeight -= ((AristaDirigida)lastEdge).getPonderacion();
            edgeList.remove(edgeList.size() - 1);
        }
    }
    @Override
    public int compareTo(Camino<V, A> otherPath) {
        return this.getPathTotalWeight() - ((CaminoDirigido)otherPath).getPathTotalWeight();
    }

    @Override
    public int getPathTotalWeight() {
        return totalWeight;
    }


}
