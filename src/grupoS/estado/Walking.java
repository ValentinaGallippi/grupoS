package grupoS.estado;

import grupoS.appConductor.AppConductor;

public class Walking implements Estado {

	@Override
	public void manejando(AppConductor app) {
		if(app.tieneEstacionamientoVigenteEnMismoPuntoGeografico()){
	        app.cambiarModoACaminando();
	        app.getModoAsistencia().recibirAlertaManejando();
	        }
	}

	@Override
	public void caminando(AppConductor appConductor) {
		// TODO Auto-generated method stub
		
	}
	
}
