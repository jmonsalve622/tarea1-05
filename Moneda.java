import java.util.Collections;

abstract public class Moneda implements Comparable<Moneda>{
    public Moneda() {}
    public Moneda getSerie() {
        return this;
    }
    public abstract int getValor();

    @Override
    public String toString(){
        return ""+this.getValor;
    }    

    @Override
    public int compareTo(Moneda o){
        if (this.getValor() > o.getValor()) {
            return 1;
        } else if (this.getValor() < o.getValor()) {
            return -1;
        } else {
            return 0;
        }
    }
}


