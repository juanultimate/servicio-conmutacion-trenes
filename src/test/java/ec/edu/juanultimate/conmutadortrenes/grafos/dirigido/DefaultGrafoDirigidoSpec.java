package ec.edu.juanultimate.conmutadortrenes.grafos.dirigido;

import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroCaminoDistancia;
import ec.edu.juanultimate.conmutadortrenes.filtros.FiltroMaximoParadas;
import ec.edu.juanultimate.conmutadortrenes.grafos.Utils;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.*;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;
import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.construirUnaCiudad;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class DefaultGrafoDirigidoSpec {

    private GrafoDirigido<Ciudad,DefaultAristaDirigida> grafoDirigido;

    @Before
    public void inicializarGrafo() {
        grafoDirigido = Utils.construirGrafoPrueba();
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();


    @Test(expected = CaminoNoEncontradoException.class)
    public void cuandoSePideUnCaminoCuyaDistanciaNoExisteDebeRetornarExcepcion() {
        grafoDirigido.getCaminosFiltrados(construirUnaCiudad("A"), construirUnaCiudad("B"), new FiltroCaminoDistancia<Ciudad, DefaultAristaDirigida>(1));
    }

    @Test
    public void verificarObtencionDeCaminos() {
       List<CaminoDirigido<Ciudad, DefaultAristaDirigida>> caminos= grafoDirigido.getCaminosFiltrados(construirUnaCiudad("A"), construirUnaCiudad("B"), new FiltroMaximoParadas<Ciudad, DefaultAristaDirigida>(3));
        assertThat(caminos, hasSize(3));
        caminos = grafoDirigido.getCaminosFiltrados(construirUnaCiudad("A"), construirUnaCiudad("D"), new FiltroMaximoParadas<Ciudad, DefaultAristaDirigida>(2));
        assertThat(caminos,hasSize(1));

    }




}
