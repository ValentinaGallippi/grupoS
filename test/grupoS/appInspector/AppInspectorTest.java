package grupoS.appInspector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import grupoS.SEM.SEM;
import grupoS.infraccion.Infraccion;
import grupoS.inspector.Inspector;

class AppInspectorTest {
	
	private AppInspector app;
	private SEM sem;
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEM.class);
		inspector = mock(Inspector.class);
		app = new AppInspector(sem, inspector);
	}

	@Test
	void cuandoSeConsultaPorUnaPatente_ElSEMSeFijaSiEstaVigente(){
		app.consultarVigenciaDeEstacionamiento("123as");
		
		verify(sem).estaVigente("123as");
	}
	
	@Test
	void cuandoSeHaceUnaInfraccion_LaMismaSeRegistaEnElSEM() {
		when(sem.estaVigente("123as")).thenReturn(false);
		app.realizarInfraccion("123as");
		
		ArgumentCaptor<Infraccion> estadoCaptor = ArgumentCaptor.forClass(Infraccion.class);
		verify(this.sem).registrarInfraccion(estadoCaptor.capture());
	}

	@Test
    void realizarInfraccion_DebeRegistrarUnaInfraccionSiElEstacionamientoNoEstaVigente() {
        when(sem.estaVigente("ABC123")).thenReturn(false);

        app.realizarInfraccion("ABC123");

        verify(sem).estaVigente("ABC123");
        ArgumentCaptor<Infraccion> estadoCaptor = ArgumentCaptor.forClass(Infraccion.class);
        verify(this.sem, times(1)).registrarInfraccion(estadoCaptor.capture());
        assertTrue(estadoCaptor.getValue() instanceof Infraccion, "Error test. No se obtuvo una instancia de Infraccion en registrarInfraccion() del SEM");
    }

    @Test
    void realizarInfraccion_NoDebeRegistrarUnaInfraccionSiElEstacionamientoEstaVigente() {
        when(sem.estaVigente("ABC123")).thenReturn(true);

        app.realizarInfraccion("ABC123");

        verify(sem).estaVigente("ABC123");
        verify(sem, never()).registrarInfraccion(any(Infraccion.class));
    }
}
