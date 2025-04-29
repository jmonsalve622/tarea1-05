public class NoHayProductoException extends RuntimeException {
    public NoHayProductoException() {
        super("El deposito del producto solicitado esta vacío");
    }
}
