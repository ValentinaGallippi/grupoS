package grupoS.compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.puntoDeVenta.PuntoDeVenta;

class CompraRecargaCreditoTest {

    private CompraRecargaCredito compraRecargaCredito;
    private PuntoDeVenta pdv;

    @BeforeEach
    void setUp() {
        pdv = mock(PuntoDeVenta.class);
        compraRecargaCredito = new CompraRecargaCredito(1234, pdv, LocalDate.of(2024, 10, 6), LocalTime.of(13,45), 1123456643);
    }

    @Test
    void cuandoSeLePreguntaPorSuCelular_Sera1123456643() {
    	assertEquals(compraRecargaCredito.getCelular(), 1123456643);
    }

} 

