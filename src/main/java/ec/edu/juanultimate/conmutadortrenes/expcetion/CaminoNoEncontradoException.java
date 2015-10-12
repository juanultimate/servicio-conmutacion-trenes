package ec.edu.juanultimate.conmutadortrenes.expcetion;

public class CaminoNoEncontradoException extends RuntimeException {


    public CaminoNoEncontradoException(final String verticeInicio, final String verticeFin) {
        super("No route exists between " + verticeInicio + " and " + verticeFin);
    }
}
