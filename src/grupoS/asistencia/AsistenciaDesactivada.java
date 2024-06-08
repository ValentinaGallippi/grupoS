package grupoS.asistencia;

import grupoS.appConductor.AppConductor;
import grupoS.modoDeAppConductor.ModoDeAppConductor;

public class AsistenciaDesactivada implements Asistencia{

	@Override
	public boolean esDesactivada() {
		return true;
	}

	@Override
	public void cambiarModoDeApp(ModoDeAppConductor modo, AppConductor appConductor) throws Exception {
		if(modo.esModoAutomatico()) {
			throw new Exception("ERROR: no se puede cambiar a modo automatico con la asistencia desactivada. Active la asistencia");
		} else {
			appConductor.setModoDeApp(modo);
		}
		
	}

	@Override
	public void recibirAlertaManejando(AppConductor app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirAlertaCaminando(AppConductor app) {
		// TODO Auto-generated method stub
		
	}
	
}
