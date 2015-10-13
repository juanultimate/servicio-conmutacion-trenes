package ec.edu.juanultimate.conmutadortrenes.ingreso;



import ec.edu.juanultimate.conmutadortrenes.servicio.ConmutadorTrenes;
import ec.edu.juanultimate.conmutadortrenes.servicio.Ciudad;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InstruccionPosiblesCaminos extends AbstractInstruccion {

    public InstruccionPosiblesCaminos(final String linea, final PrintStream stream) {
        super(linea, stream);
    }

    @Override
    public void ejecutar(final ConmutadorTrenes conmutadorTrenes) {
        int valorFiltro= getValorFiltro();
        Ciudad inicio = Ciudad.construir(getCiudadInicio());
        Ciudad fin = Ciudad.construir(getCiudadFin());
        int numberOfTrips = 0;
        try {
            if (getLinea().matches(InstruccionBuilder.CAMINO_MAX_PARADAS_REGEX)) {
                numberOfTrips = conmutadorTrenes.numeroDeCaminosConMaximoParadas(inicio, fin, valorFiltro);
            } else if (getLinea().matches(InstruccionBuilder.CAMINO_EXACT_PARADAS_REGEX)) {
                numberOfTrips = conmutadorTrenes.numeroDeCaminosConParadasExactas(inicio, fin, valorFiltro);
            } else if (getLinea().matches(InstruccionBuilder.CAMINO_MAX_DISTANCIA_REGEX)) {
                numberOfTrips = conmutadorTrenes.numeroDeCaminosConDistanciaMaxima(inicio, fin, valorFiltro);
            }
            outputStream.println(numberOfTrips);
        } catch (final Exception e) {
            outputStream.println(InstruccionCamino.MENSAJE_RUTA_NO_ENCONTRADA);
        }

    }

    int getValorFiltro(){
        int filterValue=0;
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(getLinea());
        if (matcher.find())
        {
            filterValue = Integer.parseInt(matcher.group(0));
        }
        return filterValue;
    }
    String getCiudadInicio(){
        String coincidencia="";
        Pattern pattern1 = Pattern.compile("[A-Z] and ending at [A-Z]");
        Pattern pattern2 = Pattern.compile("[A-Z] to [A-Z]");
        Matcher matcher = pattern1.matcher(getLinea());
        if (matcher.find()){
            coincidencia=matcher.group(0);
        }
        matcher = pattern2.matcher(getLinea());
        if (matcher.find()){
            coincidencia=matcher.group(0);
        }
        return coincidencia.substring(0,1);
    }
    String getCiudadFin(){
        String coincidencia="";
        Pattern pattern1 = Pattern.compile("[A-Z] and ending at [A-Z]");
        Pattern pattern2 = Pattern.compile("[A-Z] to [A-Z]");
        Matcher matcher = pattern1.matcher(getLinea());
        if (matcher.find()){
            coincidencia=matcher.group(0);
        }
        matcher = pattern2.matcher(getLinea());
        if (matcher.find()){
            coincidencia=matcher.group(0);
        }
        return coincidencia.substring(coincidencia.length()-1);
    }

}
