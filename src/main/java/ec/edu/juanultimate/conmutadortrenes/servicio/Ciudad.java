package ec.edu.juanultimate.conmutadortrenes.servicio;

import ec.edu.juanultimate.conmutadortrenes.grafos.Vertice;


public class Ciudad implements Vertice {
    private final String nombre;

    public static Ciudad construir(String nombre){
        return new Ciudad(nombre);
    }

    private Ciudad(String nombre) {
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

    @Override
    public String toString() {
        return "Ciudad: "+this.nombre;
    }
}
