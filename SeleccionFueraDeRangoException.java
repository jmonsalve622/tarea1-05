public class SeleccionFueraDeRangoException extends RuntimeException {
    public SeleccionFueraDeRangoException() {
        super("No existe un producto para el número ingresado");
    }
}
