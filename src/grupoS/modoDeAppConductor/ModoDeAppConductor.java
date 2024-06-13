package grupoS.modoDeAppConductor;
import java.time.Duration;
import java.time.LocalTime;

import grupoS.appConductor.AppConductor;
import grupoS.asistencia.Asistencia;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estacionamiento.EstacionamientoApp;


public abstract class ModoDeAppConductor {
	
	
	public void iniciarEstacionamiento(AppConductor app, String patente) {
        if(app.consultarSaldo() > 0) {
        	LocalTime horaMaxima =app.calcularHoraMaxima();
            System.out.println("La hora de inicio es:" + LocalTime.now().withSecond(0).withNano(0) + "La hora maxima es:" + horaMaxima);
            EstacionamientoApp estacionamiento = new EstacionamientoApp(app.getCelular(),patente , LocalTime.now(), horaMaxima);
            app.registrarEstacionamiento(estacionamiento);
        } else {
        	System.out.println("Saldo insuficiente");
        }
    }
	
	public void finalizarEstacionamiento(AppConductor app){
		Estacionamiento estacionamiento = app.buscarEstacionamientoApp(); 
		LocalTime inicio = estacionamiento.getHoraDeInicio().withSecond(0).withNano(0);
		LocalTime fin    = LocalTime.now().withSecond(0).withNano(0); 
		Duration duracion = Duration.between(inicio, fin);
		double duracionEnHoras = duracion.toMinutes() / 60.0;
		// cobrarPorHoras le saca y luego actualiza el saldo al celular con el que esta relacionado el estacionamiento
		app.cobrarPorHoras(duracionEnHoras);
		System.out.println("Hora de comienzo: " + inicio
						+  "Hora de fin:" + fin
						+  "Duracion total de horas: " + duracionEnHoras
						+  "Costo: $" + (duracionEnHoras * app.precioPorHora() ) );
		
	}
	
	
	public abstract void cambiarAsistencia(Asistencia asistencia, AppConductor app);
	public abstract boolean esModoAutomatico();
	public abstract void notificarFinEstacionamiento(AppConductor app);
	public abstract void notificarInicioEstacionamiento(AppConductor app);
}


