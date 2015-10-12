package ec.edu.juanultimate.conmutadortrenes;


import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Camino;
import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido.*;
import ec.edu.juanultimate.conmutadortrenes.dominio.trenes.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.filtros.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default implementation of {@link Commuter}. It uses the interface provided by
 * {@link }, particularly
 * {@link (Object, Object, )}
 * 
 * @author "Jose Luis Ordiales Coscia <jlordiales@gmail.com>"
 * 
 */
public final class CommuterImpl implements Commuter {
    private final GrafoDirigido<Ciudad,DefaultAristaDirigida> routes;

    public CommuterImpl(final GrafoDirigido<Ciudad,DefaultAristaDirigida> routes) {
        super();
        this.routes = routes;
    }

    @Override
    public int numberOfPathsWithExactStops(final Ciudad startingCity, final Ciudad destinationCity, final int stops) {
        // We need to get all the paths up to the maximum number of stops first
        // Otherwise for stops > 1, the "getAllPaths" method would stop on the
        // first city
        final List<CaminoDirigido<Ciudad, DefaultAristaDirigida>> paths = routes.getCaminosFiltrados(startingCity, destinationCity, new MaxHopsPathFilter<Ciudad, DefaultAristaDirigida>(stops));
        final List<Camino<Ciudad,DefaultAristaDirigida>> exactPaths = new ArrayList<Camino<Ciudad, DefaultAristaDirigida>>();
        // Now we filter again to get only those with the exact number of stops
        // and not less
        final FiltroCamino<Ciudad,DefaultAristaDirigida> exactFilter = new ExactHopsPathFilter<Ciudad,DefaultAristaDirigida>(stops);
        for (final CaminoDirigido<Ciudad,DefaultAristaDirigida> each : paths) {
            if (exactFilter.passFilter(each)) {
                exactPaths.add(each);
            }
        }
        return exactPaths.size();
    }

    @Override
    public int numberOfPathsWithMaxStops(final Ciudad startingCity, final Ciudad destinationCity, final int stops) {
        return routes.getCaminosFiltrados(startingCity, destinationCity, new MaxHopsPathFilter<Ciudad, DefaultAristaDirigida>(stops)).size();
    }

    @Override
    public int numberOfPathsWithMaxWeight(final Ciudad startingCity, final Ciudad destinationCity, final int weight) {
        return routes.getCaminosFiltrados(startingCity, destinationCity, new WeightPathFilter<Ciudad, DefaultAristaDirigida>(weight)).size();
    }

    @Override
    public int shortestDistance(final Ciudad startingCity, final Ciudad destinationCity) {
        // By definition the shortest path between two nodes can not have cycles
        // in it
        final List<CaminoDirigido<Ciudad,DefaultAristaDirigida>> allPaths = routes.getCaminosFiltrados(startingCity, destinationCity,
                new RepeatedEdgePathFilter<Ciudad,DefaultAristaDirigida>());
        return ((CaminoDirigido)Collections.min(allPaths)).getPathTotalWeight();
    }

    @Override
    public int routeDistance(final Ciudad startingCity, final Ciudad destinationCity, final List<Ciudad> intermediateNodes) {
        final CaminoDirigido<Ciudad,DefaultAristaDirigida> objectivePath = createPath(startingCity, destinationCity, intermediateNodes);
        final List<CaminoDirigido<Ciudad, DefaultAristaDirigida>> allPaths = routes.getCaminosFiltrados(startingCity, destinationCity, new ContainsPathFilter<Ciudad,DefaultAristaDirigida>(
                objectivePath));

        // No need to check list size since at this point there should be
        // only 1 element on it. If there is no path a NoSuchRoute exception
        // should have been thrown on the previous call to "getAllPaths".
        return ((CaminoDirigido)allPaths.get(0)).getPathTotalWeight();
    }

    /**
     * Creates a {@link } object from a starting node, an ending node and a
     * list of intermediate nodes
     * 
     * @param from
     *            The starting node
     * @param to
     *            The ending node
     * @param intermediateNodes
     *            List of intermediate nodes
     * @return a {@link } object representing the route between the nodes
     */
    private CaminoDirigido<Ciudad,DefaultAristaDirigida> createPath(final Ciudad from, final Ciudad to, final List<Ciudad> intermediateNodes) {
        final CaminoDirigido<Ciudad,DefaultAristaDirigida> resultingPath = DefaultCaminoDirigido.emptyPath();
        Ciudad currentNode = from;
        if (intermediateNodes != null) {
            for (final Ciudad eachIntermediate : intermediateNodes) {
                resultingPath.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(currentNode, eachIntermediate, 0));
                currentNode = eachIntermediate;
            }
        }
        resultingPath.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(currentNode, to, 0));
        return resultingPath;
    }

    @Override
    public GrafoDirigido<Ciudad, DefaultAristaDirigida> getAllRoutes() {
        return routes;
    }

    @Override
    public int routeDuration(Ciudad startingCity, Ciudad endCity, List<Ciudad> intermediateCities) {
        return  routeDistance(startingCity, endCity, intermediateCities) + 2 * intermediateCities.size();
    }

}
