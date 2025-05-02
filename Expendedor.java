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
            throw new PagoIncorrectoException();
        }

        switch (select) {
            case COCASELECCION:
                if (coca.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.COCAPRECIO.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.COCAPRECIO.getPrecio()) {
                    int vuelto = m.getValor() - Precios.COCAPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return coca.get();
            case SPRITESELECCION:
                if (sprite.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SPRITEPRECIO.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SPRITEPRECIO.getPrecio()) {
                    int vuelto = m.getValor() - Precios.SPRITEPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return sprite.get();
            case FANTASELECCION:
                if (fanta.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.FANTAPRECIO.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.FANTAPRECIO.getPrecio()) {
                    int vuelto = m.getValor() - Precios.FANTAPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return fanta.get();
            case SNICKERSSELECCION:
                if (snickers.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SNICKERSPRECIO.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SNICKERSPRECIO.getPrecio()) {
                    int vuelto = m.getValor() - Precios.SNICKERSPRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return snickers.get();
            case SUPER8SELECCION:
                if (super8.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException();
                }
                if (m.getValor() < Precios.SUPER8PRECIO.getPrecio()) {
                    monVu.add(m);
                    throw new PagoInsuficienteException();
                }
                if (m.getValor() > Precios.SUPER8PRECIO.getPrecio()) {
                    int vuelto = m.getValor() - Precios.SUPER8PRECIO.getPrecio();
                    for (int i = 0; i < vuelto/100; i++) {
                        monVu.add(new Moneda100());
                    }
                }
                return super8.get();
            default:
                monVu.add(m);
                throw new SeleccionFueraDeRangoException();
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

    public boolean hayVuelto() {
        if (!monVu.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
