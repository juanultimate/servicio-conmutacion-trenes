package ec.edu.juanultimate.conmutadortrenes.grafos;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.*;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by JuanGabriel on 12/10/2015.
 */
public class Utils {

    public static Ciudad construirUnaCiudadX(){
        return Ciudad.construir("X");
    }
    public static Ciudad construirUnaCiudadY(){
        return Ciudad.construir("Y");
    }
    public static Ciudad construirUnaCiudad(String x){return Ciudad.construir(x);}

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> construirGrafoPrueba() {
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
    public static Vertice[] getVerticesGrafoPrueba(){
        return new Vertice[]{Ciudad.construir("A"),Ciudad.construir("B"),Ciudad.construir("C"),Ciudad.construir("D"),Ciudad.construir("E")};
    }

    public static CaminoDirigido<Ciudad,DefaultAristaDirigida> construirCaminoPrueba(){
        CaminoDirigido<Ciudad,DefaultAristaDirigida> camino;
        camino = DefaultCaminoDirigido.getCaminoVacio();
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("W"),construirUnaCiudad("X"),3));
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("X"), construirUnaCiudad("Y"), 4));
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("Y"), construirUnaCiudad("Z"), 5));
        return camino;
    }

    public static List<Ciudad> construirCiudadesIntermedias(Ciudad ... ciudades){
        return Arrays.asList(ciudades);
    }



}
