package grupoS.appConductor;

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
	
}
