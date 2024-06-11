package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class Compra {

    private int numeroDeControl;
    private PuntoDeVenta puntoDeVenta;
    private LocalDate fechaDeInicio;
    private LocalTime horaDeInicio;

    public Compra(int numeroDeControl, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio, LocalTime horaDeInicio) {
        this.numeroDeControl = numeroDeControl;
        this.puntoDeVenta = puntoDeVenta;
        this.fechaDeInicio = fechaDeInicio;
        this.horaDeInicio = horaDeInicio;
    }

	public int getNumeroDeControl() {
		return numeroDeControl;
	}

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}


}

