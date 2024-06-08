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

	public void setNumeroDeControl(int numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}
    

}

