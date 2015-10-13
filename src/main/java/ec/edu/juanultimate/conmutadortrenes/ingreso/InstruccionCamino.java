package ec.edu.juanultimate.conmutadortrenes.ingreso;



import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;
import ec.edu.juanultimate.conmutadortrenes.excepcion.CaminoNoEncontradoException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class InstruccionCamino extends AbstractInstruccion {

    protected static final String MENSAJE_RUTA_NO_ENCONTRADA = "NO SUCH ROUTE";

    public InstruccionCamino(String linea, PrintStream outputStream) {
        super(linea, outputStream);
    }
    
    protected abstract int ejecutarConmutador(ConmutadorTrenes conmutadorTrenes, Ciudad inicio, Ciudad fin, List<Ciudad> ciudadesIntermedias);

    @Override
    public void ejecutar(final ConmutadorTrenes conmutadorTrenes) {
        final String datosRuta = getLinea().substring(26);
        final String[] elementosRuta = datosRuta.split("-");
        final Ciudad[] ciudades = new Ciudad[elementosRuta.length];
        for(int i=0;i<elementosRuta.length;i++)
            ciudades[i]= Ciudad.construir(elementosRuta[i]);
        try {
            outputStream.println(ejecutarConmutador(conmutadorTrenes, ciudades[0], ciudades[elementosRuta.length - 1], getCiudadesIntermedias(ciudades)));
        } catch (final CaminoNoEncontradoException e) {
            outputStream.println(MENSAJE_RUTA_NO_ENCONTRADA);
        }
    }

    private List<Ciudad> getCiudadesIntermedias(final Ciudad[] ciudades) {
        final List<Ciudad> ciudadesIntermedias = new ArrayList<Ciudad>();
        for (int i = 1; i < ciudades.length - 1; i++) {
            ciudadesIntermedias.add(ciudades[i]);
        }
        return ciudadesIntermedias;
    }

}
