package dominio;

public class Pago {
    private int id;
    private final int demora;
    private final float importe;
    private float interesesAdicionales;

    public Pago(int demora, float importe) {
        this.demora = demora;
        this.importe = importe;
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

    public float calcularInteresesAdicionales(float montoCuota) {
        this.interesesAdicionales = 0.5f * demora * montoCuota;
        return interesesAdicionales;
    }

    public float getInteresesAdicionales() {
        return interesesAdicionales;
    }

    public boolean tieneImporteMayorOIgualAlTotal(float cuota) {
        return this.importe >= (cuota+this.calcularInteresesAdicionales(cuota));
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
