package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;

@RunWith(MockitoJUnitRunner.class)
public class InstruccionPosiblesCaminosSpec {


    @Mock
    private ConmutadorTrenes conmutador;
    @Mock
    private PrintStream salida;

    private InstruccionPosiblesCaminos posiblesCaminos;

    @Test
    public void dadaUnaInstruccionDePosiblesCaminosEntoncesDebeInvocarAInstruccionPosiblesCaminos() {
        posiblesCaminos = new InstruccionPosiblesCaminos("The number of trips starting at C and ending at C with a maximum of 3 stops", salida);
        final int caminos = 3;
        when(conmutador.numeroDeCaminosConMaximoParadas(construirUnaCiudad("C"), construirUnaCiudad("C"), 3)).thenReturn(caminos);
        posiblesCaminos.ejecutar(conmutador);
        verify(salida).println(caminos);
    }

    @Test
    public void dadaUnaInstruccionDeDiferentesCaminosConMaximaDistanciaEntoncesDebeInvocarAInstruccionNumeroDeCaminosConDistanciaMaxima() {
        posiblesCaminos = new InstruccionPosiblesCaminos("The number of different routes from C to C with a distance of less than 30", salida);
        final int weight = 5;
        when(conmutador.numeroDeCaminosConDistanciaMaxima(construirUnaCiudad("C"), construirUnaCiudad("C"), 30)).thenReturn(weight);
        posiblesCaminos.ejecutar(conmutador);
        verify(salida).println(weight);
    }

    @Test
    public void dadaUnaInstruccionDeDiferentesCaminosConParadasExactasEntoncesDebeInvocarAInstruccionNumeroDeCaminosConParadasExactas() {
        posiblesCaminos = new InstruccionPosiblesCaminos("The number of trips starting at A and ending at C with exactly 4 stops", salida);
        final int caminos = 5;
        when(conmutador.numeroDeCaminosConParadasExactas(construirUnaCiudad("A"), construirUnaCiudad("C"), 4)).thenReturn(caminos);
        posiblesCaminos.ejecutar(conmutador);
        verify(salida).println(caminos);
    }


    @Test
    public void debeExtrarElValorDelFiltro() {
        InstruccionPosiblesCaminos tc = new InstruccionPosiblesCaminos("The number of trips starting at C and ending at C with a maximum of 300000 stops", null);
        Assert.assertEquals(300000, tc.getValorFiltro());
    }

    @Test
    public void debeExtrarElNodoInicial() {
        InstruccionPosiblesCaminos tc = new InstruccionPosiblesCaminos("The number of trips starting at C and ending at D with a maximum of 30 stops", null);
        Assert.assertEquals("C", tc.getCiudadInicio());
    }

    @Test
    public void debeExtrarElNodoFinal() {
        InstruccionPosiblesCaminos tc = new InstruccionPosiblesCaminos("The number of trips starting at C and ending at D with a maximum of 30 stops", null);
        Assert.assertEquals("D", tc.getCiudadFin());
    }
}
