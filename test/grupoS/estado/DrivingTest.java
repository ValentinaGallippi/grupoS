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

class DrivingTest {
	private AppConductor app;
	private Driving estado;
	private Asistencia asistencia;
	
	@BeforeEach
	void setUp() throws Exception {
		app = mock(AppConductor.class);
		estado = new Driving();
		asistencia = mock(Asistencia.class);  
	}
	

	@Test
	void cuandoManejandoRecibeManejando_NoHaraNada() {
		verifyNoInteractions(app);
	}
	
	@Test
	void cuandoManejandoRecibeCaminandoYNoHayUnEstacionamientoVigenteEnElMismoPuntoGeografico_CambiaElEstadoYLaAsistenciaRecibeUnaAlerta() {
		when(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()).thenReturn(false);
		when(app.getModoAsistencia()).thenReturn(asistencia);
		
		estado.caminando(app);
		
		verify(app).tieneEstacionamientoVigenteEnMismoPuntoGeografico();
		verify(app).cambiarModoACaminando();
		verify(asistencia).recibirAlertaCaminando(app);
	}
	
	@Test
	void cuandoManejandoRecibeCaminandoYHayUnEstacionamientoVigenteEnElMismoPuntoGeografico_NoHaceNada() {
		when(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()).thenReturn(true);
		
		estado.caminando(app);
		
		verify(app).tieneEstacionamientoVigenteEnMismoPuntoGeografico();
		verifyNoMoreInteractions(app);
		
	}
	
	@Test
    void manejando_NoDebeLanzarExcepciones() {
        // Probamos que el método no lance excepciones cuando se llama
        assertDoesNotThrow(() -> estado.manejando(app));
    }

}
