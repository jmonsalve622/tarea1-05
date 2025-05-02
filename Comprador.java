public class Comprador {
  private String sonido;
  private int vuelto;

  public Comprador(Moneda m, Seleccion select, Expendedor e) {
    Producto p = e.comprarProducto(m, select);
    sonido = p.consumir();
    vuelto = 0;
    while (e.hayVuelto()) {
        vuelto += e.getVuelto().getValor();
    }
  }
  public int cuantoVuelto() {
      return vuelto;
  }

  public String queCompraste() {
      return sonido;
  }
}
