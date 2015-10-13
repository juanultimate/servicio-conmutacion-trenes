package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.grafos.*;
import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCamino;

import java.util.*;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class DefaultGrafoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends DefaultGrafo<V,A> implements GrafoDirigido<V,A> {

   @Override
    public boolean agregarArista(V inicio, V fin, int ponderacion) {
        validarExistenciaVertice(inicio);
        validarExistenciaVertice(fin);
        final A nuevaArista = DefaultAristaDirigida.getNuevaAristaPonderada(inicio, fin, ponderacion);
        final Set<A> aristasExistentes = aristas.get(inicio);
        if (aristasExistentes.contains(nuevaArista)) {
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
            final CaminoDirigido<V,A> camino = DefaultCaminoDirigido.getCaminoVacio();
            camino.agregarArista(arista);
            caminos.addAll(busqueda(camino, filtro, fin));
        }
        if (caminos.isEmpty()) {
            throw new CaminoNoEncontradoException(inicio.toString(), fin.toString());
        }
        return caminos;
    }

    protected List<CaminoDirigido<V,A>> busqueda(final CaminoDirigido<V,A> camino, final FiltroCamino<V,A> filtroBusqueda, final V fin) {
        final List<CaminoDirigido<V,A>> caminos = new ArrayList<CaminoDirigido<V,A>>();
        if (filtroBusqueda.passFilter(camino)) {
            if (haAlcanzadoElObjetivo(camino, fin)) {
                caminos.add(DefaultCaminoDirigido.copiarCamino(camino));
            }
            for (final AristaDirigida<V> arista : aristas.get(camino.getVerticeFin())) {
                camino.agregarArista((A) arista);
                caminos.addAll(busqueda(camino, filtroBusqueda, fin));
            }
        }
        camino.removerUltimaArista();
        return caminos;
    }

    private boolean haAlcanzadoElObjetivo(final Camino<V,A> camino, final V fin) {
        return camino.getVerticeFin().equals(fin);
    }



}
