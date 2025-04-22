abstract public class Dulce {
    private int serie;
    public Dulce(int s) {
        serie = s;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String comer();
}