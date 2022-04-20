package opciones;

import dominio.Municipalidad;
import utils.FormateadorDeString;

public class MostrarPlanes implements  OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;

    public MostrarPlanes(String descripcion, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));
        System.out.println(FormateadorDeString.formatearResultado("Planes registrados"));
        String planes = this.municipalidad.listadoPlanes();
        System.out.println(planes);
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
