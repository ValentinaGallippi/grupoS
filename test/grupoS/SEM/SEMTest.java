package grupoS.SEM;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.compra.Compra;
import grupoS.entidad.Entidad;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.infraccion.Infraccion;
import grupoS.puntoDeVenta.PuntoDeVenta;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;



class SEMTest {
	
	private SEM sem;
	private ZonaDeEstacionamientoMedido zona;
	private PuntoDeVenta pdv;
	private Compra compra;
	private Estacionamiento estacionamiento;
	private Infraccion infraccion;
	private Entidad entidad;
	
	@BeforeEach
	void setUp() throws Exception {
		
		sem = new SEM(LocalTime.of(07, 00), LocalTime.of(20, 00), 40);
		zona = mock(ZonaDeEstacionamientoMedido.class);
		pdv = mock(PuntoDeVenta.class);
		compra = mock(Compra.class);
		estacionamiento = mock(Estacionamiento.class);
		entidad = mock(Entidad.class);
	}

	@Test
	void cuandoSeRegistraUnaZonaDeEstacionamientoMedidoEnUnSEM_EstaPasaAFormarParteDeLasZonasDelSEM() {
		sem.registrarZona(zona);
		
		assertTrue(sem.getZonas().contains(zona));
	}
	
	@Test
	void cuandoSeRegistraUnaCompraEnUnSEM_EstaPasaAFormarParteDeLasComprasDelSEM() {
		sem.registrarCompra(compra);
		
		assertTrue(sem.getCompras().contains(compra));
	}
	
	@Test
	void cuandoSeRegistraUnEstacionamientoEnUnSEM_EstePasaAFormarParteDeLosEstacionamientosDelSEM() {
		sem.registrarEstacionamiento(estacionamiento);
		
		assertTrue(sem.getEstacionamientos().contains(estacionamiento));
	}
	
	@Test
	void cuandoSeRegistraUnaInfraccionEnUnSEM_EstaPasaAFormarParteDeLasInfraccionesDelSEM() {
		sem.registrarInfraccion(infraccion);
		
		assertTrue(sem.getInfracciones().contains(infraccion));
	}
	
	@Test
	void cuandoSeSuscribeUnaEntidadEnUnSEM_EstaPasaAFormarParteDeLasEntidadesDelSEM() {
		sem.suscribirEntidad(entidad);
		
		assertTrue(sem.getEntidadesObservadoras().contains(entidad));
	}
	@Test
	void cuandoSeDesuscribeUnaEntidadEnUnSEM_EstaDejaraDeFormarParteDeLasEntidadesDelSEM() {
		sem.suscribirEntidad(entidad);
		sem.desuscribirEntidad(entidad);
		
		assertFalse(sem.getEntidadesObservadoras().contains(entidad));
	}
	
	@Test
	void cuandoSeCreaUnSEMConUnaHoraDeInicio_EsaSeraLaHoraDeInicio() {
		assertEquals(sem.getHoraDeInicio(), LocalTime.of(07, 00));
	}
	
	@Test
	void cuandoSeCreaUnSEMConUnaHoraDeFin_EsaSeraLaHoraDeInicio() {
		assertEquals(sem.getHoraDeCierre(), LocalTime.of(20, 00));
	}
	
	@Test
	void cuandoSeCreaUnSEMConUnPrecio_EsaSeraElPrecioPorHora() {
		assertEquals(sem.getPrecioPorHora(), 40);
	}
	
	@Test
	void cuandoRecienSeCreaUnSEM_NoTendraNingunTicketEmitido() {
		assertEquals(sem.getTicketsEmitidos(), 0);
	}
	
	@Test 
	void cuandoSeLeModificaLaHoraDeInicio_DeCierre_YElPrecioPorHora_EsosSeranLosNuevosDatosDelSEM() {
		sem.setHoraDeInicio(LocalTime.of(9, 00));
		sem.setHoraDeCierre(LocalTime.of(21, 00));
		sem.setPrecioPorHora(400000);
		
		assertEquals(sem.getHoraDeInicio(), LocalTime.of(9, 00));
		assertEquals(sem.getHoraDeCierre(), LocalTime.of(21, 00));
		assertEquals(sem.getPrecioPorHora(), 400000);
	}
	
}