package ec.edu.juanultimate.conmutadortrenes.ingreso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class InstruccionBuilder {
    static final String GRAFO_REGEX = "Grafo:\\s([A-Z][A-Z]\\d+)(, [A-Z][A-Z]\\d+)*";
    static final String DISTANCIA_REGEX = "The distance of the route\\s[A-Z]-[A-Z](-[A-Z])*";
    static final String CAMINO_MAX_PARADAS_REGEX = "The number of trips starting at [A-Z] and ending at [A-Z] with a maximum of (\\d)+ stop(s)?";
    static final String CAMINO_EXACT_PARADAS_REGEX = "The number of trips starting at [A-Z] and ending at [A-Z] with exactly (\\d)+ stop(s)?";
    static final String CAMINO_MAX_DISTANCIA_REGEX = "The number of different routes from [A-Z] to [A-Z] with a distance of less than (\\d)+";
    static final String CAMINO_CORTO_REGEX = "The length of the shortest route \\(in terms of distance to travel\\) from [A-Z] to [A-Z]";


    private final PrintStream outputStream;

    public InstruccionBuilder(final PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public List<Instruccion> getInstruccionesDeArchivo(final File archivo) throws IOException {
        final List<Instruccion> instrucciones = new ArrayList<Instruccion>();
        final BufferedReader reader = new BufferedReader(new FileReader(archivo));
        while (reader.ready()) {
            final Instruccion toAdd = procesarLinea(reader);
            if (toAdd != null) {
                instrucciones.add(toAdd);
            }
        }
        reader.close();
        return instrucciones;
    }

    private Instruccion procesarLinea(final BufferedReader reader) throws IOException {
        Instruccion intruccionProcesada = null;
        final String lineaActual = reader.readLine();
        if (lineaActual.matches(GRAFO_REGEX)) {
            intruccionProcesada = new InstruccionConstruirGrafo(lineaActual,outputStream);
        } else if (lineaActual.matches(CAMINO_CORTO_REGEX)) {
            intruccionProcesada = new InstruccionDistanciaMinima(lineaActual, outputStream);
        } else if (lineaActual.matches(CAMINO_MAX_PARADAS_REGEX) || lineaActual.matches(CAMINO_MAX_DISTANCIA_REGEX)|| lineaActual.matches(CAMINO_EXACT_PARADAS_REGEX)) {
            intruccionProcesada = new InstruccionPosiblesCaminos(lineaActual, outputStream);
        } else if (lineaActual.matches(DISTANCIA_REGEX)) {
            intruccionProcesada = new InstruccionDistanciaCamino(lineaActual, outputStream);
        } else {
            outputStream.println("Línea => " + lineaActual + " inválida");
        }
        return intruccionProcesada;
    }

}
