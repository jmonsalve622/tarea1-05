import java.util.ArrayList;
import java.util.Collections;

public class Main1{
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(2);
        Moneda m=null;
        Comprador c=null;
        ArrayList<Moneda> ps = new ArrayList<>();
        Seleccion s = Seleccion.COCASELECCION;

        m = new Moneda1000();
        ps.add(m);                              //Comprar CocaCola con 1000 pesos
        c = new Comprador(m,s,exp);
        System.out.println(c.queCompraste()+", "+c.cuantoVuelto());

        s = Seleccion.FANTASELECCION;
        m = new Moneda1000();
        ps.add(m);                               //Comprar Fanta con 1000 pesos
        c = new Comprador(m,s,exp);
        System.out.println(c.queCompraste()+", "+c.cuantoVuelto());

        s = Seleccion.SPRITESELECCION;
        m = new Moneda1000();
        ps.add(m);                               //Comprar Sprite con 1000 pesos
        c = new Comprador(m,s,exp);
        System.out.println(c.queCompraste()+", "+c.cuantoVuelto());

        s = Seleccion.SNICKERSSELECCION;
        m = new Moneda1000();
        ps.add(m);                               //Comprar Snickers con 1000 pesos
        c = new Comprador(m,s,exp);
        System.out.println(c.queCompraste()+", "+c.cuantoVuelto());

        s = Seleccion.SUPER8SELECCION;
        m = new Moneda500();
        ps.add(m);                               //Comprar Super8 con 500 pesos
        c = new Comprador(m,s,exp);
        System.out.println(c.queCompraste()+", "+c.cuantoVuelto());


        //este codigo es para probar excepcion "PagoIncorrectoexcepcion"
        //m = null;
        //ps.add(m);
        //c = new Comprador(m,s,exp);
        //System.out.println(c.queCompraste()+", "+c.cuantoVuelto());



        //este codigo es para probar la excepcion "PagoInsuficienteException"
        //m = new Moneda100();
        //ps.add(m);
        //c = new Comprador(m,s,exp);
        //System.out.println(c.queCompraste()+", "+c.cuantoVuelto());



        //El deposito de CocaCola tiene 2 bebidad para ofrecer, este es el segundo que da para que la siguiente vez que pida Coca, ya no haya
        //s = new Seleccion.COCASELECCION;
        //m = new Moneda1000();
        //ps.add(m);
        //c = new Comprador(m,s,exp);
        //System.out.println(c.queCompraste()+", "+c.cuantoVuelto());

        //este codigo es para probar la excepcion "NoHayProductoException"
        //m = new Moneda1000();
        //ps.add(m);
        //c = new Comprador(m,s,exp);
        //System.out.println(c.queCompraste()+", "+c.cuantoVuelto());


        System.out.println(ps);

        Collections.sort(ps);
        System.out.println(ps);

        Collections.reverse(ps);
        System.out.println(ps);
    }
}
