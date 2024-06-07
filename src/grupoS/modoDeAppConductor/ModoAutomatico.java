package grupoS.modoDeAppConductor;

import grupoS.appConductor.AppConductor;
import grupoS.appConductor.Asistencia;

public class ModoAutomatico implements ModoDeAppConductor {

	@Override
	public void iniciarEstacionamiento(AppConductor app, String patente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarEstacionamiento(AppConductor app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarAsistencia(Asistencia asistencia, AppConductor app)  throws Exception{
		if (asistencia.esDesactivada()) {
			throw new Exception("ERROR: no se puede desactivar la asistencia. Si desea desactivarla, cambie a manual");
		} else {
			app.setAsistencia(asistencia);
		}
		
	}

	@Override
	public boolean esModoAutomatico() {
		return true;
	}

}
