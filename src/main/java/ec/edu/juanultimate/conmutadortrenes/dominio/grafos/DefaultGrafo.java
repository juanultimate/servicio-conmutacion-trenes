package ec.edu.juanultimate.conmutadortrenes.dominio.grafos;

import ec.edu.juanultimate.conmutadortrenes.expcetion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.*;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultGrafo<V extends Vertice, A extends Arista> implements Grafo<V,A> {
    protected final Map<V, Set<A>> aristas = new HashMap<V, Set<A>>();

    @Override
    public boolean agregarVertice(final V vertice) {
        validarVerticeNoNulo(vertice);
        if (!aristas.containsKey(vertice)) {
            aristas.put(vertice, new LinkedHashSet<A>());
            return true;
        }
        return false;
    }

    @Override
    public A getArista(V inicio, V fin) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);
        final Set<A> verticeInicioAristas = aristas.get(inicio);
        for (final A arista : verticeInicioAristas) {
            if (arista.getVerticeFin().equals(fin)) {
                return arista;
            }
        }
        return null;
    }

    private void validarVerticeNoNulo(final V vertice) {
        if (vertice == null) {
            throw new IllegalArgumentException("Vertex can't be null");
        }
    }

    protected void validarExistenciaVertice(final V vertice) {
        if (!aristas.containsKey(vertice)) {
            throw new IllegalArgumentException("Vertex " + vertice + " doesn't exist");
        }
    }

    /**
     * Si en la definción se repite dosn lienas ferreas la ultima sobreescribe a la primera.
     * @param inicio
     * @param fin
     * @return
     */
    @Override
    public boolean agregarArista(V inicio, V fin) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);

        final A nuevaArista = DefaultArista.getNuevaArista(inicio, fin);

        final Set<A> aristasExistentesInicio = aristas.get(inicio);
        // No need for null check because we already
        // checked that the two vertex exist in the graph
        if (aristasExistentesInicio.contains(nuevaArista)) {
            // If the graph already contains the edge, remove it
            // and add the new one
            aristasExistentesInicio.remove(nuevaArista);
        }
        return aristas.get(inicio).add(nuevaArista);
    }


    @Override
    public Set<V> getTodosVertices() {
        return Collections.unmodifiableSet(aristas.keySet());
    }











}
