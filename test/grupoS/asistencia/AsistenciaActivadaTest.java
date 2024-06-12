package grupoS.asistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

class AsistenciaActivadaTest {

    private AsistenciaActivada aa;
    private AppConductor app;
    private ModoDeAppConductor modo;


    @BeforeEach
    void setUp() throws Exception {
        aa = new AsistenciaActivada();
        app = mock(AppConductor.class);
        modo = mock(ModoDeAppConductor.class);
    }

    @Test
    void cuandoSeLePreguntaSiEsDesactivada_DevuelvaFalse() {
        assertFalse(aa.esDesactivada());
    }

    @Test
    void aUnaAppConductor_SeLeCambiaElModo() {
        aa.cambiarModoDeApp(modo, app);

        verify(app).setModoDeApp(modo);
    }

    @Test 
    void cuandoSeRecibeUnaAlertaCaminando_ElModoDeAppNotifica() {
        when(app.getModoDeApp()).thenReturn(modo);
        aa.recibirAlertaCaminando(app);
        verify(modo).notificarInicioEstacionamiento(app);
    }

    @Test
    void cuandoSeRecibeUnaAlertaManejando_ElModoDeAppNotifica() {
        when(app.getModoDeApp()).thenReturn(modo);
        aa.recibirAlertaManejando(app);
        verify(modo).notificarFinEstacionamiento(app);
    }

}