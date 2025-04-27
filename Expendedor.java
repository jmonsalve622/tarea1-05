public class Expendedor {
    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Snickers> snickers;
    private Deposito<Super8> super8;
    private Deposito<Moneda> monVu;

    public Expendedor(int n) {
        coca = new Deposito<CocaCola>();
        for (int i = 0; i < n; i++) {
            coca.add(new CocaCola(i + 100));
        }
        sprite = new Deposito<Sprite>();
        for (int i = 0; i < n; i++) {
            sprite.add(new Sprite(i + 200));
        }
        fanta = new Deposito<Fanta>();
        for (int i = 0; i < n; i++) {
            fanta.add(new Fanta(i + 300));
        }
        snickers = new Deposito<Snickers>();
        for (int i = 0; i < n; i++) {
            snickers.add(new Snickers(i + 400));
        }
        super8 = new Deposito<Super8>();
        for (int i = 0; i < n; i++) {
            super8.add(new Super8(i + 500));
        }
        monVu = new Deposito<Moneda>();
    }

    public Producto comprarProducto(Moneda m, Seleccion select) throws RuntimeException {
        if (m == null) {
            throw new PagoIncorrectoException("");
        }
        switch (select) {
            case COCASELECCION:
                if (coca.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                Precios precio1 = Precios.COCAPRECIO;
                if (m.getValor() < precio1.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException("");
                }
                if (m.getValor() > precio1.getPrecio()) {
                    int vuelto = m.getValor() - precio1.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return coca.get();
            case SPRITESELECCION:
                if (sprite.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                Precios precio2 = Precios.SPRITEPRECIO;
                if (m.getValor() < precio2.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException("");
                }
                if (m.getValor() > precio2.getPrecio()) {
                    int vuelto = m.getValor() - precio2.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return sprite.get();
            case FANTASELECCION:
                if (fanta.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                Precios precio3 = Precios.FANTAPRECIO;
                if (m.getValor() < precio3.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException("");
                }
                if (m.getValor() > precio3.getPrecio()) {
                    int vuelto = m.getValor() - precio3.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return fanta.get();
            case SNICKERSSELECCION:
                if (snickers.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                Precios precio4 = Precios.SNICKERSPRECIO;
                if (m.getValor() < precio4.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException("");
                }
                if (m.getValor() > precio4.getPrecio()) {
                    int vuelto = m.getValor() - precio4.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return snickers.get();
            case SUPER8SELECCION:
                if (super8.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                Precios precio5 = Precios.SUPER8PRECIO;
                if (m.getValor() < precio5.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException("");
                }
                if (m.getValor() > precio5.getPrecio()) {
                    int vuelto = m.getValor() - precio5.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return super8.get();
            default:
                monVu.add(m);
                throw new SeleccionFueraDeRangoException("");
        }
    }

    public Moneda getVuelto() {
        if (!monVu.empty()) {
            return monVu.get();
        }
        else {
            return null;
        }
    }
}
