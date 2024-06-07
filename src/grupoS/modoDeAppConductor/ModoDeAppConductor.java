package grupoS.modoDeAppConductor;
import grupoS.appConductor.AppConductor;
import grupoS.appConductor.Asistencia;


public interface ModoDeAppConductor {
	void iniciarEstacionamiento(AppConductor app, String patente);
	void finalizarEstacionamiento(AppConductor app);
	void cambiarAsistencia(Asistencia asistencia, AppConductor app) throws Exception;
	boolean esModoAutomatico(); 
}


