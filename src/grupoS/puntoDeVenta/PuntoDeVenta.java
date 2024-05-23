package grupoS.puntoDeVenta;

import java.time.LocalDate;

public class PuntoDeVenta {
    
    private SEM sem;

    public PuntoDeVenta(SEM sem) {
        this.sem = sem;
    }

    public void realizarEstacionamiento(Usuario usuario, int cantidadDeHoras) {
        EstacionamientoPuntual estacionamiento = new EstacionamientoPuntual(usuario, cantidadDeHoras);
        this.sem.registrarEstacionamiento(estacionamiento);
    }

    public void cargarCredito(Usuario usuario, double monto) {
        this.sem.registrarCreditoDisponible(usuario.getCelular(), monto);
        CompraPuntual compra = new CompraPuntual(0, this, LocalDate.now(), LocalTime.now());
        this.sem.registrarCompra(compra);;
    }