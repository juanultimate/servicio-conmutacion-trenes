package ec.edu.juanultimate.conmutadortrenes.app;



import ec.edu.juanultimate.conmutadortrenes.ingreso.Instruccion;
import ec.edu.juanultimate.conmutadortrenes.ingreso.InstruccionBuilder;
import ec.edu.juanultimate.conmutadortrenes.grafos.dirigido.GrafoDirigidoBuilder;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenesKiwiland;

import java.io.File;
import java.util.List;

public class Aplicacion {

    public static final String NOMBRE_ARCHIVO = "/datos.txt";

    public static void main(final String[] args) throws Exception {
        final ConmutadorTrenes conmutadorTrenes = new ConmutadorTrenesKiwiland(GrafoDirigidoBuilder.getEmptyGraph());
        File inputFile = new File(Aplicacion.class.getResource(NOMBRE_ARCHIVO).toURI());
        final List<Instruccion> instruccionesIngreso = new InstruccionBuilder(System.out).getInstruccionesDeArchivo(inputFile);
        for (final Instruccion instruccion : instruccionesIngreso) {
            instruccion.ejecutar(conmutadorTrenes);
        }
    }

}
