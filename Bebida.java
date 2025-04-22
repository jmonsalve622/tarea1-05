abstract public class Bebida {
    private int serie;
    public Bebida(int s) {
        serie = s;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber();
}