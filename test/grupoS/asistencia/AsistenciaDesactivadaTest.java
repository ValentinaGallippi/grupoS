package grupoS.asistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

class AsistenciaDesactivadaTest {

    private AsistenciaDesactivada ad;
    private AppConductor app;
    private ModoDeAppConductor modo;


    @BeforeEach
    void setUp() throws Exception {
        ad = new AsistenciaDesactivada();
        app = mock(AppConductor.class);
        modo = mock(ModoDeAppConductor.class);
    }

    @Test
    void cuandoLePreguntanSiEsDesactivada_DevuelveTrue() {
        assertTrue(ad.esDesactivada());
    }

    @Test
    void aUnaAppConductor_SeLeCambiaElModo_SiElModoEsManual() {
        when(modo.esModoAutomatico()).thenReturn(false);

        ad.cambiarModoDeApp(modo, app);

        verify(app).setModoDeApp(modo);

    }

    @Test
    void aUnaAppConductor_NoSeLeCambiaElModo_SiElModoEsAutomatico() {
        when(modo.esModoAutomatico()).thenReturn(true);

        ad.cambiarModoDeApp(modo, app);

        verifyNoInteractions(app);
    }

    @Test //ya sea alerta de caminando o de manejando 
    void cuandoSeRecibeUnaAlerta_NoHaceNada() {
        ad.recibirAlertaCaminando(app);
        ad.recibirAlertaManejando(app);

        verifyNoInteractions(app);

    }
}