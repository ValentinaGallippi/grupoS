package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class CompraRecargaCredito extends Compra {

	public CompraRecargaCredito(int numero, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio, LocalTime horaDeInicio) {
		super(numero, puntoDeVenta, fechaDeInicio, horaDeInicio);
	}

}
