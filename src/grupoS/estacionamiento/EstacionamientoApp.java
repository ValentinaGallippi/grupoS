package grupoS.estacionamiento;

import java.time.LocalTime;

import grupoS.usuario.Usuario;

public class EstacionamientoApp extends Estacionamiento{

    private LocalTime horaDeInicio;

    public EstacionamientoApp(Usuario usuario, LocalTime horaDeInicio) {
        super(usuario);
        this.horaDeInicio = horaDeInicio;
    }
}