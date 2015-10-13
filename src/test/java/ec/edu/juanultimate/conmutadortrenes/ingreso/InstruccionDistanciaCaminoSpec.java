package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;

@RunWith(MockitoJUnitRunner.class)
public class InstruccionDistanciaCaminoSpec {
    @Mock
    private ConmutadorTrenes conmutador;
    @Mock
    private PrintStream salida;


    private InstruccionCamino distanciaCamino;

    @Before
    public void inicializarInstruccion() {
        distanciaCamino = new InstruccionDistanciaCamino("The distance of the route A-B-C", salida);
    }

    @Test
    public void dadaUnaInstruccionDeDistanciaEntoncesDebeInvocarAInstruccionCaminoDistancia() {
        final List<Ciudad> intermedias = new ArrayList<Ciudad>();
        intermedias.add(construirUnaCiudad("B"));
        final int ditanciaCamino = 9;
        when(conmutador.distanciaRuta(construirUnaCiudad("A"), construirUnaCiudad("C"), intermedias)).thenReturn(ditanciaCamino);
        distanciaCamino.ejecutar(conmutador);
        verify(salida).println(ditanciaCamino);
    }


    @Test
    public void dadoUnaRutaNovalidaDebeImprimirNoShuchRoute() {
        final List<Ciudad> intermedias = new ArrayList<Ciudad>();
        intermedias.add(construirUnaCiudad("B"));
        when(conmutador.distanciaRuta(construirUnaCiudad("A"), construirUnaCiudad("C"), intermedias)).thenThrow(CaminoNoEncontradoException.class);
        distanciaCamino.ejecutar(conmutador);
        verify(salida).println(InstruccionDistanciaCamino.MENSAJE_RUTA_NO_ENCONTRADA);
    }
}
