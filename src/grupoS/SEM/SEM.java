package grupoS.SEM;

import java.time.*;
import java.util.*;

public class SEM {

    private LocalTime horaDeInicio;
    private LocalTime horaDeCierre;
    private double precioPorHora;
    private List<ZonaDeEstacionamientoMedido> zonas     = new ArrayList<>();
    private List<Compra> compras                        = new ArrayList<>();
    private List<Estacionamiento> estacionamientos      = new ArrayList<>();
    private List<Infraccion> infracciones               = new ArrayList<>();
    private List<Entidad> entidades                     = new ArrayList<>();
    private HashMap<Integer,Double> creditosDisponibles = new HashMap<>();

    public SEM(LocalTime horaDeInicio, LocalTime horaDeCierre, double precioPorHora){
        this.horaDeInicio = horaDeInicio;
        this.horaDeCierre = horaDeCierre;
        this.precioPorHora = precioPorHora;
    }

    public void registrarZona(ZonaDeEstacionamientoMedido zona) {
        this.zonas.add(zona);
    }

    public void registrarCompra(Compra compra) {
        this.compras.add(compra);
    }

    public void registrarEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamientos.add(estacionamiento);
    }

    public void registrarCreditoDisponible(int celular, double monto) {
        this.creditosDisponibles.put(celular, monto);
    }

    public void registrarInfraccion(Infraccion infraccion) {
        this.infracciones.add(infraccion);
    }

    public void finalizarEstacionamientosEnCurso() {
        // estacionamientos, es una lista que hace referencia, a los estacionamientos que estan vigentes 
        // ese dia en ese momento¡?
        if (this.horaDeCierre == LocalTime.now()) {
            this.estacionamientos.clear();
        }
    }

    public void suscribirEntidad(Entidad entidad) {
        this.entidades.add(entidad);
    }

    public void desuscribirEntidad(Entidad entidad) {
        this.entidades.remove(entidad);
    }

    public void terminarEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamientos.remove(estacionamiento);
    }

    public double saldoDe(int celular) {
        return this.creditosDisponibles.get(celular);
    }

    public double getPrecioPorHora() {
       return this.precioPorHora;
    }

    public boolean estaVigente(String patente) {
        Estacionamiento estacionamientoaVerSiEstaVigente = null;
        for (Estacionamiento estacionamiento : this.estacionamientos) {
            if (estacionamiento.getPatente() == patente) {
                estacionamientoaVerSiEstaVigente = estacionamiento;
            }
        }
        return estacionamientoaVerSiEstaVigente.estaVigente();
    }

    public void realizarInfraccion(String patente) {
        //Precondición la patente dada debe tener un estacionamiento no vigente- no valido.
        
        this.registrarInfraccion(infraccion));
        ;
    }
}
