package grupoS.modoDeAppConductor;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;

public class ModoAutomatico extends ModoDeAppConductor {
	
	

	public ModoAutomatico() {
		super();
		// TODO Auto-generated constructor stub
	}

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
<<<<<<< Updated upstream
	public void notificarFinEstacionamiento(AppConductor app){
		System.out.println("Estacionamiento finalizado");
		app.finalizarEstacionamiento();
	}

	@Override
	public void notificarInicioEstacionamiento(AppConductor app) {
		System.out.println("Inicio de Estacionamiento");
		app.iniciarEstacionamiento(app.getPatente());
	}

=======
    public void notificarFinEstacionamiento(AppConductor app){
        System.out.println("Estacionamiento finalizado");
        this.finalizarEstacionamiento(app);
        app.finalizarEstacionamiento();
    }
>>>>>>> Stashed changes

    @Override
    public void notificarInicioEstacionamiento(AppConductor app) {
        System.out.println("Inicio de Estacionamiento");
        this.iniciarEstacionamiento(app, app.getPatente());
        app.iniciarEstacionamiento(app.getPatente());
    }
	

}
