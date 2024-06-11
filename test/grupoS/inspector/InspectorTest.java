package grupoS.inspector;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InspectorTest {
	
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		inspector = new Inspector(120);
	}

	@Test
	void cuandoUnInspectorEsCreado_ElLegajoQueSeLeVayaAOtorgarSeraSuLegajoParaSiempre() {
		assertEquals(inspector.getLegajo(), 120);
	}

}
