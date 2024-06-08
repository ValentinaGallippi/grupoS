package grupoS.SEM;

import grupoS.compra.Compra;
import grupoS.entidad.Entidad;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estacionamiento.EstacionamientoApp;
import grupoS.infraccion.Infraccion;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

import java.time.*;
import java.util.*;
import java.util.stream.Stream;

public class SEM {

    private LocalTime horaDeInicio;
    private LocalTime horaDeCierre;
    private double precioPorHora;
    private List<ZonaDeEstacionamientoMedido> zonas     = new ArrayList<>();
    private List<Compra> compras                        = new ArrayList<>();
    private List<Estacionamiento> estacionamientos      = new ArrayList<>();
    private List<Infraccion> infracciones               = new ArrayList<>();
    private List<Entidad> entidadesObservadoras         = new ArrayList<>();
    private HashMap<Integer, Double> creditosDisponibles = new HashMap<>();
    private int ticketsEmitidos 						= 0;
	

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
        this.entidadesObservadoras.add(entidad);
    }

    public void desuscribirEntidad(Entidad entidad) {
        this.entidadesObservadoras.remove(entidad);
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
    
	public Estacionamiento buscarEstacionamientoApp(int celular) throws Exception {
		 Stream<Estacionamiento> estacionamientoStream = estacionamientos.stream()
				 									  .filter(estacionamiento -> estacionamiento.esDeApp());
		Optional<Estacionamiento> estacionamiento1 	= estacionamientoStream
													.filter(estacionamiento -> estacionamiento.getCelular() == celular)
													.findFirst();
		 if(estacionamiento1.isPresent()) {
			 return estacionamiento1.get();
		 } else {
			 throw new Exception("ERROR: Estacionamiento no encontrado para el celular " + celular);
		 }
	}

	public void cobrarEstacionamientoApp(double duracionEnHoras , int celular) throws Exception {
			Double saldoActual = creditosDisponibles.get(celular);
			if (saldoActual != null) {
				double nuevoSaldo = saldoActual - (duracionEnHoras / this.getPrecioPorHora());
				creditosDisponibles.put(celular, nuevoSaldo);
			} else {
				throw new Exception("ERROR: Celular no encontrado para el numero " + celular);
			}
	}

	public boolean elPuntoEstaIncluidoEnZonas(Object ubicacionActual) {
		// no se implementa el testeo geométrico de inclusión.;
		return false;
	}
	
	public int getTicketsEmitidos() {
		
		return this.ticketsEmitidos;
		
	}

	public void actualizarTicketsEmitidos() {
		
		this.ticketsEmitidos += 1;
		
	}
	public void notificarEntidades() {
		
		this.entidadesObservadoras.stream().forEach( e -> e.update());
		}

	public boolean estaVigente(String patente) {
		Optional<Estacionamiento> estacionamiento1 	= estacionamientos.stream().sorted(Collections.reverseOrder())
				.filter(estacionamiento -> estacionamiento.getPatente() == patente).findFirst();
				if (estacionamiento1.isPresent()) {
					return estacionamiento1.get().estaVigente();
				} else { return false;
				
				}
	}

	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}

	public LocalTime getHoraDeCierre() {
		return horaDeCierre;
	}

	public void setHoraDeCierre(LocalTime horaDeCierre) {
		this.horaDeCierre = horaDeCierre;
	}

	public List<ZonaDeEstacionamientoMedido> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaDeEstacionamientoMedido> zonas) {
		this.zonas = zonas;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public void setEstacionamientos(List<Estacionamiento> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}

	public List<Entidad> getEntidadesObservadoras() {
		return entidadesObservadoras;
	}

	public void setEntidadesObservadoras(List<Entidad> entidadesObservadoras) {
		this.entidadesObservadoras = entidadesObservadoras;
	}

	public HashMap<Integer, Double> getCreditosDisponibles() {
		return creditosDisponibles;
	}

	public void setCreditosDisponibles(HashMap<Integer, Double> creditosDisponibles) {
		this.creditosDisponibles = creditosDisponibles;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public void setTicketsEmitidos(int ticketsEmitidos) {
		this.ticketsEmitidos = ticketsEmitidos;
	}
	
	
}

