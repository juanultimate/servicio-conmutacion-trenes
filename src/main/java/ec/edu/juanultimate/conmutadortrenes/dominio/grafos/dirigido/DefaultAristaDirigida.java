package ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.DefaultArista;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultAristaDirigida<V extends Vertice> extends DefaultArista<V> implements AristaDirigida<V> {

    private final int ponderacion;

    public DefaultAristaDirigida(V verticeInicio, V verticeFin, int ponderacion) {
        super(verticeInicio, verticeFin);
        this.ponderacion = ponderacion;
    }

    public static <V extends Vertice, A extends AristaDirigida> A getNuevaAristaPonderada(final V startingVertex, final V endingVertex, final int weight) {
        return (A) new DefaultAristaDirigida<V>(startingVertex, endingVertex, weight);


    }

    @Override
    public int getPonderacion() {
        return ponderacion;
    }
}
