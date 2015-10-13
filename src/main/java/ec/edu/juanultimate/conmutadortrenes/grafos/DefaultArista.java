package ec.edu.juanultimate.conmutadortrenes.grafos;


public class DefaultArista<V extends Vertice> implements Arista<V> {
    private  final V verticeInicio;
    private  final V verticeFin;

    protected DefaultArista(final V verticeInicio, V verticeFin){
        this.verticeInicio = verticeInicio;
        this.verticeFin = verticeFin;
    }


    public static <V extends Vertice, A extends Arista> A getNuevaArista(final V verticeInicio, final V verticeFin) {
        return (A) new DefaultArista<V> (verticeInicio, verticeFin);
    }

    @Override
    public V getVerticeInicio() {
        return verticeInicio;
    }

    @Override
    public V getVerticeFin() {
        return verticeFin;
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
        final DefaultArista other = (DefaultArista) obj;
        if (verticeFin == null) {
            if (other.verticeFin != null) {
                return false;
            }
        } else if (!verticeFin.equals(other.verticeFin)) {
            return false;
        }
        if (verticeInicio == null) {
            if (other.verticeInicio != null) {
                return false;
            }
        } else if (!verticeInicio.equals(other.verticeInicio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int x = 32;
        int result = 1;
        result = x * result + (verticeFin == null ? 0 : verticeFin.hashCode());
        result = x * result + (verticeInicio == null ? 0 : verticeInicio.hashCode());
        return result;
    }

}
