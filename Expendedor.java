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

    public Producto comprarProducto(Moneda m, int select) throws RuntimeException {
        if (m == null) {
            throw new PagoIncorrectoException("");
        }
        //Agregar el exception para cuando el pago es insufiiciente
        switch (select) {
            case 1:
                if (coca.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                //Agregar el vuelto al deposito de monedas
                return coca.get();
            case 2:
                if (sprite.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                //Agregar el vuelto al deposito de monedas
                return sprite.get();
            case 3:
                if (fanta.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                //Agregar el vuelto al deposito de monedas
                return fanta.get();
            case 4:
                if (snickers.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                //Agregar el vuelto al deposito de monedas
                return snickers.get();
            case 5:
                if (super8.empty()) {
                    monVu.add(m);
                    throw new NoHayProductoException("");
                }
                //Agregar el vuelto al deposito de monedas
                return super8.get();
            default:
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
