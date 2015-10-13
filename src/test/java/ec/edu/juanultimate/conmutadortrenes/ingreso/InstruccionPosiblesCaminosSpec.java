package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;

@RunWith(MockitoJUnitRunner.class)
public class InstruccionPosiblesCaminosSpec {


    @Mock
    private ConmutadorTrenes commuter;
    @Mock
    private PrintStream stream;
    @InjectMocks
    private InstruccionPosiblesCaminos command;

    @Test
    public void shouldInvokeMaxStops() {
        command = new InstruccionPosiblesCaminos("The number of trips starting at C and ending at C with a maximum of 3 stops", stream);
        final int caminos = 3;
        when(commuter.numeroDeCaminosConMaximoParadas(construirUnaCiudad("C"), construirUnaCiudad("C"), 3)).thenReturn(caminos);
        command.ejecutar(commuter);
        verify(stream).println(caminos);
    }

    @Test
    public void shouldInvokeMaxWeight() {
        command = new InstruccionPosiblesCaminos("The number of different routes from C to C with a distance of less than 30", stream);
        final int weight = 5;
        when(commuter.numeroDeCaminosConDistanciaMaxima(construirUnaCiudad("C"), construirUnaCiudad("C"), 30)).thenReturn(weight);
        command.ejecutar(commuter);
        verify(stream).println(weight);
    }

    @Test
    public void shouldInvokeExactStops() {
        command = new InstruccionPosiblesCaminos("The number of trips starting at A and ending at C with exactly 4 stops", stream);
        final int caminos = 5;
        when(commuter.numeroDeCaminosConParadasExactas(construirUnaCiudad("A"), construirUnaCiudad("C"), 4)).thenReturn(caminos);
        command.ejecutar(commuter);
        verify(stream).println(caminos);
    }




}
