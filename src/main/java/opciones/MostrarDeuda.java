package opciones;

import dominio.Municipalidad;
import utils.FormateadorDeString;

public class MostrarDeuda implements OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;

    public MostrarDeuda(String descripcion, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));
        float deuda = municipalidad.sumatoriaDeuda();
        System.out.println(FormateadorDeString.formatearResultado("Deuda: " + deuda));
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
