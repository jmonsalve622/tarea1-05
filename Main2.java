import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese la cantidad inicial de productos: ");
        int productN = input.nextInt();

        Expendedor e = new Expendedor(productN);
        Comprador c;

        System.out.print("¿Desea comprar? (true/false): ");
        boolean operation = input.nextBoolean();
        int valorMoneda;
        Moneda m;
        int selectN;
        Seleccion select;

        while (operation) {
            System.out.print("¿Que moneda posee? (100/500/1000): ");
            valorMoneda = input.nextInt();
            switch (valorMoneda) {
                case 100:
                    m = new Moneda100();
                    break;
                case 500:
                    m = new Moneda500();
                    break;
                case 1000:
                    m = new Moneda1000();
                    break;
                default:
                    m = null;
                    System.out.println("No está dentro de las opciones");
                    break;
            }

            System.out.print("¿Que producto selecciona? (1/2/3/4/5): ");
            selectN = input.nextInt();
            switch (selectN) {
                case 1:
                    select = Seleccion.COCASELECCION;
                    break;
                case 2:
                    select = Seleccion.SPRITESELECCION;
                    break;
                case 3:
                    select = Seleccion.FANTASELECCION;
                    break;
                case 4:
                    select = Seleccion.SNICKERSSELECCION;
                    break;
                case 5:
                    select = Seleccion.SUPER8SELECCION;
                    break;
                default:
                    select = null;
                    System.out.println("No está dentro de las opciones");
                    break;
            }
            c = new Comprador(m, select, e);
            System.out.println("Su compra a sido exitosa: " + c.queCompraste() + ". Vuelto: $" + c.cuantoVuelto());
            System.out.print("¿Desea comprar? (true/false): ");
            operation = input.nextBoolean();
        }
        System.out.println("Se acabo el programa");
    }
}