package ec.edu.juanultimate.conmutadortrenes.dominio;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.DefaultGrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;

public class GraphBuilder {

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> getEmptyGraph() {
        return new DefaultGrafoDirigido<Ciudad,DefaultAristaDirigida>();
    }

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> getDefaultGraph() {
        final GrafoDirigido<Ciudad, DefaultAristaDirigida> routeGraph = new DefaultGrafoDirigido<Ciudad, DefaultAristaDirigida>();
        final Ciudad nodeA = new Ciudad("A");
        final Ciudad nodeB = new Ciudad("B");
        final Ciudad nodeC = new Ciudad("C");
        final Ciudad nodeD = new Ciudad("D");
        final Ciudad nodeE = new Ciudad("E");

        routeGraph.agregarVertice(nodeA);
        routeGraph.agregarVertice(nodeB);
        routeGraph.agregarVertice(nodeC);
        routeGraph.agregarVertice(nodeD);
        routeGraph.agregarVertice(nodeE);

        routeGraph.agregarArista(nodeA, nodeB, 5);
        routeGraph.agregarArista(nodeB, nodeC, 4);
        routeGraph.agregarArista(nodeC, nodeD, 8);
        routeGraph.agregarArista(nodeD, nodeC, 8);
        routeGraph.agregarArista(nodeD, nodeE, 6);
        routeGraph.agregarArista(nodeA, nodeD, 5);
        routeGraph.agregarArista(nodeC, nodeE, 2);
        routeGraph.agregarArista(nodeE, nodeB, 3);
        routeGraph.agregarArista(nodeA, nodeE, 7);
        return routeGraph;
    }
}
