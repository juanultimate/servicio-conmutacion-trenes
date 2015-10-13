package ec.edu.juanultimate.conmutadortrenes.grafos;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by JuanGabriel on 12/10/2015.
 */
public class DefaultGrafoSpec {
    private GrafoDirigido<Ciudad, DefaultAristaDirigida> grafo = Utils.getTestingGraph();

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void cuandoSeAgregaUnVerticeNuloALGrafoEntoncesSeEsperaExcepcion(){
        expected.expect(IllegalArgumentException.class);
        grafo.agregarVertice(null);
    }
}

