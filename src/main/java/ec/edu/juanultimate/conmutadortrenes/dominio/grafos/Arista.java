package ec.edu.juanultimate.conmutadortrenes.dominio.grafos;
public interface Arista<V extends Vertice> {
    V getVerticeInicio();
    V getVerticeFin();
}
