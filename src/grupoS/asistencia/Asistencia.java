package grupoS.asistencia;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

public interface Asistencia {

	boolean esDesactivada();

	void cambiarModoDeApp(ModoDeAppConductor modo, AppConductor appConductor);

	void recibirAlertaManejando(AppConductor app);

	void recibirAlertaCaminando(AppConductor app);

}
