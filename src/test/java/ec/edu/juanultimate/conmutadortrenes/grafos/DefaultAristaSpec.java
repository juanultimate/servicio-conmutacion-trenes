package ec.edu.juanultimate.conmutadortrenes.grafos;

import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class DefaultAristaSpec {
    private static Vertice inicio;
    private static Vertice fin;
    private static DefaultArista<Ciudad> arista;


    @BeforeClass
    public static void init() {
        inicio = Ciudad.construir("X");
        fin = Ciudad.construir("Y");
        arista = DefaultArista.getNuevaArista(inicio, fin);
    }

    @Test
    public void cuandoAristaEsInstanciadaEntoncesSusAtributosSonSeteados() {
        assertEquals(inicio, arista.getVerticeInicio());
        assertEquals(fin, arista.getVerticeFin());
    }

    @Test
    public void cuandoDosAristasTienenLosMismosVerticesInicioYEntoncesFinSonIguales() {
        DefaultArista<Ciudad> otraArista = DefaultArista.getNuevaArista(inicio, fin);
        assertEquals(arista, otraArista);
        assertEquals(arista, arista);
    }

    @Test
    public void cuandoDosAristasTienenDiferentesVerticesInicioYFinEntoncesSonDiferentes() {
        DefaultArista<Ciudad> otraArista = DefaultArista.getNuevaArista(fin, inicio);
        assertNotEquals(arista, otraArista);
        Vertice otroFin = Ciudad.construir("Z");
        otraArista = DefaultArista.getNuevaArista(inicio, otroFin);
        assertNotEquals(arista, otraArista);
        assertNotEquals(arista, null);
        assertNotEquals(arista, inicio);
    }


}
