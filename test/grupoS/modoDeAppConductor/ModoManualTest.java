package grupoS.modoDeAppConductor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModoManualTest {

    private ModoManual modoManual;
    private AppConductor app;
    private Asistencia asistencia;

    @BeforeEach
    public void setup() {
        modoManual = new ModoManual();
        app = mock(AppConductor.class);
        asistencia = mock(Asistencia.class);
    }

    @Test
    public void testCambiarAsistencia() {
        modoManual.cambiarAsistencia(asistencia, app);

        verify(app, times(1)).setAsistencia(asistencia);
    }

    @Test
    public void testEsModoAutomatico() {
        assertFalse(modoManual.esModoAutomatico());
    }

    @Test
    public void testNotificarFinEstacionamiento() {
        modoManual.notificarFinEstacionamiento(app);
    }

    @Test
    public void testNotificarInicioEstacionamiento() {
        modoManual.notificarInicioEstacionamiento(app);
    }
}