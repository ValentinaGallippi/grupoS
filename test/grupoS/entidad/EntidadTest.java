package grupoS.entidad;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntidadTest {
	
	private Entidad entidad;
	
	@BeforeEach
	void setUp() throws Exception {
		entidad = mock(Entidad.class);
	}

	@Test
	void updateNoHaceNada() {
		assertDoesNotThrow(() -> entidad.update());
	}

}
