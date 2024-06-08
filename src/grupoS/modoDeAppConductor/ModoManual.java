package grupoS.modoDeAppConductor;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;


public class ModoManual extends ModoDeAppConductor {
	

	@Override
	public void cambiarAsistencia(Asistencia asistencia, AppConductor app) {
		app.setAsistencia(asistencia);
	}

	@Override
	public boolean esModoAutomatico() {
		return false;
	}

	@Override
	public void notificarFinEstacionamiento(AppConductor app) {
		
		System.out.println("No olvide finalizar su estacionamiento");
		
	}

	@Override
	public void notificarInicioEstacionamiento(AppConductor app) {
		System.out.println("No olvide iniciar su estacionamiento");
	}

}
