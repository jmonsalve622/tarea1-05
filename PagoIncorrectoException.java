public class PagoIncorrectoException extends RuntimeException {
    public PagoIncorrectoException(String errorMessage) {
        super(errorMessage);
    }
}