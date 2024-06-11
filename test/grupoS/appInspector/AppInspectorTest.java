package grupoS.appInspector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import grupoS.SEM.SEM;
import grupoS.compra.Compra;
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
		app.realizarInfraccion("123as");
		
		ArgumentCaptor<Infraccion> estadoCaptor = ArgumentCaptor.forClass(Infraccion.class);
		verify(this.sem, times(1)).registrarInfraccion(estadoCaptor.capture());
        assertTrue(estadoCaptor.getValue() instanceof Infraccion, "Error test. No se obtuvo una instancia de Infraccion en registrarInfraccion() del SEM");
	}

}
