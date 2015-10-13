package ec.edu.juanultimate.conmutadortrenes.grafos;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

import static org.junit.Assert.*;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by JuanGabriel on 12/10/2015.
 */
public class DefaultGrafoSpec {
    private GrafoDirigido<Ciudad, DefaultAristaDirigida> grafo;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void inicializarGrafo(){
        grafo= Utils.getGrafoPrueba();
    }

    @Test
    public void cuandoSeAgregaUnVerticeNuloALGrafoEntoncesSeEsperaExcepcion(){
        expected.expect(IllegalArgumentException.class);
        grafo.agregarVertice(null);
        fail("Debio lanzar una excepción");
    }

    @Test
    public void cuandoSeAgregaUnVerticeNoNuloYQueNoExistaEntoncesRetornaTrue(){
        assertTrue(grafo.agregarVertice(construirUnaCiudadX()));
    }

    @Test
    public void cuandoSeAgregaUnVerticeNoNuloYQueYaExisteEntoncesRetornaFalse(){
        grafo.agregarVertice(construirUnaCiudadX());
        assertFalse(grafo.agregarVertice(construirUnaCiudadX()));
    }

    @Test
    public void cuandoSeQuiereAgregarUnaAristaEntoncesSeDebeEspecificarSusVertices(){
        assertTrue(grafo.agregarArista(construirUnaCiudad("C"), construirUnaCiudad("B")));
    }




    @Test
    public void cuandoSeQuiereAgregarUnaAristaExistenteEntoncesEstaNuevaReemplazaALaAnterior(){
        grafo.agregarArista(construirUnaCiudad("D"),construirUnaCiudad("E"));
        grafo.agregarArista(construirUnaCiudad("D"), construirUnaCiudad("E"));
    }



    @Test
    public void cuandoSePideUnaAristaQueSiExisteEntoncesLaRetorna(){
        grafo.agregarVertice(Utils.construirUnaCiudadX());
        assertFalse(grafo.agregarVertice(Utils.construirUnaCiudadX()));
    }





}

