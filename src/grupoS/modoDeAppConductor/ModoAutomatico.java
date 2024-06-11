package grupoS.modoDeAppConductor;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;

public class ModoAutomatico extends ModoDeAppConductor {
	

	@Override
	public void cambiarAsistencia(Asistencia asistencia, AppConductor app){
		if (!asistencia.esDesactivada()) {
			app.setAsistencia(asistencia);
		}
	}

	@Override
	public boolean esModoAutomatico() {
		return true;
	}

	@Override
	public void notificarFinEstacionamiento(AppConductor app){
		System.out.println("Estacionamiento finalizado");
		this.finalizarEstacionamiento(app);
	}

	@Override
	public void notificarInicioEstacionamiento(AppConductor app) {
		System.out.println("Inicio de Estacionamiento");
		this.iniciarEstacionamiento(app, app.getPatente());
	}


	

}
