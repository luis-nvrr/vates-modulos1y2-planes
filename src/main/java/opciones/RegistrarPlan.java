package opciones;

import dominio.Municipalidad;
import dominio.Plan;
import utils.FormateadorDeString;

import java.util.Scanner;

public class RegistrarPlan implements OpcionDeMenu {
    private final String descripcion;
    private final Scanner scanner;
    private final Municipalidad municipalidad;

    public RegistrarPlan(String descripcion,  Scanner scanner, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.scanner = scanner;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(descripcion));

        scanner.nextLine();
        System.out.print("Ingrese el nombre del contribuyente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el total de la deuda: ");
        float total = scanner.nextFloat();

        System.out.print("Ingrese la cantidad de cuotas: ");
        int cuotas = scanner.nextInt();

        Plan plan = new Plan(nombre, total, cuotas);
        int idPlan = municipalidad.agregarPlan(plan);
        
        System.out.println();
        System.out.println(FormateadorDeString.formatearResultado("Plan registrado! El id es: " + idPlan));
        System.out.println(plan);
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
