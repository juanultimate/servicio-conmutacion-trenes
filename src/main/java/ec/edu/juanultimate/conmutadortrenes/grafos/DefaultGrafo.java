package ec.edu.juanultimate.conmutadortrenes.grafos;

import java.util.*;


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
    public boolean agregarArista(V inicio, V fin) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);
        final A nuevaArista = DefaultArista.getNuevaArista(inicio, fin);
        final Set<A> aristasExistentesInicio = aristas.get(inicio);
        if (aristasExistentesInicio.contains(nuevaArista)) {
            aristasExistentesInicio.remove(nuevaArista);
        }
        return aristas.get(inicio).add(nuevaArista);
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
            throw new IllegalArgumentException("Vertice no puede ser nulo");
        }
    }

    protected void validarExistenciaVertice(final V vertice) {
        if (!aristas.containsKey(vertice)) {
            throw new IllegalArgumentException("Vertice " + vertice + " no existe");
        }
    }



    @Override
    public Set<V> getTodosVertices() {
        return Collections.unmodifiableSet(aristas.keySet());
    }











}
