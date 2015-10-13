package ec.edu.juanultimate.conmutadortrenes.ingreso;

import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;

public interface Instruccion {
    void ejecutar(ConmutadorTrenes conmutadorTrenes);
}
