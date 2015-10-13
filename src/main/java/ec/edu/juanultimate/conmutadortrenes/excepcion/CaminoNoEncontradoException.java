package ec.edu.juanultimate.conmutadortrenes.excepcion;

public class CaminoNoEncontradoException extends RuntimeException {
    public CaminoNoEncontradoException(final String verticeInicio, final String verticeFin) {
        super("No existe camino entre " + verticeInicio + " y " + verticeFin);
    }
}
