package grupoS.compra;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {

    private int numero;
    private PuntoDeVenta puntoDeVenta;
    private LocalDate fechaDeInicio;
    private LocalTime horaDeInicio;

    public Compra(int numero, PuntoDeVenta puntoDeVenta, LocalDate fechaDeInicio, LocalTime horaDeInicio) {
        this.numero = numero;
        this.puntoDeVenta = puntoDeVenta;
        this.fechaDeInicio = fechaDeInicio;
        this.horaDeInicio = horaDeInicio;
    }

}

