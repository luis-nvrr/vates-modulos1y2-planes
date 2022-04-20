package opciones;

import dominio.Municipalidad;
import dominio.Pago;
import utils.FormateadorDeString;

import java.util.Scanner;

public class RegistrarPago implements OpcionDeMenu{
    private final String descripcion;
    private final Scanner scanner;
    private final Municipalidad municipalidad;

    public RegistrarPago(String descripcion, Scanner scanner, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.scanner = scanner;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));

        System.out.print("Ingrese el id del plan: ");
        int plan = scanner.nextInt();

        System.out.print("Ingrese la demora: ");
        int demora = scanner.nextInt();

        System.out.print("Ingrese el importe: ");
        float importe = scanner.nextFloat();

        Pago pago = new Pago(demora, importe);
        float vuelto = municipalidad.agregarPago(plan, pago);

        System.out.println();
        System.out.println(FormateadorDeString.formatearResultado("Pago registrado! Su vuelto es: " + vuelto));
        System.out.println(pago);
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
