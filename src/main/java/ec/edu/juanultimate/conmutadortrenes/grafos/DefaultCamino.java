package ec.edu.juanultimate.conmutadortrenes.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DefaultCamino<V extends Vertice, A extends Arista> implements Camino<V,A> {

    protected final List<A> listAristas = new ArrayList<A>();
    protected DefaultCamino() {}

    protected DefaultCamino(final Camino<V,A> otroCamino) {
        listAristas.addAll(otroCamino.getListaAristas());
    }

    @Override
    public void agregarArista(A arista) {
        if (!esAristaConsecutiva(arista)) {
            throw new IllegalArgumentException("La arista " + arista + " no se conecta con el actual camino");
        }
        listAristas.add(arista);
    }

    private boolean esAristaConsecutiva(final Arista<V> arista) {
        final V verticeFin = getVerticeFin();
        if (verticeFin != null && !verticeFin.equals(arista.getVerticeInicio())) {
            return false;
        }
        return true;
    }

    @Override
    public void removerUltimaArista() {
        if (!listAristas.isEmpty()) {
            final Arista<V> ultimaArista = listAristas.get(listAristas.size() - 1);
            listAristas.remove(listAristas.size() - 1);
        }
    }

    @Override
    public List<A> getListaAristas() {
        return Collections.unmodifiableList(listAristas);
    }



    @Override
    public int getNumeroSaltos() {
        return listAristas.size();
    }

    @Override
    public V getVerticeFin() {
        V verticeFin = null;
        if (!listAristas.isEmpty()) {
            verticeFin = (V) listAristas.get(listAristas.size() - 1).getVerticeFin();
        }
        return verticeFin;
    }

    @Override
    public boolean tieneAristasRepetidas() {
        for (int i = 0; i < listAristas.size(); i++) {
            for (int j = i + 1; j < listAristas.size(); j++) {
                if (listAristas.get(i).equals(listAristas.get(j))) {
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
    public int compareTo(Camino<V, A> otro) {
        return this.getNumeroSaltos() - otro.getNumeroSaltos();

    }
}
