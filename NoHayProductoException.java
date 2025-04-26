public class NoHayProductoException extends RuntimeException {
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);
    }
}