package grupoS.estado;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;

class WalkingTest {

	private AppConductor app;
	private Walking estado;
	private Asistencia asistencia;
	
	@BeforeEach
	void setUp() throws Exception {
		app = mock(AppConductor.class);
		estado = new Walking();
		asistencia = mock(Asistencia.class);  
	}
	

	@Test
	void cuandoCaminandoRecibeCaminando_NoHaraNada() {
		verifyNoInteractions(app);
	}
	
	
	@Test
	void cuandoCaminandoRecibeManejandoYHayUnEstacionamientoVigenteEnElMismoPuntoGeografico_CambiaElEstadoYLaAsistenciaRecibeUnaAlerta() {
		when(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()).thenReturn(true);
		when(app.getModoAsistencia()).thenReturn(asistencia);
		
		estado.manejando(app);
		
		verify(app).tieneEstacionamientoVigenteEnMismoPuntoGeografico();
		verify(app).cambiarModoAManejando();
		verify(asistencia).recibirAlertaManejando(app);
	}
	
	@Test
	void cuandoManejandoRecibeCaminandoYHayUnEstacionamientoVigenteEnElMismoPuntoGeografico_NoHaceNada() {
		when(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()).thenReturn(false);
		
		estado.manejando(app);
		
		verify(app).tieneEstacionamientoVigenteEnMismoPuntoGeografico();
		verifyNoMoreInteractions(app);
		
	}
	
	@Test
    void caminando_NoDebeLanzarExcepciones() {
        // Probamos que el método no lance excepciones cuando se llama
        assertDoesNotThrow(() -> estado.caminando(app));
    }
	

}
