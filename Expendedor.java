public class Expendedor {
    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Snickers> snickers;
    private Deposito<Super8> super8;
    private Deposito<Moneda> monVu;

    public Expendedor(int n) {
        coca = new Deposito<CocaCola>(); //Se crea el deposito de CocaCola
        for (int i = 0; i < n; i++) { // Se añaden n CocaCola al deposito
            coca.add(new CocaCola(i + 100)); 
        }
        sprite = new Deposito<Sprite>(); //Se crea el deposito de Sprite
        for (int i = 0; i < n; i++) { //Se añaden n Sprite al deposito
            sprite.add(new Sprite(i + 200));
        }
        fanta = new Deposito<Fanta>(); //Se crea el deposito de Fanta
        for (int i = 0; i < n; i++) { //Se añaden n Fanta al deposito
            fanta.add(new Fanta(i + 300));
        }
        snickers = new Deposito<Snickers>(); //Se crea el deposito de Snickers
        for (int i = 0; i < n; i++) { //Se añaden n Snickers al deposito
            snickers.add(new Snickers(i + 400));
        }
        super8 = new Deposito<Super8>(); //Se crea el deposito de Super8
        for (int i = 0; i < n; i++) { //Se añaden n Super8 al deposito
            super8.add(new Super8(i + 500));
        }
        monVu = new Deposito<Moneda>(); //Se crea el deposito de Moneda
    }

    public Producto comprarProducto(Moneda m, Seleccion select) throws RuntimeException {
        if (m == null) { //Si la moneda es un null tira exception
            throw new PagoIncorrectoException();
        }

        switch (select) {
            case COCASELECCION:
                if (coca.empty()) { //Exception si el deposito esta vacío
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.COCAPRECIO.getPrecio()) { //Exception si el valor de la moneda es menor a el valor del producto
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.COCAPRECIO.getPrecio()) { //Adición de las monedas de 100 del vuelto al depositp de monedas
                    int vuelto = m.getValor() - Precios.COCAPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                } 
                return coca.get(); //Retorno del producto
            case SPRITESELECCION:
                if (sprite.empty()) { //Exception si el deposito esta vacío
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SPRITEPRECIO.getPrecio()) { //Exception si el valor de la moneda es menor a el valor del producto
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SPRITEPRECIO.getPrecio()) { //Adición de las monedas de 100 del vuelto al depositp de monedas
                    int vuelto = m.getValor() - Precios.SPRITEPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return sprite.get(); //Retorno del producto
            case FANTASELECCION:
                if (fanta.empty()) { //Exception si el deposito esta vacío
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.FANTAPRECIO.getPrecio()) { //Exception si el valor de la moneda es menor a el valor del producto
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.FANTAPRECIO.getPrecio()) { //Adición de las monedas de 100 del vuelto al depositp de monedas
                    int vuelto = m.getValor() - Precios.FANTAPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return fanta.get(); //Retorno del producto
            case SNICKERSSELECCION:
                if (snickers.empty()) { //Exception si el deposito esta vacío
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SNICKERSPRECIO.getPrecio()) { //Exception si el valor de la moneda es menor a el valor del producto
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SNICKERSPRECIO.getPrecio()) { //Adición de las monedas de 100 del vuelto al depositp de monedas
                    int vuelto = m.getValor() - Precios.SNICKERSPRECIO.getPrecio(); 
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return snickers.get(); //Retorno del producto
            case SUPER8SELECCION:
                if (super8.empty()) { //Exception si el deposito esta vacío
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SUPER8PRECIO.getPrecio()) { //Exception si el valor de la moneda es menor a el valor del producto
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SUPER8PRECIO.getPrecio()) { //Adición de las monedas de 100 del vuelto al depositp de monedas
                    int vuelto = m.getValor() - Precios.SUPER8PRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return super8.get(); //Retorno del producto
            default:
                monVu.add(m); //Este default ocurre cuando se selecciona un producto que no existe
                throw new SeleccionFueraDeRangoException();
        }
    }

    public Moneda getVuelto() { //Metodo que devuelve una sola moneda del deposito monVu
        if (!monVu.empty()) {
            return monVu.get();
        }
        else {
            return null;
        }
    }

    public boolean hayVuelto() { //Metodo que retorna true si quedan monedas en el deposito y false si no
        if (!monVu.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
