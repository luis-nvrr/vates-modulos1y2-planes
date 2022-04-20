package opciones;

import dominio.Municipalidad;
import dominio.Pago;
import dominio.Plan;
import utils.FormateadorDeString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simular implements OpcionDeMenu{
    private final String descripcion;
    private final Municipalidad municipalidad;

    public Simular(String descripcion, Municipalidad municipalidad) {
        this.descripcion = descripcion;
        this.municipalidad = municipalidad;
    }

    @Override
    public void ejecutar() {
        System.out.println(FormateadorDeString.formatearTituloDeSubmenu(this.descripcion));
        System.out.println(FormateadorDeString.formatearPasoSimulacion("Creando planes"));
        Plan plan1 = new Plan("Luis", 1200, 12);
        Plan plan2 = new Plan("Nicolas", 1500, 10);
        Plan plan3 = new Plan("Maria", 3000, 3);

        this.municipalidad.agregarPlan(plan1);
        this.municipalidad.agregarPlan(plan2);
        this.municipalidad.agregarPlan(plan3);

        System.out.println(plan1);
        System.out.println(plan2);
        System.out.println(plan3);

        System.out.println(FormateadorDeString.formatearPasoSimulacion("Creando todos los pagos del plan 3"));
        Pago pago1Plan3 = new Pago(0, 1000);
        Pago pago2Plan3 = new Pago(1, 1500);
        Pago pago3Plan3 = new Pago(2, 2000);

        this.municipalidad.agregarPago(3, pago1Plan3);
        this.municipalidad.agregarPago(3, pago2Plan3);
        this.municipalidad.agregarPago(3, pago3Plan3);

        System.out.println("Por las demoras, el importe aumenta");
        System.out.println(pago1Plan3);
        System.out.println(pago2Plan3);
        System.out.println(pago3Plan3);

        System.out.println(FormateadorDeString.formatearPasoSimulacion("Creando algunos pagos del plan 2"));

        Pago pago1plan2 = new Pago(0, 150);
        this.municipalidad.agregarPago(2, pago1plan2);
        System.out.println("Quedan 1350 en deuda");
        System.out.println(pago1plan2);

        System.out.println(FormateadorDeString.formatearPasoSimulacion("No se pagan cuotas del plan 1"));
        System.out.println("Quedan 1200 en deuda");

        System.out.println(FormateadorDeString.formatearPasoSimulacion("Mostrando informes"));

        List<OpcionDeMenu> pasos = new ArrayList<>();
        pasos.add(new MostrarCantidadDePlanesPagados("Cantidad de planes pagados en su totalidad", municipalidad));
        pasos.add(new MostrarDeuda("Deuda total", municipalidad));
        pasos.add(new MostrarPagosDeContribuyente("Pagos del contribuyente: MARIA", municipalidad, new Scanner("\r\nMaria")));
        pasos.add(new MostrarPromedioIntereses("Promedio general de intereses", municipalidad));

        pasos.forEach(OpcionDeMenu::ejecutar);
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
