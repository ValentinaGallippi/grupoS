package grupoS.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.SEM.SEM;
import grupoS.compra.Compra;
import grupoS.compra.CompraEstacionamiento;
import grupoS.compra.CompraRecargaCredito;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estacionamiento.EstacionamientoPuntual;



public class PuntoDeVenta {
    
    private SEM sem;
    

    public PuntoDeVenta(SEM sem) {
        this.sem = sem;
    }

    public void realizarEstacionamiento(int celular, String patente, int cantidadDeHoras) {
        EstacionamientoPuntual estacionamiento = new EstacionamientoPuntual(celular, patente , cantidadDeHoras);
        this.sem.registrarEstacionamiento(estacionamiento);
        CompraEstacionamiento compraEstacionamiento = new CompraEstacionamiento(celular, this, LocalDate.now(), LocalTime.now(), cantidadDeHoras);
        this.sem.registrarCompra(compraEstacionamiento);
        
    }

    public void cargarCredito(int celular, double monto) {
        this.sem.registrarCreditoDisponible(celular, monto);
        CompraRecargaCredito compraRecargaCredito = new CompraRecargaCredito(celular, this, LocalDate.now(), LocalTime.now());
        this.sem.registrarCompra(compraRecargaCredito);
    }
    
    
}