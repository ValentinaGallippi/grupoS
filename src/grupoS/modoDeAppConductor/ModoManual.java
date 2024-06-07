package grupoS.modoDeAppConductor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

import grupoS.appConductor.AppConductor;
import grupoS.appConductor.Asistencia;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estacionamiento.EstacionamientoApp;


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

}
