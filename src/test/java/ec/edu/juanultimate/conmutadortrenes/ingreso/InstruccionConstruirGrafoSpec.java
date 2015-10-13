package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
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
    private ConmutadorTrenes commuter;
    @Mock
    private PrintStream salida;

    @Test
    public void shouldInvokeCommuterGraph() {
        final Instruccion command = new InstruccionConstruirGrafo("Grafo: AB3, BA3", salida);
        when(commuter.obtenerTodasLasRutas()).thenReturn(grafo);
        command.ejecutar(commuter);
        verify(commuter, atLeastOnce()).obtenerTodasLasRutas();
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("A"));
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("B"));
        verify(grafo).agregarArista(construirUnaCiudad("A"), construirUnaCiudad("B"), 3);
        verify(grafo).agregarArista(construirUnaCiudad("B"), construirUnaCiudad("A"), 3);
    }


}
