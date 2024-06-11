package grupoS.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.SEM.SEM;
import grupoS.compra.CompraEstacionamiento;
import grupoS.compra.CompraRecargaCredito;
import grupoS.estacionamiento.EstacionamientoPuntual;

public class PuntoDeVenta {
    
    private SEM sem;

    public PuntoDeVenta(SEM sem) {
        this.sem = sem;
    }

    public void realizarEstacionamiento(String patente, int cantidadDeHoras) {
     
        CompraEstacionamiento compraEstacionamiento = new CompraEstacionamiento(this.sem.getTicketsEmitidos(), this, LocalDate.now(), LocalTime.now(), cantidadDeHoras);
        this.sem.registrarCompra(compraEstacionamiento);
        EstacionamientoPuntual estacionamiento = new EstacionamientoPuntual(patente, LocalTime.now(), LocalTime.now().plusHours(cantidadDeHoras), compraEstacionamiento, cantidadDeHoras);
        this.sem.actualizarTicketsEmitidos();
        this.sem.registrarEstacionamiento(estacionamiento);
    }

    public void cargarCredito(int celular, double monto) {
        this.sem.registrarCreditoDisponible(celular, monto);
        CompraRecargaCredito compraRecargaCredito = new CompraRecargaCredito(this.sem.getTicketsEmitidos(), this, LocalDate.now(), LocalTime.now(), celular);
        this.sem.registrarCompra(compraRecargaCredito);
        this.sem.actualizarTicketsEmitidos();
        
    }

	public SEM getSem() {
		return sem;
	}
}