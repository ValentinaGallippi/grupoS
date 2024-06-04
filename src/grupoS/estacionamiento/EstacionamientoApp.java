package grupoS.estacionamiento;

import java.time.LocalTime;

import grupoS.usuario.Usuario;

public class EstacionamientoApp extends Estacionamiento{

    private LocalTime horaDeInicio;

    public EstacionamientoApp(int celular, String patente, LocalTime horaDeInicio) {
        super(celular,patente);
        this.horaDeInicio = horaDeInicio;
    }
    
    @Override
    public LocalTime horaDeInicio() {
    	return this.horaDeInicio;
    }
}