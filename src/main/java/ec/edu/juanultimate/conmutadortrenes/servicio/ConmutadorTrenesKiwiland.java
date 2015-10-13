package ec.edu.juanultimate.conmutadortrenes.servicio;


import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.CaminoDirigido;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultCaminoDirigido;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.filtros.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public final class ConmutadorTrenesKiwiland implements ConmutadorTrenes {
    private final GrafoDirigido<Ciudad,DefaultAristaDirigida> redVial;
    public ConmutadorTrenesKiwiland(final GrafoDirigido<Ciudad, DefaultAristaDirigida> redVial) {
        this.redVial = redVial;
    }

    @Override
    public int numeroDeCaminosConParadasExactas(final Ciudad inicio, final Ciudad fin, final int numeroParadas) {
        final List<CaminoDirigido<Ciudad, DefaultAristaDirigida>> caminos = redVial.getCaminosFiltrados(inicio, fin, new FiltroMaximoParadas<Ciudad, DefaultAristaDirigida>(numeroParadas));
        return caminos.parallelStream().filter(x -> x.getNumeroSaltos()== numeroParadas).collect(Collectors.toList()).size();
    }

    @Override
    public int numeroDeCaminosConMaximoParadas(final Ciudad inicio, final Ciudad fin, final int maximoParadas) {
        return redVial.getCaminosFiltrados(inicio, fin, new FiltroMaximoParadas<Ciudad, DefaultAristaDirigida>(maximoParadas)).size();
    }

    @Override
    public int numeroDeCaminosConDistanciaMaxima(final Ciudad inicio, final Ciudad fin, final int maximaDistancia) {
        return redVial.getCaminosFiltrados(inicio, fin, new FiltroCaminoDistancia<Ciudad, DefaultAristaDirigida>(maximaDistancia)).size();
    }

    @Override
    public int distanciaMasCorta(final Ciudad inicio, final Ciudad fin) {
        final List<CaminoDirigido<Ciudad,DefaultAristaDirigida>> allPaths = redVial.getCaminosFiltrados(inicio, fin,new FiltroCaminoConAristasRepetidas<Ciudad,DefaultAristaDirigida>());
        return Collections.min(allPaths).getCosteTotalCamino();
    }

    @Override
    public int distanciaRuta(final Ciudad inicio, final Ciudad fin, final List<Ciudad> paradas) {
        final CaminoDirigido<Ciudad,DefaultAristaDirigida> caminoDeseado = crearCamino(inicio, fin, paradas);
        final List<CaminoDirigido<Ciudad, DefaultAristaDirigida>> caminosEncontrados = redVial.getCaminosFiltrados(inicio, fin, new FiltroContieneCamino<Ciudad,DefaultAristaDirigida>(caminoDeseado));
        return ((CaminoDirigido)caminosEncontrados.get(0)).getCosteTotalCamino();
    }


    private CaminoDirigido<Ciudad,DefaultAristaDirigida> crearCamino(final Ciudad inicio, final Ciudad fin, final List<Ciudad> ciudadesIntermedias) {
        final CaminoDirigido<Ciudad,DefaultAristaDirigida> caminoDeseado = DefaultCaminoDirigido.getCaminoVacio();
        Ciudad ciudad = inicio;
        if (ciudadesIntermedias != null) {
            for (final Ciudad ciudadIntermedia : ciudadesIntermedias) {
                caminoDeseado.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(ciudad, ciudadIntermedia, 0));
                ciudad = ciudadIntermedia;
            }
        }
        caminoDeseado.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(ciudad, fin, 0));
        return caminoDeseado;
    }

    @Override
    public GrafoDirigido<Ciudad, DefaultAristaDirigida> obtenerTodasLasRutas() {
        return redVial;
    }
}
