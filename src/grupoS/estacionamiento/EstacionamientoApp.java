package grupoS.estacionamiento;

public class EstacionamientoApp extends Estacionamiento{

    private LocalTime horaDeInicio;

    public EstacionamientoApp(Usuario usuario, LocalTime horaDeInicio) {
        super(usuario);
        this.horaDeInicio = horaDeInicio;
    }
}