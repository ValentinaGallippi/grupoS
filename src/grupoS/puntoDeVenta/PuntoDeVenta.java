package grupoS.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.SEM.SEM;
import grupoS.compra.CompraRecargaCredito;
import grupoS.estacionamiento.EstacionamientoPuntual;
import grupoS.usuario.Usuario;

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
        CompraRecargaCredito compra = new CompraRecargaCredito(0, this, LocalDate.now(), LocalTime.now());
        this.sem.registrarCompra(compra);;
    }
}