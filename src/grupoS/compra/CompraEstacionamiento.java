package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class CompraEstacionamiento extends Compra {
	
	private int cantidadDeHoras;

	public CompraEstacionamiento(int numero, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio,
			LocalTime horaDeInicio, int cantidadDeHoras) {
		super(numero, puntoDeVenta, fechaDeInicio, horaDeInicio);
		this.cantidadDeHoras = cantidadDeHoras;
		
	}
	
	

}
