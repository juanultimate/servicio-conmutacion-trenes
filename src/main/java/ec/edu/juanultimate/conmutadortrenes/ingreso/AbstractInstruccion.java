package ec.edu.juanultimate.conmutadortrenes.ingreso;


import java.io.PrintStream;

abstract class AbstractInstruccion implements Instruccion {
    private final String linea;
    protected final PrintStream outputStream;

    public AbstractInstruccion(final String linea, PrintStream outputStream) {
        this.linea = linea;
        this.outputStream = outputStream;
    }

    protected final String getLinea() {
        return linea;
    }

    @Override
    public int hashCode() {
        final int x = 31;
        int result = 1;
        result = x * result + (linea == null ? 0 : linea.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractInstruccion other = (AbstractInstruccion) obj;
        if (linea == null) {
            if (other.linea != null) {
                return false;
            }
        } else if (!linea.equals(other.linea)) {
            return false;
        }
        return true;
    }

}
