package grupoS.estado;

import grupoS.appConductor.AppConductor;

public class Driving  implements Estado{

	@Override
	public void manejando(AppConductor appConductor) {
		
	}

	@Override
	public void caminando(AppConductor appConductor){
		
		if (!appConductor.tieneEstacionamientoVigenteEnMismoPuntoGeografico()){ 
			appConductor.cambiarModoACaminando();
			appConductor.getModoAsistencia().recibirAlertaCaminando(appConductor);
	    }
	}
	
	

}
