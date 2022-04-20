package utils;

public class FormateadorDeString {

    public static String formatearTituloDeMenu(String titulo) {
        return FormateadorDeString.formatearConSimbolo("-", 20, titulo);
    }
    public static String formatearTituloDeSubmenu(String titulo) {
        return FormateadorDeString.formatearConSimbolo("*", 10, titulo);
    }
    public static String formatearResultado(String mensaje) {
        return FormateadorDeString.formatearConSimbolo("=", 10, mensaje);
    }
    public static String formatearOpcion(int numero, String descripcion) {
        return String.format("%d - %s", numero, descripcion);
    }
    public static String formatearError(String mensaje) {
        return FormateadorDeString.formatearConSimbolo("x", 10, mensaje);
    }

    private static String formatearConSimbolo(String simbolo, int cantidad, String mensaje) {
        return String.format("%n%s %s %s",simbolo.repeat(cantidad), mensaje, simbolo.repeat(cantidad));
    }

    public static String formatearPasoSimulacion(String descricion) {
        return FormateadorDeString.formatearConSimbolo(":", 10, descricion);
    }
}
