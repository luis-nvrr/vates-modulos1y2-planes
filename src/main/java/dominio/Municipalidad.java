package dominio;

import java.util.*;

public class Municipalidad {
    private final Map<Integer, Plan> planes;
    private final int ID_INICIAL_PAGOS = 1;

    public Municipalidad() {
        this.planes = new HashMap<>();
    }

    private int calcularIdDePlan() {
        return this.planes.size() + ID_INICIAL_PAGOS;
    }

    private void validarPlan(Plan plan) {
        if (plan.getTotal() < 0 || plan.getCuotas() < 0 )
            throw new RuntimeException("Los datos negativos son inválidos");
    }

    public int agregarPlan(Plan plan) {
        validarPlan(plan);
        plan.setId(calcularIdDePlan());
        this.planes.put(plan.getId(), plan);
        return plan.getId();
    }

    public float agregarPago(int planId, Pago pago) {
        Plan plan = Optional.ofNullable(this.planes.get(planId))
                .orElseThrow(() -> new RuntimeException("Id de plan no válido"));
        plan.agregarPago(pago);
        return plan.calcularVuelto(pago);
    }

    public String listadoPlanes() {
        return Optional.of(
                this.planes.values().stream()
                    .map(Plan::toString)
                    .reduce("", (a,b) -> a+"\n"+b))
                .filter(s -> !s.isEmpty())
                .orElse("El listado está vacío");
    }

    public int cantidadPlanesPagados() {
        return (int) this.planes.values().stream()
                .filter(Plan::estaPagadoTotalmente)
                .count();
    }

    public float sumatoriaDeuda() {
        return (float) this.planes.values().stream()
                .mapToDouble(Plan::calcularDeuda)
                .sum();
    }

    public String listadoPagosContribuyente(String nombre) {
        return  Optional.of(
                this.planes.values().stream()
                    .filter(plan -> plan.esDeContribuyente(nombre))
                    .map(Plan::listadoPagos)
                    .reduce("", (a, b) -> a+b))
                .filter(s -> !s.isEmpty())
                .orElse("El listado está vacío");
    }

    public float promedioIntereses() {
        return (float) this.planes.values().stream()
                .map(Plan::sumaInteresesCobrados)
                .mapToDouble(v -> v)
                .average()
                .orElse(0);
    }
}
