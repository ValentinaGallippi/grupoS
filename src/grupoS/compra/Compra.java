package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.puntoDeVenta.PuntoDeVenta;

public class Compra {

    private int numeroDeControl;
    private PuntoDeVenta puntoDeVenta;
    private LocalDate fechaDeInicio;
    private LocalTime horaDeInicio;

    public Compra(int numero, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio, LocalTime horaDeInicio) {
        this.numeroDeControl = numeroDeControl;
        this.puntoDeVenta = puntoDeVenta;
        this.fechaDeInicio = fechaDeInicio;
        this.horaDeInicio = horaDeInicio;
    }

}

