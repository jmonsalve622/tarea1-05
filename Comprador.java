public class Comprador {
  private String sonido;
  private int vuelto;

  public Comprador(Moneda m, Seleccion select, Expendedor e) {
    Producto p = e.comprarProducto(m, select);
    if (m.getValor() == select.getPrecio())
      




    
    vuelto=0;
      Moneda v;
      while((v= ex.getVuelto()) != null){
          vuelto += ex.getVuelto;
      }
  }
  public int cuantoVuelto() {
      return vuelto;
  }

  public String queCompraste() {
      return sonido;
  }
}
