package ec.edu.juanultimate.conmutadortrenes.dominio.trenes;

import ec.edu.juanultimate.conmutadortrenes.dominio.grafos.Vertice;

/**
 * Created by JuanGabriel on 11/10/2015.
 */
public class Ciudad implements Vertice {
    private final String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        else{
            if(!(obj instanceof Ciudad)){
                return false;
            }
            else{
                return ((Ciudad)(obj)).nombre.equals(this.nombre);

            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 32;
        int result = 1;
        result = prime * result + (nombre == null ? 0 : nombre.hashCode());
        return result;
    }
}
