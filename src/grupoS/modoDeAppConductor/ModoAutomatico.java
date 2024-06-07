package grupoS.modoDeAppConductor;

import grupoS.appConductor.AppConductor;
import grupoS.appConductor.Asistencia;

public class ModoAutomatico extends ModoDeAppConductor {
	

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

	@Override
	public void notificarFinEstacionamiento(AppConductor app) {
		
		System.out.println("Estacionamiento finalizado");
		this.finalizarEstacionamiento(app);
		
		
	}

}
