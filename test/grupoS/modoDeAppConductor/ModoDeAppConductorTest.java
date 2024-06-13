package grupoS.modoDeAppConductor;

import static org.mockito.Mockito.*;
import grupoS.appConductor.AppConductor;
import grupoS.estacionamiento.EstacionamientoApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

class ModoDeAppConductorTest {

    private ModoDeAppConductor modoDeAppConductor;
    private AppConductor app;
    private EstacionamientoApp estacionamiento;

    @BeforeEach
    public void setup() {
        modoDeAppConductor = new ModoManual();
        app = mock(AppConductor.class);
        estacionamiento = mock(EstacionamientoApp.class);
    }

    @Test
    public void testIniciarEstacionamiento_SaldoSuficiente() {
        when(app.consultarSaldo()).thenReturn(50.0);
        when(app.calcularHoraMaxima()).thenReturn(LocalTime.now().plusHours(2));

        modoDeAppConductor.iniciarEstacionamiento(app, "ABC123");

        verify(app, times(1)).registrarEstacionamiento(any(EstacionamientoApp.class));
    }

    @Test
    public void testIniciarEstacionamiento_SaldoInsuficiente() {
        when(app.consultarSaldo()).thenReturn(0.0);

        modoDeAppConductor.iniciarEstacionamiento(app, "ABC123");

        verify(app, never()).registrarEstacionamiento(any(EstacionamientoApp.class));
    }

    @Test
    public void testFinalizarEstacionamiento() {
        when(app.buscarEstacionamientoApp()).thenReturn(estacionamiento);
        when(estacionamiento.getHoraDeInicio()).thenReturn(LocalTime.now().minusHours(1));

        modoDeAppConductor.finalizarEstacionamiento(app);

        verify(app, times(1)).cobrarPorHoras(anyDouble());
    }
}