package grupoS.modoDeAppConductor;
import grupoS.appConductor.AppConductor;


public interface ModoDeAppConductor {
	void iniciarEstacionamiento(AppConductor app, String patente);
	void finalizarEstacionamiento(AppConductor app); 
}


