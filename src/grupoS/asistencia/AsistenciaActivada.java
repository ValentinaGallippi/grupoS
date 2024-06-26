package grupoS.asistencia;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

public class AsistenciaActivada implements Asistencia {

	@Override
	public boolean esDesactivada() {
		return false;
	}

	@Override
	public void cambiarModoDeApp(ModoDeAppConductor modo, AppConductor appConductor) {
		appConductor.setModoDeApp(modo);
	}

	@Override
	public void recibirAlertaManejando(AppConductor app) {
		app.getModoDeApp().notificarFinEstacionamiento(app);
	}

	@Override
	public void recibirAlertaCaminando(AppConductor app) {
		app.getModoDeApp().notificarInicioEstacionamiento(app);
	}
	

}
