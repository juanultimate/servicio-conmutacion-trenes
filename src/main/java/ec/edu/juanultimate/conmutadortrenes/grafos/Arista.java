package ec.edu.juanultimate.conmutadortrenes.grafos;

public interface Arista<V extends Vertice> {
    V getVerticeInicio();
    V getVerticeFin();
}
