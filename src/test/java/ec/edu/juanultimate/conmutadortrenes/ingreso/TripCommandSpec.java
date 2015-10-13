package ec.edu.juanultimate.conmutadortrenes.ingreso;

import org.junit.Assert;
import org.junit.Test;


public class TripCommandSpec {

    @Test
    public void debeExtrarElValorDelFiltro(){
        InstruccionPosiblesCaminos tc= new InstruccionPosiblesCaminos("The number of trips starting at C and ending at C with a maximum of 300000 stops", null);
        Assert.assertEquals(300000, tc.getValorFiltro());
    }

    @Test
    public void debeExtrarElNodoInicial(){
        InstruccionPosiblesCaminos tc= new InstruccionPosiblesCaminos("The number of trips starting at C and ending at D with a maximum of 30 stops", null);
        Assert.assertEquals("C", tc.getCiudadInicio());
    }

    @Test
    public void debeExtrarElNodoFinal(){
        InstruccionPosiblesCaminos tc= new InstruccionPosiblesCaminos("The number of trips starting at C and ending at D with a maximum of 30 stops", null);
        Assert.assertEquals("D", tc.getCiudadFin());
    }

}
