package ec.edu.juanultimate.conmutadortrenes.ingreso;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


@RunWith(MockitoJUnitRunner.class)
public class InstruccionBuilderSpec {
    @Mock
    private PrintStream salida;

    private InstruccionBuilder builder;

    @Before
    public void inicializarInstruccion() {
        builder = new InstruccionBuilder(salida);
    }

    @Test
    public void debeLeerTodasLasInstruccionesDelArchivo() throws URISyntaxException, IOException {
        final File inputFile = new File(getClass().getResource("/test.txt").toURI());
       assertThat(builder.getInstruccionesDeArchivo(inputFile),containsInAnyOrder (getInstruccionesEsperadas().toArray()));
    }




    private List<Instruccion> getInstruccionesEsperadas() {
        final List<Instruccion> instruccionEsperada = new ArrayList<Instruccion>();
        instruccionEsperada.add(new InstruccionConstruirGrafo("Grafo: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7", salida));
        instruccionEsperada.add(new InstruccionDistanciaCamino("The distance of the route A-B-C", salida));
        instruccionEsperada.add(new InstruccionPosiblesCaminos("The number of trips starting at C and ending at C with a maximum of 3 stops", salida));
        instruccionEsperada.add(new InstruccionPosiblesCaminos("The number of trips starting at A and ending at C with exactly 4 stops", salida));
        instruccionEsperada.add(new InstruccionDistanciaMinima("The length of the shortest route (in terms of distance to travel) from A to C", salida));
        instruccionEsperada.add(new InstruccionPosiblesCaminos("The number of different routes from C to C with a distance of less than 30", salida));
        return instruccionEsperada;
    }

    @Test
    public void debeSerUnaOrdenDeDistancia(){
        String pregunta= "The distance of the route A-B-C";
        Assert.assertTrue(pregunta.matches(InstruccionBuilder.DISTANCIA_REGEX));


    }

    @Test
    public void debeSerUnaInstruccionDeNumeroDeViajesMaximoParadas(){
        String pregunta1= "The number of trips starting at C and ending at C with a maximum of 3 stops";
        String pregunta2= "The number of trips starting at A and ending at A with a maximum of 12 stops";
        String pregunta3= "The number of trips starting at A and ending at A with a maximum of 1 stop";
        Assert.assertTrue(pregunta1.matches(InstruccionBuilder.CAMINO_MAX_PARADAS_REGEX));
        Assert.assertTrue(pregunta2.matches(InstruccionBuilder.CAMINO_MAX_PARADAS_REGEX));
        Assert.assertTrue(pregunta3.matches(InstruccionBuilder.CAMINO_MAX_PARADAS_REGEX));
    }

    @Test
    public void debeSerUnaInstruccionDeNumeroDeViajesParadasExactas(){
        String pregunta1= "The number of trips starting at A and ending at C with exactly 1 stop";
        String pregunta2= "The number of trips starting at A and ending at C with exactly 4444444 stops";
        String pregunta3= "The number of trips starting at A and ending at C with exactly 0 stops";
        Assert.assertTrue(pregunta1.matches(InstruccionBuilder.CAMINO_EXACT_PARADAS_REGEX));
        Assert.assertTrue(pregunta2.matches(InstruccionBuilder.CAMINO_EXACT_PARADAS_REGEX));
        Assert.assertTrue(pregunta3.matches(InstruccionBuilder.CAMINO_EXACT_PARADAS_REGEX));
    }

    @Test
    public void debeSerUnaInstruccionDeNumeroDeViajesMaxDistance(){
        String pregunta1= "The number of different routes from C to C with a distance of less than 1";
        String pregunta2= "The number of different routes from C to C with a distance of less than 3";
        String pregunta3= "The number of different routes from C to C with a distance of less than 33333333";
        Assert.assertTrue(pregunta1.matches(InstruccionBuilder.CAMINO_MAX_DISTANCIA_REGEX));
        Assert.assertTrue(pregunta2.matches(InstruccionBuilder.CAMINO_MAX_DISTANCIA_REGEX));
        Assert.assertTrue(pregunta3.matches(InstruccionBuilder.CAMINO_MAX_DISTANCIA_REGEX));
    }


    @Test
    public void debeSerUnaInstruccionDeCaminoCorto(){
        String pregunta1= "The length of the shortest route (in terms of distance to travel) from A to C";
        String pregunta2= "The length of the shortest route (in terms of distance to travel) from X to C";
        String pregunta3= "The length of the shortest route (in terms of distance to travel) from C to C";
        Assert.assertTrue(pregunta1.matches(InstruccionBuilder.CAMINO_CORTO_REGEX));
        Assert.assertTrue(pregunta2.matches(InstruccionBuilder.CAMINO_CORTO_REGEX));
        Assert.assertTrue(pregunta3.matches(InstruccionBuilder.CAMINO_CORTO_REGEX));
    }

}
