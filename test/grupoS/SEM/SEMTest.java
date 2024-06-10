package grupoS.SEM;

public class SEMTest {
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

class SEMTest {
	
	private SEM sem;
	private ZonaDeEstacionamientoMedido zona;
	
	@BeforeEach
	void setUp() throws Exception {
		
		sem = new SEM(LocalTime.of(07, 00), LocalTime.of(20, 00), 40);
		zona = mock(ZonaDeEstacionamientoMedido.class);
	}

	@Test
	void cuandoSeRegistraUnaZonaDeEstacionamientoMedidoEnUnSEM_EstaPasaAFormarParteDeLasZonasDelSEM() {
		sem.registrarZona(zona);
		
		assertTrue(sem.getZonas().contains(zona));
	}

}