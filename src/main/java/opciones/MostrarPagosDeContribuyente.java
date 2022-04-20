package opciones;

import dominio.Municipalidad;
import utils.FormateadorDeString;

import java.util.Scanner;

public class MostrarPagosDeContribuyente implements OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;
    private final Scanner scanner;

    public MostrarPagosDeContribuyente(String descripcion, Municipalidad municipalidad, Scanner scanner) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
        this.scanner = scanner;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));

        scanner.nextLine();
        System.out.print("Ingrese el nombre del contribuyente: ");
        String nombre = scanner.nextLine();
        String pagos = municipalidad.listadoPagosContribuyente(nombre);

        System.out.println(FormateadorDeString.formatearResultado("Listado"));
        System.out.println(pagos);
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
