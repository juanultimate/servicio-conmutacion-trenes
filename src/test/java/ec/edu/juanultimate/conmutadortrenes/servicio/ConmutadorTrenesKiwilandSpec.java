package ec.edu.juanultimate.conmutadortrenes.servicio;

import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static ec.edu.juanultimate.conmutadortrenes.grafos.Utils.*;
import static org.junit.Assert.assertEquals;


public class ConmutadorTrenesKiwilandSpec {

    private final ConmutadorTrenes conmutadorTrenes = new ConmutadorTrenesKiwiland(construirGrafoPrueba());
    private final Ciudad A = construirUnaCiudad("A");
    private final Ciudad B = construirUnaCiudad("B");
    private final Ciudad C = construirUnaCiudad("C");
    private final Ciudad D = construirUnaCiudad("D");
    private final Ciudad E = construirUnaCiudad("E");


    @Test
    public void dadoElGrafoDePruebaLaDistanciaEntre_ADC_DebeSerTrece() {
        assertEquals(13, conmutadorTrenes.distanciaRuta(A, C, construirCiudadesIntermedias(D)));
    }

    @Test
    public void dadoElGrafoDePruebaLaDistanciaEntre_EBCDE_DebeSerVeinteYUno() {
        assertEquals(21, conmutadorTrenes.distanciaRuta(E, E, construirCiudadesIntermedias(B, C, D)));
    }


    @Test
    public void dadoElGrafoDePruebaElNumerodeCaminosEntre_CyC_COnMaximoTresParadasDebeSerDos() {
        assertEquals(2,conmutadorTrenes.numeroDeCaminosConMaximoParadas(C, C, 3));
    }

    @Test
    public void dadoElGrafoDePruebaElNumeroDeCaminosConExactamenteDosParadasEntre_CyC_EsUno() {
        assertEquals(1,conmutadorTrenes.numeroDeCaminosConParadasExactas(C, C, 2));
    }

    @Test
    public void dadoElGrafoDePruebaLaDistanciaMinimaEntre_AyE_esSiete() {
        assertEquals(7, conmutadorTrenes.distanciaMasCorta(A, E));
    }

    @Test
    public void dadoElGrafoDePruebaLaDistanciaMinimaEntre_ByB_esNueve() {
        assertEquals(9, conmutadorTrenes.distanciaMasCorta(B, B));
    }

    @Test
    public void dadoElGrafoDePruebaElNumeroDeCaminosEntre_DyD_conDistanciasMenoresADiezYSieteEsUno() {
        assertEquals(1,conmutadorTrenes.numeroDeCaminosConDistanciaMaxima(D, D, 17));
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();


    @Test
    public void dadoElGrafoDePruebaElNumeroDeCaminosEntre_DyD_conDistanciasMenoresADiezYSieteDebeRetornarExcepcion() {
        expected.expect(CaminoNoEncontradoException.class);
        conmutadorTrenes.numeroDeCaminosConDistanciaMaxima(D, D, 16);
    }

    @Test
    public void dadoElGrafoDePruebaLaDistanciaEntre_AED_DebeSerTrece() {
        expected.expect(CaminoNoEncontradoException.class);
    }

}
