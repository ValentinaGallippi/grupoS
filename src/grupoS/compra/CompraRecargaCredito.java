package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class CompraRecargaCredito extends Compra {
	
	private int celular;

	public CompraRecargaCredito(int numeroDeControl, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio, LocalTime horaDeInicio, int celular) {
		super(numeroDeControl, puntoDeVenta, fechaDeInicio, horaDeInicio);
		this.celular = celular;
	}
	
	public int getCelular() {
		return this.celular;
	}

}
