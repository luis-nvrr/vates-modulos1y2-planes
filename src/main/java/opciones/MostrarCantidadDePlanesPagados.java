package opciones;

import dominio.Municipalidad;
import utils.FormateadorDeString;

public class MostrarCantidadDePlanesPagados implements OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;
    public MostrarCantidadDePlanesPagados(String descripcion, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));
        int total = municipalidad.cantidadPlanesPagados();
        System.out.println(FormateadorDeString.formatearResultado("Total: " + total));
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
