package grupoS.estado;

import grupoS.appConductor.AppConductor;

public class Driving  implements Estado{

	@Override
	public void manejando(AppConductor appConductor) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void caminando(AppConductor appConductor){
		// TODO Auto-generated method stub
		if (!appConductor.tieneEstacionamientoVigenteEnMismoPuntoGeografico()){ 
			appConductor.cambiarModoACaminando();
			appConductor.getModoAsistencia().recibirAlertaCaminando(appConductor);
	    }
	}
	
	

}
