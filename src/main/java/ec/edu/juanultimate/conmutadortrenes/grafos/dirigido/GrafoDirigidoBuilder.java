package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;

public class GrafoDirigidoBuilder {

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> getEmptyGraph() {
        return new DefaultGrafoDirigido<Ciudad,DefaultAristaDirigida>();
    }


}
