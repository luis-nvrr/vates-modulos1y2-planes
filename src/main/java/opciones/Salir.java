package opciones;

import utils.FormateadorDeString;

public class Salir implements OpcionDeMenu{
    private final String descripcion;

    public Salir(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeMenu("Ejecucion finalizada"));
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
