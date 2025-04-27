public class Moneda100 extends Moneda implements Comparable<Moneda> {
    public Moneda100() {
        super();
    }
    public int getValor() {
        return 100;
    }

    public int compareTo(Moneda o){
        if (this.getValor() > o.getValor()) {
            return 1;
        } else if (this.getValor() < o.getValor()) {
            return -1;
        } else {
            return 0;
        }
    }


