public class Comprador {
  private String sonido;
  private int vuelto;

  public Comprador(Moneda m, Seleccion select, Expendedor e) {
    Producto p = e.comprarProducto(m, select);
    sonido = p.consumir();
    //Agregar el calculo del vuelto
  }
  public int cuantoVuelto() {
      return vuelto;
  }

  public String queCompraste() {
      return sonido;
  }
}
