package ec.edu.juanultimate.conmutadortrenes;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.DefaultAristaDirigida;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;

import java.util.List;

/**
 * Straight forward Facade for the trains problem. It provides convenience
 * methods to process the inputs to the problem.
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 */
public interface Commuter {

    int routeDistance(Ciudad startingCity, Ciudad destinationCity, List<Ciudad> intermediateCities);


    int numberOfPathsWithMaxStops(Ciudad startingCity, Ciudad destinationCity, int stops);


    int numberOfPathsWithMaxWeight(Ciudad startingCity, Ciudad destinationCity, int weight);


    int numberOfPathsWithExactStops(Ciudad startingCity, Ciudad destinationCity, int stops);


    int shortestDistance(Ciudad startingCity, Ciudad destinationCity);


    GrafoDirigido<Ciudad,DefaultAristaDirigida> getAllRoutes();

    int routeDuration(Ciudad startingCity, Ciudad endCity, List<Ciudad> intermediateCities);

}
