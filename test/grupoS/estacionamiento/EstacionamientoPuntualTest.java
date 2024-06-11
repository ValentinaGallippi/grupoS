package grupoS.estacionamiento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.compra.CompraEstacionamiento;

class EstacionamientoPuntualTest {

    private EstacionamientoPuntual estacionamientoPuntual;
    private CompraEstacionamiento ticket;

    @BeforeEach
    void setUp() {
        ticket = mock(CompraEstacionamiento.class);
        estacionamientoPuntual = new EstacionamientoPuntual("TAY 013", LocalTime.of(15,30), LocalTime.of(19,13), ticket, 3);
     }

    @Test 
    void cuandoSeLePreguntaAUnEstacionamientoSuCantidadDeHoras_Devuelve3() {
    	assertEquals(estacionamientoPuntual.getCantidadDeHoras(), 3);
    }

    @Test 
    void cuandoSeLePreguntaAUnEstacionamientoSiNoEsDeApp_RetornaTrue() {
        assertFalse(estacionamientoPuntual.esDeApp());
    }

    @Test 
    void cuandoSeLePreguntaAUnEstacionamientoSuPatente_SeraTAY013() {
        assertEquals(estacionamientoPuntual.getPatente(), "TAY 013");
    }

    @Test
    void cuandoSeLePreguntaAUnEstacionamientoSuHoraDeInicio_Sera1530() { 
        assertEquals(estacionamientoPuntual.getHoraDeInicio(), LocalTime.of(15,30));
    }
    
    @Test
     void cuandoSeLePreguntaAUnEstacionamientoSuHoraDeFin_Sera1913() { 
        assertEquals(estacionamientoPuntual.getHoraDeFin(), LocalTime.of(19,13));
    }

    @Test 
    void cuandoSeLePreguntaAunEstacionamientoSiEstaVigente_DevuelveTrue() {
        assertTrue(estacionamientoPuntual.estaVigente());
    }

    @Test 
    void cuandoSeLePreguntaAUnEstacionamientoPorSuTicket_SeraTicket() {
    	assertEquals(estacionamientoPuntual.getTicket(), ticket);
    }
}