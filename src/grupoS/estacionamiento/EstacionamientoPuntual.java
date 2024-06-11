package grupoS.estacionamiento;

import java.time.LocalTime;

import grupoS.compra.CompraEstacionamiento;

public class EstacionamientoPuntual extends Estacionamiento{
    
    private int cantidadDeHoras;
    private CompraEstacionamiento ticket;

    public EstacionamientoPuntual(String patente, LocalTime horaDeInicio, LocalTime horaDeFin, CompraEstacionamiento ticket, int cantidadDeHoras) {
        super(horaDeInicio, horaDeFin, patente);
        this.cantidadDeHoras = cantidadDeHoras;
        this.ticket = ticket;
    }


	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	public CompraEstacionamiento getTicket() {
		return ticket;
	}

	@Override
	public boolean esDeApp() {
		return false;
	}


	@Override
	public int getCelular() {
		// TODO Auto-generated method stub
		return 0;
	}

	
   
}