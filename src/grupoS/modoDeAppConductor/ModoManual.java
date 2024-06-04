package grupoS.modoDeAppConductor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

import grupoS.appConductor.AppConductor;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estacionamiento.EstacionamientoApp;


public class ModoManual implements ModoDeAppConductor {

	@Override
	public void iniciarEstacionamiento(AppConductor app, String patente) {
        if(app.consultarSaldo() > 0) {
            System.out.println("La hora de inicio es:" + LocalTime.now() + "La hora maxima es:" + app.calcularHoraMaxima());
            EstacionamientoApp estacionamiento = new EstacionamientoApp(app.getCelular(),patente , LocalTime.now());
            app.registrarEstacionamiento(estacionamiento);
        } else {
        	System.out.println("Saldo insuficiente");
        }
    }

	@Override
	public void finalizarEstacionamiento(AppConductor app) {
		Estacionamiento estacionamiento = app.buscarEstacionamiento(); 
		LocalTime inicio = estacionamiento.horaDeInicio();
		LocalTime fin    = LocalTime.now(); 
		Duration duracion = Duration.between(inicio, fin);
		double duracionEnHoras = duracion.toMinutes() / 60.0;
		// cobrarPorHoras le saca el saldo al celular con el q esta relacionado el estacionamiento
		app.cobrarPorHoras(duracionEnHoras);
		app.finalizarEnElSem(estacionamiento);
		System.out.println("Hora de comienzo: " + inicio
						+  "Hora de fin:" + fin
						+  "Duracion total de horas: " + duracionEnHoras
						+  "Costo: $" + (duracionEnHoras / app.precioPorHora() ) );
		
	}

}
