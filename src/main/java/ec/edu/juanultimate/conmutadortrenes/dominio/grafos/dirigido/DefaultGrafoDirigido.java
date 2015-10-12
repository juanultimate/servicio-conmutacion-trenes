package ec.edu.juanultimate.conmutadortrenes.dominio.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.*;
import ec.edu.juanultimate.conmutadortrenes.expcetion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.*;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultGrafoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends DefaultGrafo<V,A> implements GrafoDirigido<V,A> {

    /**
     * Si en la definción se repite dosn lienas ferreas la ultima sobreescribe a la primera.
     * @param inicio
     * @param fin
     * @param coste
     * @return
     */
    @Override
    public boolean agregarArista(V inicio, V fin, int coste) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);
        final A nuevaArista = DefaultAristaDirigida.getNuevaAristaPonderada(inicio, fin, coste);

        final Set<A> aristasExistentes = aristas.get(inicio);
        // No need for null check because we already
        // checked that the two vertex exist in the graph
        if (aristasExistentes.contains(nuevaArista)) {
            // If the graph already contains the edge, remove it
            // and add the new one
            aristasExistentes.remove(nuevaArista);
        }
        return aristas.get(inicio).add(nuevaArista);
    }


    @Override
    public List<CaminoDirigido<V, A>> getCaminosFiltrados(V inicio, V fin, FiltroCamino<V, A> filtro) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);
        final List<CaminoDirigido<V,A>> caminos = new ArrayList<CaminoDirigido<V, A>>();
        for (final A arista : aristas.get(inicio)) {
            final CaminoDirigido<V,A> camino = DefaultCaminoDirigido.emptyPath();
            camino.agregarArista(arista);
            caminos.addAll(busqueda(camino, filtro, fin));
        }

        if (caminos.isEmpty()) {
            throw new CaminoNoEncontradoException(inicio.toString(), fin.toString());
        }
        return caminos;

    }

    protected List<CaminoDirigido<V,A>> busqueda(final CaminoDirigido<V,A> camino, final FiltroCamino<V,A> filter, final V fin) {
        final List<CaminoDirigido<V,A>> caminos = new ArrayList<CaminoDirigido<V,A>>();
        if (filter.passFilter(camino)) {
            if (haAlcanzadoElObjetivo(camino, fin)) {
                caminos.add(DefaultCaminoDirigido.copyPath(camino));
            }
            for (final AristaDirigida<V> arista : aristas.get(camino.getVerticeFin())) {
                camino.agregarArista((A) arista);
                caminos.addAll(busqueda(camino, filter, fin));
            }

        }
        camino.removerUltimaArista();
        return caminos;
    }

    private boolean haAlcanzadoElObjetivo(final Camino<V,A> camino, final V fin) {
        return camino.getVerticeFin().equals(fin);
    }



}
