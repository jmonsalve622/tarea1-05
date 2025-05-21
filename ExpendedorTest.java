import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorSimpleTest {
    private Expendedor expendedorSimple;
    @BeforeEach
    void setUp() {
        expendedorSimple = new Expendedor(3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test Una Bebida")
    public void testComprarUnProducto() throws Exception {
        Seleccion s = Seleccion.COCASELECCION;
        Moneda pago = new Moneda1000();
        System.out.println("comprarUnaBebida");
        assertNotNull(expendedorSimple.comprarProducto(pago, s));

    }

    @Test
    @DisplayName("Test Tres Bebida")
    public void testComprarTresProductos() throws Exception {
        Seleccion s = Seleccion.COCASELECCION;
        Moneda pago = new Moneda1000();
        assertNotNull(expendedorSimple.comprarProducto(pago, s));
        assertNotNull(expendedorSimple.comprarProducto(pago, s));
        assertNotNull(expendedorSimple.comprarProducto(pago, s));
    }

    @Test
    @DisplayName("Test NoHayBebidaException")
    public void testComprarCuatroProductos(){
        Seleccion s = Seleccion.COCASELECCION;
        Moneda pago = new Moneda1000();
        Exception exception = assertThrows(NoHayProductoException.class,()->{
            expendedorSimple.comprarProducto(pago, s);
            expendedorSimple.comprarProducto(pago, s);
            expendedorSimple.comprarProducto(pago, s);
            expendedorSimple.comprarProducto(pago, s);
        });
    }

    @Test
    @DisplayName("Test PagoInsuficienteException")
    public void testComprarProductoSinSuficienteMoneda(){
        Seleccion s = Seleccion.COCASELECCION;
        Moneda pago = new Moneda100();
        Exception exception = assertThrows(PagoInsuficienteException.class,
                ()->{
                    expendedorSimple.comprarProducto(pago, s);
                });
    }
}
