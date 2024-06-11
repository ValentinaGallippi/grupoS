package grupoS.compra;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.puntoDeVenta.PuntoDeVenta;

class CompraTest {
	private Compra compra;
	private PuntoDeVenta pdv;
	
	@BeforeEach
	void setUp() throws Exception {
		compra = new Compra(1234, pdv, LocalDate.of(2024, 10, 6), LocalTime.of(13,45));
	}

	@Test
	void cuandoLePidoSuNumeroDeControl_Sera1234() {
		assertEquals(compra.getNumeroDeControl(),1234);
	}
	
	@Test
	void cuandoLePidoSuPuntoDeVenta_Serapdv() {
		assertEquals(compra.getPuntoDeVenta(),pdv);
	}
	
	@Test
	void cuandoLePidoSuFechaDeInicio_Sera10DeJunio2024() {
		assertEquals(compra.getFechaDeInicio(),LocalDate.of(2024, 10, 6) );
	}
	
	@Test
	void cuandoLePidoSuHoraDeInicio_Sera1345() {
		assertEquals(compra.getHoraDeInicio(), LocalTime.of(13,45));
	}

}
