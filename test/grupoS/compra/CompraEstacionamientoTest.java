package grupoS.compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.puntoDeVenta.PuntoDeVenta;

class CompraEstacionamientoTest {

    private CompraEstacionamiento compraEstacionamiento;
    private PuntoDeVenta pdv;

    @BeforeEach
    void setUp() {
        pdv = mock(PuntoDeVenta.class);
        compraEstacionamiento = new CompraEstacionamiento (1, pdv, LocalDate.of(2024,12,13), LocalTime.of(14,00), 3);
    }

    @Test 
    void cuandoSeLePreguntaAUnaCompraSuPuntoDeVenta_SeraPdv() {
        assertEquals(compraEstacionamiento.getPuntoDeVenta(), pdv);
    }

    @Test
    void cuandoSeLePreguntaAUnaCompraDeEstacionamientoSuCantidadDeHoras_Sera3() {
        assertEquals(compraEstacionamiento.getCantidadDeHoras(), 3);
    }

    

}

