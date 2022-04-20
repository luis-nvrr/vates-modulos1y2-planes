package opciones;

import dominio.Municipalidad;
import utils.FormateadorDeString;

public class MostrarPromedioIntereses implements OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;

    public MostrarPromedioIntereses(String descripcion, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));
        float promedio = municipalidad.promedioIntereses();
        System.out.println(FormateadorDeString.formatearResultado("Promedio de intereses: " + promedio));
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
