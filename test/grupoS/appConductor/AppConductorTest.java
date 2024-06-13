package grupoS.appConductor;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import grupoS.SEM.SEM;
import grupoS.asistencia.AsistenciaDesactivada;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estado.Driving;
import grupoS.estado.Walking;
import grupoS.modoDeAppConductor.ModoManual;

class AppConductorTest {
	
	private AppConductor app;
	private SEM sem;
	private SEM sem2;
	private ModoManual modoManual;
	private Estacionamiento estacionamiento;
	
	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEM.class);
		sem2 = mock(SEM.class);
		modoManual = mock(ModoManual.class);
		app = new AppConductor(123456, sem);
		
	}

	@Test
	void cuandoEnUnaAppConductorSeModificaElCelular_EntoncesLaAppTendraUnNuevoNumeroGuardado_YElAnteriorNoEstaraMas() {
		app.setCelular(123);
		
		assertEquals(app.getCelular(), 123);
		assertFalse(app.getCelular()==(123456));
	}
	
	@Test
	void cuandoSeModificaElSEMDeUnaAppConductor_ElAnteriorSEMDejaraDeEstarRegistaro_YEstaraRegistradoElNuevoSEM() {
		app.setSem(sem2);
		
		assertEquals(app.getSem(),sem2);
		assertFalse(app.getSem().equals(sem));
	}
	
	@Test
	void cuandoRecienSeCreaUnaInstaciaDeAppConductor_SuModoPorDefectoSeraElModoManual() {
		assertNotNull(app.getModoDeApp());
		assertTrue(app.getModoDeApp() instanceof ModoManual);
	}
	
	@Test
	void cuandoRecienSeCreaUnaInstaciaDeAppConductor_SuModoDeAsistenciaEstaraDesaticvado() {
		assertNotNull(app.getModoAsistencia());
		assertTrue(app.getModoAsistencia() instanceof AsistenciaDesactivada);
	}
	
	@Test
	void cuandoSeIniciaUnEstacionamientoConUnaDeterminadaPatente_EsaPatenteQuedaraRegistradaEnEnLaApp() {
		app.iniciarEstacionamiento("123abc");
		
		assertEquals(app.getPatente(), "123abc");
	}
	
	@Test 
	void cuandoSeIniciaUnEstacionamientoEnUnaApp_DependendiendoElModoDeAppEnElQueEste_EseSeVaAEncargarDeIniciarElEstacionamiento() {
		app.cambiarModoDeApp(modoManual);
		app.iniciarEstacionamiento("123abc");
		
        verify(modoManual).iniciarEstacionamiento(app, "123abc");
	}
	
	@Test 
	void cuandoSefinalizaUnEstacionamientoEnUnaApp_DependendiendoElModoDeAppEnElQueEste_EseSeVaAEncargarDeFinalizarElEstacionamiento() {
		app.cambiarModoDeApp(modoManual);
		app.finalizarEstacionamiento();
		
        verify(modoManual).finalizarEstacionamiento(app);
	}
	
	@Test
	void cuandoSeConsultaUnSaldoPorMedioDeLaApp_LaAppLePreguntaraAlSEMQueSaldoTieneDisponible() {
		app.consultarSaldo();
		
		verify(sem).saldoDe(app.getCelular());
	}

	@Test
	void cuandoSeLePideAUnaAppQueRegistreUnEstacionamiento_LaAppLePediraAlSEMQueLoRegistreEnSusEstacionamientos() {
		app.registrarEstacionamiento(estacionamiento);
		
		verify(sem).registrarEstacionamiento(estacionamiento);
	}
	
	@Test
	void cuandoSeHaceUnNuevoEstacionamientoAtravesDeLaApp_ConUnaNuevaPatente_EstaNuevaPatenteQuedaraRegistradaEnLaAppYLaAnteriorSeraRemovida() {
		app.iniciarEstacionamiento("1234");
		app.iniciarEstacionamiento("4321");
		
		assertEquals(app.getPatente(),"4321");
		assertFalse(app.getPatente()=="1234");
	}
	
	@Test
	void cuandoAUnaAppSeLePideQueBusqueUnEstacionamiento_EstaLePediraAlSEMQueLoBusqueEnSusEstacionamientos() {
		app.registrarEstacionamiento(estacionamiento);
		
		assertEquals(app.buscarEstacionamientoApp(),estacionamiento);
	}
	
	@Test
	void cuandoUnaAppQuiereSaberElPrecioPorHoraDelSEM_SeLoPreguntaraAlSEM() {
		app.precioPorHora();
		
		verify(sem).getPrecioPorHora();
	}
	
	@Test
	void cuandoUnaAppQuiereCobrarPorLasHorasUtilizadasDeUnEstacionamiento_ElSEMSeEncargaraDeCobrarselo() {
		app.cobrarPorHoras(3);
		
		verify(sem).cobrarEstacionamientoApp(3, app.getCelular());
	}
	
	@Test
	void cuandoSeCambiaElModoDeAsistencia_LaAppDebeActualizarElModoDeAsistencia() {
		AsistenciaDesactivada asistencia = new AsistenciaDesactivada();
		app.cambiarAsistencia(asistencia);
		
		assertEquals(asistencia, app.getModoAsistencia());
	}

	@Test
	void cuandoSeCambiaElModoDeApp_LaAppDebeActualizarElModoDeApp() {
		ModoManual modo = new ModoManual();
		app.cambiarModoDeApp(modo);
		
		assertEquals(modo, app.getModoDeApp());
	}

	@Test
	void cuandoSeCambiaElModoACaminando_LaAppDebeCambiarSuEstadoAModoCaminando() {
		app.cambiarModoACaminando();
		
		assertTrue(app.getEstado() instanceof Walking);
	}

	@Test
	void cuandoSeCambiaElModoAManejando_LaAppDebeCambiarSuEstadoAModoManejando() {
		app.cambiarModoAManejando();
		
		assertTrue(app.getEstado() instanceof Driving);
	}

	@Test
	void cuandoSeVerificaSiTieneEstacionamientoVigenteEnElMismoPuntoGeografico_LaAppDebeBuscarElEstacionamientoYVerificarSiEstaVigente() {
		app.tieneEstacionamientoVigenteEnMismoPuntoGeografico();
		
		verify(sem).buscarEstacionamientoApp(app.getCelular());
	}
	
	@Test
    void walking_DebeInvocarMetodoCaminandoDelEstadoActual() {
		assertDoesNotThrow(() -> { app.walking(); });
    }

    @Test
    void driving_DebeInvocarMetodoManejandoDelEstadoActual() {
    	assertDoesNotThrow(() -> { app.driving(); });
    }
    
    @Test
    public void testCalcularHoraMaxima_AntesDelHorarioDeCierre() {
    	when(sem.getPrecioPorHora()).thenReturn(40.00);
    	when(sem.saldoDe(app.getCelular())).thenReturn(40.00);
    	when(sem.getHoraDeCierre()).thenReturn(LocalTime.of(23, 00));
    	
    	assertEquals(app.calcularHoraMaxima(), LocalTime.now().plusHours((long)1).withSecond(0).withNano(0));
    }
    
    
    @Test
    public void testCalcularHoraMaxima_DespuesDelHorarioDeCierre() {
    	when(sem.getPrecioPorHora()).thenReturn(40.00);
    	when(sem.saldoDe(app.getCelular())).thenReturn(240.00);
    	when(sem.getHoraDeCierre()).thenReturn(LocalTime.of(20, 00));
    	
    	assertEquals(app.calcularHoraMaxima(),sem.getHoraDeCierre().withSecond(0).withNano(0));
    }
	
}
