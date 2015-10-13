package ec.edu.juanultimate.conmutadortrenes.ingreso;


import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import org.junit.Before;
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
public class InstruccionDistanciaMinimaSpec {
    @Mock
    private ConmutadorTrenes commuter;
    @Mock
    private PrintStream stream;

    private Instruccion command;

    @Before
    public void initCommand() {
        command = new InstruccionDistanciaMinima("The length of the shortest route (in terms of distance to travel) from A to C", stream);
    }

    @Test
    public void shouldInvokeShortestDistance() {
        final int distance = 5;
        when(commuter.distanciaMasCorta(construirUnaCiudad("A"), construirUnaCiudad("C"))).thenReturn(distance);
        command.ejecutar(commuter);
        verify(stream).println(distance);
    }


    @Test
    public void shouldPrintNoRouteWhenExceptionIsThrown() {
        when(commuter.distanciaMasCorta(construirUnaCiudad("A"), construirUnaCiudad("C"))).thenThrow(CaminoNoEncontradoException.class);
        command.ejecutar(commuter);
        verify(stream).println(InstruccionCamino.MENSAJE_RUTA_NO_ENCONTRADA);
    }
}
