package grupoS.estacionamiento;

import java.time.LocalTime;

import grupoS.usuario.Usuario;

public class EstacionamientoPuntual extends Estacionamiento{
    
    private int cantidadDeHoras;

    public EstacionamientoPuntual(Usuario usuario, int cantidadDeHoras) {
        super(usuario);
        this.cantidadDeHoras = cantidadDeHoras;
    }
}