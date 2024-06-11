package grupoS.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.SEM.SEM;

class PuntoDeVentaTest {
	private PuntoDeVenta pdv;
	private SEM sem;
	
	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEM.class);
		pdv = new PuntoDeVenta(sem);
		when(sem.getTicketsEmitidos()).thenReturn(0);
	}

	@Test
	void cuandoSeIniciaUnEstacionamientoPuntual_EseEstacionamientoSeRegistraraEnElSEM() {
		pdv.realizarEstacionamiento("AC 123 FP", 3);
		
		verify(sem).actualizarTicketsEmitidos();
		verify(sem).registrarCompra(null);
		verify(sem).registrarEstacionamiento(null);
		
	}
	
	@Test
	void cuandoSeHaceUnaCargaDeCreditoEnUnPuntoDeVenta_SeRegistraEsaCompraEnElSEM() {
		pdv.cargarCredito(1154887656, 1500);
		
		
		
		verify(sem).registrarCreditoDisponible(1154887656, 1500);
		verify(sem).actualizarTicketsEmitidos();
		verify(sem).registrarCompra(null);
		
	}
	

}
