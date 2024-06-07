package grupoS.appConductor;

import grupoS.modoDeAppConductor.ModoDeAppConductor;

public interface Asistencia {

	boolean esDesactivada();

	void cambiarModoDeApp(ModoDeAppConductor modo, AppConductor appConductor) throws Exception;

	void recibirAlertaManejando(AppConductor app);

}
