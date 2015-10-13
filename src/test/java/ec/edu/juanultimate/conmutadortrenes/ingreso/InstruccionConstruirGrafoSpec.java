package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;

@RunWith(MockitoJUnitRunner.class)
public class InstruccionConstruirGrafoSpec {
    @Mock
    private DefaultGrafoDirigido<Ciudad, DefaultAristaDirigida> grafo;
    @Mock
    private ConmutadorTrenes conmutadorTrenes;
    @Mock
    private PrintStream salida;

    Instruccion construccionGrafo;

    @Before
    public void inicializarInstruccion() {
        construccionGrafo= new InstruccionConstruirGrafo("Grafo: AB3, BA3", salida);
    }

    @Test
    public void dadaUnaInstruccionDeConstruirGrafoEntoncesDebeInvocarAInstruccionConstruirGrafo() {
        when(conmutadorTrenes.obtenerTodasLasRutas()).thenReturn(grafo);
        construccionGrafo.ejecutar(conmutadorTrenes);
        verify(conmutadorTrenes, atLeastOnce()).obtenerTodasLasRutas();
    }

    @Test
    public void cuandoSeConstruyeElGrafoEntoncesDebeConstruirSusAristasYVertices() {
        when(conmutadorTrenes.obtenerTodasLasRutas()).thenReturn(grafo);
        construccionGrafo.ejecutar(conmutadorTrenes);
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("A"));
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("B"));
        verify(grafo).agregarArista(construirUnaCiudad("A"), construirUnaCiudad("B"), 3);
        verify(grafo).agregarArista(construirUnaCiudad("B"), construirUnaCiudad("A"), 3);
    }
}
