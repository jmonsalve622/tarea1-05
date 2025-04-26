public class PagoInsuficienteException extends RuntimeException {
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
}