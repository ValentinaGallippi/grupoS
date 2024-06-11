package grupoS.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import grupoS.SEM.SEM;
import grupoS.compra.Compra;
import grupoS.estacionamiento.Estacionamiento;

class PuntoDeVentaTest {
	private PuntoDeVenta pdv;
	private SEM sem;
	
	@BeforeEach
	void setUp() throws Exception {

		this.sem = mock(SEM.class);
		this.pdv = new PuntoDeVenta(sem);
		

		sem = mock(SEM.class);
		pdv = new PuntoDeVenta(sem);
		when(sem.getTicketsEmitidos()).thenReturn(0);

	}

	@Test
	void cuandoSeIniciaUnEstacionamientoPuntual_EseEstacionamientoSeRegistraraEnElSEM() {

		this.pdv.realizarEstacionamiento("AC 123 FP", 3);
		
		verify(this.sem).actualizarTicketsEmitidos();
		ArgumentCaptor<Compra> estadoCaptor = ArgumentCaptor.forClass(Compra.class);
		verify(this.sem, times(1)).registrarCompra(estadoCaptor.capture());
        assertTrue(estadoCaptor.getValue() instanceof Compra, "Error test. No se obtuvo una instancia de compra en registrarCompra() del SEM");
        ArgumentCaptor<Estacionamiento> estadoCaptor2 = ArgumentCaptor.forClass(Estacionamiento.class);
		verify(this.sem, times(1)).registrarEstacionamiento(estadoCaptor2.capture());
        assertTrue(estadoCaptor2.getValue() instanceof Estacionamiento, "Error test. No se obtuvo una instancia de estacionamiento en registrarEstacionamiento() del SEM");
	}
	
	@Test
	void cuandoSeHaceUnaCargaDeCreditoEnUnPuntoDeVenta_SeRegistraEsaCompraEnElSEM() {
		pdv.cargarCredito(1154887656, 1500);
		
		verify(sem).registrarCreditoDisponible(1154887656, 1500);
		verify(sem).actualizarTicketsEmitidos();
		ArgumentCaptor<Compra> estadoCaptor = ArgumentCaptor.forClass(Compra.class);
		verify(this.sem, times(1)).registrarCompra(estadoCaptor.capture());
        assertTrue(estadoCaptor.getValue() instanceof Compra, "Error test. No se obtuvo una instancia de compra en registrarCompra() del SEM");
	}
	
	@Test
	void cuandoUnPuntoDeVentaSeCreaConUnSem_EseSemSeraElQueEstaraConectadoAEsePuntoDeVenta() {
		assertEquals(this.pdv.getSem(),sem);
	}
}
