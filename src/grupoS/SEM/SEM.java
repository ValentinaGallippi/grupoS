package grupoS.SEM;

import grupoS.compra.Compra;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

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
    		Optional<Estacionamiento> estacionamiento = this.estacionamientos.stream()
    										  .filter(e -> e.getPatente().equals(patente))
    										  .findFirst();
        	if (estacionamiento.isPresent()) {
        		return estacionamiento.get().estaVigente();
        	} else {
        		System.out.println("ERROR: Estacionamiento no encontrado");
        	}
    }

    public void realizarInfraccion(String patente) {
        //Precondición la patente dada debe tener un estacionamiento no vigente- no valido.
        
        this.registrarInfraccion(infraccion));
    }

	public Estacionamiento buscarEstacionamiento(int celular) {
		 Optional<Estacionamiento> estacionamiento1 = estacionamientos.stream()
				 									  .filter(estacionamiento -> estacionamiento.getCelular() == celular)
				 									  .findFirst();
		 if(estacionamiento1.isPresent()) {
			 return estacionamiento1.get();
		 } else {
			 System.out.println("ERROR: Estacionamiento no encontrado");
		 }
	}

	public void cobrarEstacionamientoApp(double duracionEnHoras , int celular) {
			Double saldoActual = creditosDisponibles.get(celular);
			if (saldoActual != null) {
				double nuevoSaldo = saldoActual - (duracionEnHoras / this.getPrecioPorHora());
				creditosDisponibles.put(celular, nuevoSaldo);
			} else {
				System.out.println("ERROR: Celular no registrado");
			}
	}
	

}
