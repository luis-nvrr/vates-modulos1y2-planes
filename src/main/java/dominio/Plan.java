package dominio;

import java.util.HashMap;
import java.util.Map;

public class Plan {
    private int id;
    private final String nombre;
    private final float total;
    private final int cuotas;
    private final Map<Integer, Pago> pagos;
    private final int ID_INCIAL_PAGOS = 1;

    public Plan(String nombre, float total, int cuotas) {
        this.nombre = nombre;
        this.total = total;
        this.cuotas = cuotas;
        this.pagos = new HashMap<>();
    }

    public float getTotal() {
        return total;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void agregarPago(Pago pago) {
        validarPago(pago);
        pago.setId(calcularIdDePago());
        this.pagos.put(pago.getId(), pago);
    }

    public float calcularVuelto(Pago pago) {
        float vuelto = pago.getImporte() - (pago.getInteresesAdicionales()+this.calcularMontoDeCuota());
        return vuelto > 0 ? vuelto : 0;
    }

    private void validarPago(Pago pago) {
      if (!pago.tieneImporteMayorOIgualAlTotal(this.calcularMontoDeCuota()))
          throw new RuntimeException("El pago no puede ser menor que la cuota más intereses, el total es: " + total);

      if (pago.getDemora() < 0 || pago.getImporte() <0 || pago.getInteresesAdicionales() < 0)
          throw new RuntimeException("Los datos negativos son inválidos");
    }

    public void setId(int id ) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    private int calcularIdDePago() {
        return this.pagos.size()+ID_INCIAL_PAGOS;
    }

    private float calcularMontoDeCuota() {
        return this.total / this.cuotas;
    }

    public boolean estaPagadoTotalmente() {
        return this.pagos.size() == this.cuotas;
    }

    public float calcularDeuda() {
        int cuotasRestantes = this.cuotas - this.pagos.size();
        return cuotasRestantes * this.calcularMontoDeCuota();
    }

    public boolean esDeContribuyente(String nombre) {
        return this.nombre.equals(nombre);
    }

    public String listadoPagos() {
        return this.pagos.values().stream()
                .map(Pago::toString)
                .reduce("", (a,b) -> a+"\n"+b);
    }

    public float sumaInteresesCobrados() {
        return (float) this.pagos.values().stream()
                .mapToDouble(Pago::getInteresesAdicionales)
                .sum();
    }

    @Override
    public String toString() {
        return "\n* Plan" +
                "(id=" + id + ")" +
                "\n\t-nombre: '" + nombre + '\'' +
                "\n\t-total: " + total +
                "\n\t-cuotas: " + cuotas +
                "\n\t-pagos: " + pagos;
    }
}
