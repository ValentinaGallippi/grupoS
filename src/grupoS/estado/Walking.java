package grupoS.estado;

import grupoS.appConductor.AppConductor;

public class Walking implements Estado {

	@Override
	public void manejando(AppConductor app){
		if(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()){
	        app.cambiarModoAManejando();
	        app.getModoAsistencia().recibirAlertaManejando(app);
	        }
	}

	@Override
	public void caminando(AppConductor appConductor) {
		
	}
	
}
