public class PagoInsuficienteException extends RuntimeException {
    public PagoInsuficienteException() {
        super("El valor de la moneda ingresada es menor al valor del producto seleccionado");
    }
}
