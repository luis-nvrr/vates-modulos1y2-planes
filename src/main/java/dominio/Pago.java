package dominio;

public class Pago {
    private int id;
    private final int demora;
    private final float importe;
    private final float interesesAdicionales;

    public Pago(int demora, float importe) {
        this.demora = demora;
        this.importe = importe;
        this.interesesAdicionales = 0.5f * demora;
    }

    public void setId(int id ) {
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public float getImporte() {
        return importe;
    }

    public int getDemora() {
        return demora;
    }

    public float calcularTotalConIntereses(float montoCuota) {
        return montoCuota * (1f + this.interesesAdicionales);
    }

    public float getInteresesAdicionales() {
        return interesesAdicionales;
    }

    public boolean tieneImporteMayorOIgualAlTotal(float cuota) {
        return this.importe >= this.calcularTotalConIntereses(cuota);
    }

    @Override
    public String toString() {
        return "\n>>> Pago " +
                "(id=" + id + ")" +
                "\n\t-demora: " + demora +
                "\n\t-importe: " + importe +
                "\n\t-interesesAdicionales: " + interesesAdicionales;
    }
}
