import dominio.Municipalidad;
import opciones.*;
import utils.FormateadorDeString;

import java.util.*;

public class Principal {
    private final static int OPCION_SALIR = 9;

    public static void main(String[] args) {
        Municipalidad municipalidad = new Municipalidad();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, OpcionDeMenu> opcionesMap = new TreeMap<>();
        opcionesMap.put(1, new RegistrarPlan("Registrar plan", scanner, municipalidad));
        opcionesMap.put(2, new RegistrarPago("Registrar pago", scanner, municipalidad));
        opcionesMap.put(3, new MostrarPlanes("Mostrar todos los planes", municipalidad));
        opcionesMap.put(4, new MostrarCantidadDePlanesPagados("Mostrar cantidad de planes pagados en su totalidad", municipalidad));
        opcionesMap.put(5, new MostrarDeuda("Mostrar deuda total", municipalidad));
        opcionesMap.put(6, new MostrarPagosDeContribuyente("Mostrar pagos de un contribuyente", municipalidad, scanner));
        opcionesMap.put(7, new MostrarPromedioIntereses("Mostrar promedio general de intereses adicionales", municipalidad));
        opcionesMap.put(8, new Simular("Simular ejecucion"));
        opcionesMap.put(OPCION_SALIR, new Salir("Terminar ejecución"));

        while(true) {
            System.out.println(FormateadorDeString.formatearTituloDeMenu("Municipalidad"));
            opcionesMap.forEach((key, opcion) -> System.out.println(FormateadorDeString.formatearOpcion(key, opcion.toString())));

            System.out.print("Opcion elegida: ");
            int opcionElegida = -1;

            try {
                opcionElegida = scanner.nextInt();
                OpcionDeMenu opcion = Optional.ofNullable(opcionesMap.get(opcionElegida))
                        .orElse(()-> System.out.println(FormateadorDeString.formatearError("Opcion no reconocida")));
                opcion.ejecutar();
            }
            catch (InputMismatchException e) {
                System.out.println(FormateadorDeString.formatearError("Formato de dato incorrecto"));
                scanner.nextLine();
            }
            catch (RuntimeException e) {
                System.out.println(FormateadorDeString.formatearError(e.getMessage()));
            }

            if(opcionElegida == OPCION_SALIR) break;
        }
    }
}