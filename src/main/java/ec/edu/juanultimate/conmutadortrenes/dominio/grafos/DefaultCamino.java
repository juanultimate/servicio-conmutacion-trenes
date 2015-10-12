package ec.edu.juanultimate.conmutadortrenes.dominio.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultCamino<V extends Vertice, A extends Arista> implements Camino<V,A> {

    protected final List<A> edgeList = new ArrayList<A>();
    protected DefaultCamino() {
    }

    protected DefaultCamino(final Camino<V,A> otherPath) {
        edgeList.addAll(otherPath.getListaAristas());

    }


    @Override
    public void agregarArista(A arista) {
        if (!edgeIsConsecutive(arista)) {
            throw new IllegalArgumentException("The edge " + arista + " is not consecutive to the existing path");
        }
        edgeList.add(arista);
        //totalWeight += arista.getWeight();
    }

    protected boolean edgeIsConsecutive(final Arista<V> edge) {
        final V lastNode = getVerticeFin();
        if (lastNode != null && !lastNode.equals(edge.getVerticeInicio())) {
            return false;
        }
        return true;
    }

    @Override
    public void removerUltimaArista() {
        if (!edgeList.isEmpty()) {
            final Arista<V> lastEdge = edgeList.get(edgeList.size() - 1);
            //this.totalWeight -= lastEdge.getWeight();
            edgeList.remove(edgeList.size() - 1);
        }
    }

    @Override
    public List<A> getListaAristas() {
        return Collections.unmodifiableList(edgeList);
    }



    @Override
    public int getNumeroSaltos() {
        return edgeList.size();
    }

    @Override
    public V getVerticeFin() {
        V node = null;
        if (!edgeList.isEmpty()) {
            node = (V) edgeList.get(edgeList.size() - 1).getVerticeFin();
        }
        return node;
    }

    @Override
    public boolean tieneAristasRepetidas() {
        for (int i = 0; i < edgeList.size(); i++) {
            for (int j = i + 1; j < edgeList.size(); j++) {
                if (edgeList.get(i).equals(edgeList.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean comienzaCon(Camino<V, A> otherPath) {
        final List<A> partialPath = otherPath.getListaAristas();
        final List<A> completePath = getListaAristas();
        for (int i = 0; i < partialPath.size(); i++) {
            if (i >= completePath.size() || !partialPath.get(i).equals(completePath.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Camino<V, A> otherPath) {
            return this.getNumeroSaltos() - otherPath.getNumeroSaltos();
    }
}
