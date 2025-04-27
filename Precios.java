public enum Precios {
    COCAPRECIO(1000),
    SPRITEPRECIO(1000),
    FANTAPRECIO(1000),
    SNICKERSPRECIO(1000),
    SUPER8PRECIO(500);

    private final int precio;

    Precios(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}