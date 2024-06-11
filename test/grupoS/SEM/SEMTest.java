package grupoS.SEM;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.puntoDeVenta.PuntoDeVenta;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;



class SEMTest {
	
	private SEM sem;
	private ZonaDeEstacionamientoMedido zona;
	private PuntoDeVenta pdv;
	
	@BeforeEach
	void setUp() throws Exception {
		
		sem = new SEM(LocalTime.of(07, 00), LocalTime.of(20, 00), 40);
		zona = mock(ZonaDeEstacionamientoMedido.class);
		pdv = mock(PuntoDeVenta.class);
	}

	@Test
	void cuandoSeRegistraUnaZonaDeEstacionamientoMedidoEnUnSEM_EstaPasaAFormarParteDeLasZonasDelSEM() {
		sem.registrarZona(zona);
		
		assertTrue(sem.getZonas().contains(zona));
	}
	
	
}