package ec.edu.juanultimate.conmutadortrenes.servicio;


import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;

import java.util.List;

public interface ConmutadorTrenes {
    int distanciaRuta(Ciudad inicio, Ciudad fin, List<Ciudad> paradas);
    int numeroDeCaminosConMaximoParadas(Ciudad inicio, Ciudad fin, int maximoParadas);
    int numeroDeCaminosConParadasExactas(Ciudad inicio, Ciudad fin, int paradas);
    int distanciaMasCorta(Ciudad inicio, Ciudad fin);
    int numeroDeCaminosConDistanciaMaxima(Ciudad inicio, Ciudad fin, int maximaDistancia);
    GrafoDirigido<Ciudad,DefaultAristaDirigida> obtenerTodasLasRutas();


}
