package ec.edu.juanultimate.conmutadortrenes.ingreso;



import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

import java.io.PrintStream;
import java.util.List;


class InstruccionDistanciaCamino extends InstruccionCamino {
    public InstruccionDistanciaCamino(final String linea, final PrintStream stream) {
        super(linea, stream);
    }

    @Override
    protected int ejecutarConmutador(ConmutadorTrenes conmutadorTrenes, Ciudad inicio, Ciudad fin, List<Ciudad> ciudadesIntermedias) {
        return conmutadorTrenes.distanciaRuta(inicio, fin, ciudadesIntermedias);
    }

}
