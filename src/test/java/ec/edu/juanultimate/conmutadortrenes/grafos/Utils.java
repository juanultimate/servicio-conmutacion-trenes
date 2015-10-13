package ec.edu.juanultimate.conmutadortrenes.grafos;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

/**
 * Created by JuanGabriel on 12/10/2015.
 */
public class Utils {

    public static Ciudad construirUnaCiudad(){
        return Ciudad.construir("A");
    }

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> getTestingGraph() {
        final GrafoDirigido<Ciudad, DefaultAristaDirigida> routeGraph = new DefaultGrafoDirigido<Ciudad, DefaultAristaDirigida>();
        final Ciudad nodeA = Ciudad.construir("A");
        final Ciudad nodeB = Ciudad.construir("B");
        final Ciudad nodeC = Ciudad.construir("C");
        final Ciudad nodeD = Ciudad.construir("D");
        final Ciudad nodeE = Ciudad.construir("E");

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
