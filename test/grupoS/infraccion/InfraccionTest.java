package grupoS.infraccion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.inspector.Inspector;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

class InfraccionTest {
	
	private Infraccion infraccion;
	private ZonaDeEstacionamientoMedido zona;
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		this.zona = mock(ZonaDeEstacionamientoMedido.class);
		this.inspector = mock(Inspector.class);
		this.infraccion = new Infraccion(LocalDate.of(2024,2,1), LocalTime.of(07, 00), inspector, zona); 
	}

	@Test
	void cuandoUnaInfraccionSeCreaConDeterminadaFecha_EsaFechaSeraLaQueQuedaraGuardadaEnLaInfraccion() {
		assertEquals(this.infraccion.getFecha(), LocalDate.of(2024,2,1));
	}
	
	@Test
	void cuandoUnaInfraccionSeCreaConDeterminadaHora_EsaHoraSeraLaQueQuedaraGuardadaEnLaInfraccion() {
		assertEquals(this.infraccion.getHora(), LocalTime.of(07, 00));
	}
	
	@Test
	void cuandoUnaInfraccionSeCreaConUnDeterminadoInspector_EseInspectorSeraElQueQuedaraGuardadoEnLaInfraccion() {
		assertEquals(this.infraccion.getInspector(), inspector);
	}

	@Test
	void cuandoUnaInfraccionSeCreaConUnaDeterminadaZona_EsaZonaSeraElQueQuedaraGuardadaEnLaInfraccion() {
		assertEquals(this.infraccion.getZona(), zona);
	}
}
