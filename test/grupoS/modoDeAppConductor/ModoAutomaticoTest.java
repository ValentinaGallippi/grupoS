package grupoS.modoDeAppConductor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;

class ModoAutomaticoTest {
	
	private ModoAutomatico modoAutomatico;
	private Asistencia asistencia;
	private AppConductor appConductor;
	
	@BeforeEach
	void setUp() {
		
		modoAutomatico = new ModoAutomatico();
		asistencia = mock(Asistencia.class);
		appConductor = mock(AppConductor.class);
		
	}
	
	
	@Test
	void cuandoSeLePreguntaAUnModoAutomaticoSiEsAutomatico_RetornaTrue() {

	assertTrue(modoAutomatico.esModoAutomatico());	
	
	}
	
	@Test 
	void alModoAutomatico_SeLeCambiaLaAsistencia() {
		
		when(asistencia.esDesactivada()).thenReturn(false);
		modoAutomatico.cambiarAsistencia(asistencia, appConductor);
		verify(appConductor).setAsistencia(asistencia);
		
	}
	
	@Test
    void notificarFinEstacionamiento_DebeFinalizarElEstacionamiento() {
		
        modoAutomatico.notificarFinEstacionamiento(appConductor);
        verify(appConductor).finalizarEstacionamiento();
    }

    @Test
    void notificarInicioEstacionamiento_DebeIniciarElEstacionamientoConLaPatenteCorrecta() {
        when(appConductor.getPatente()).thenReturn("ABC123");
        modoAutomatico.notificarInicioEstacionamiento(appConductor);

        verify(appConductor).iniciarEstacionamiento("ABC123");
    }
	

}
