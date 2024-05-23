package grupoS.Estacionamiento;

import java.time.LocalTime;

public class EstacionamientoPuntual extends Estacionamiento{
    
    private int cantidadDeHoras;

    public EstacionamientoPuntual(Usuario usuario, int cantidadDeHoras) {
        super(usuario);
        this.cantidadDeHoras = cantidadDeHoras;
    }
}