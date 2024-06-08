package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class CompraEstacionamiento extends Compra {
	
	private int cantidadDeHoras;

	public CompraEstacionamiento(int numeroDeControl, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio,
			LocalTime horaDeInicio, int cantidadDeHoras) {
		super(numeroDeControl, puntoDeVenta, fechaDeInicio, horaDeInicio);
		this.cantidadDeHoras = cantidadDeHoras;
		
	}
	
	

}
