package grupoS.asistencia;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

public interface Asistencia {

	boolean esDesactivada();

	void cambiarModoDeApp(ModoDeAppConductor modo, AppConductor appConductor) throws Exception;

	void recibirAlertaManejando(AppConductor app);

	void recibirAlertaCaminando(AppConductor app);

}
