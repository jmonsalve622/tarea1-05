abstract public class Producto {
    private int serie;
    public Producto(int s) {
        serie = s;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String consumir();
}
