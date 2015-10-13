package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.grafos.Arista;
import ec.edu.juanultimate.conmutadortrenes.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.grafos.DefaultCamino;
import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;


public class DefaultCaminoDirigido<V extends Vertice, A extends Arista & AristaDirigida> extends DefaultCamino<V,A> implements CaminoDirigido<V,A> {

    private int costeTotalCamino = 0;
    protected DefaultCaminoDirigido() {
        super();
    }

    public static <V extends Vertice,A extends Arista & AristaDirigida> CaminoDirigido<V,A> getCaminoVacio() {
        return new DefaultCaminoDirigido<V,A>();
    }
    public static <V extends Vertice,A extends Arista & AristaDirigida> CaminoDirigido<V,A> copiarCamino(final CaminoDirigido<V, A> camino) {
        return new DefaultCaminoDirigido<V,A>(camino);
    }
    private DefaultCaminoDirigido(final CaminoDirigido<V,A> camino) {
        super(camino);
        this.costeTotalCamino = camino.getCosteTotalCamino();

    }

    @Override
    public void agregarArista(A arista) {
       super.agregarArista(arista);
        costeTotalCamino += arista.getPonderacion();
    }

    @Override
    public void removerUltimaArista() {
        if (!listAristas.isEmpty()) {
            final A ultimaArista = listAristas.get(listAristas.size() - 1);
            this.costeTotalCamino -= ultimaArista.getPonderacion();
            listAristas.remove(listAristas.size() - 1);
        }
    }
    @Override
    public int compareTo(Camino<V, A> otro) {
        return this.getCosteTotalCamino() - ((CaminoDirigido)otro).getCosteTotalCamino();
    }

    @Override
    public int getCosteTotalCamino() {
        return costeTotalCamino;
    }


}
