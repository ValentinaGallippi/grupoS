package grupoS.SEM;

import grupoS.compra.Compra;
import grupoS.entidad.Entidad;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.infraccion.Infraccion;
import grupoS.inspector.Inspector;
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
    
    // GETTERS
    
    public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}
    
    public LocalTime getHoraDeCierre() {
		return horaDeCierre;
	}
    
    public double getPrecioPorHora() {
        return this.precioPorHora;
    }
    
    public int getTicketsEmitidos() {
		return this.ticketsEmitidos;
	}
    
    public List<ZonaDeEstacionamientoMedido> getZonas() {
		return zonas;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}
	
	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public List<Entidad> getEntidadesObservadoras() {
		return entidadesObservadoras;
	}
	
	public HashMap<Integer, Double> getCreditosDisponibles() {
		return creditosDisponibles;
	}
    
    // SETTERS
    
    public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
    }

	public void setHoraDeCierre(LocalTime horaDeCierre) {
		this.horaDeCierre = horaDeCierre;
	}
    
	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
    // REGISTROS
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
    
    public void suscribirEntidad(Entidad entidad) {
        this.entidadesObservadoras.add(entidad);
    }
    
    // DESRREGISTROS
    
    public void desuscribirEntidad(Entidad entidad) {
        this.entidadesObservadoras.remove(entidad);
    }
    
    // CONSULTAS AL SEM

    public double saldoDe(int celular) {
        return this.creditosDisponibles.get(celular);
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
	
	public boolean elPuntoEstaIncluidoEnZonas(Object ubicacionActual) {
		// no se implementa el testeo geométrico de inclusión.;
		return false;
	}
	
	public boolean estaVigente(String patente) {
		Optional<Estacionamiento> estacionamiento1 	= estacionamientos.stream().sorted(Collections.reverseOrder())
				.filter(estacionamiento -> estacionamiento.getPatente() == patente).findFirst();
				if (estacionamiento1.isPresent()) {
					return estacionamiento1.get().estaVigente();
				} else { return false;
				
				}
	}
	
	// ACCIONES DE SEM

	public void cobrarEstacionamientoApp(double duracionEnHoras , int celular) throws Exception {
		Double saldoActual = creditosDisponibles.get(celular);
		if (saldoActual != null) {
			double nuevoSaldo = saldoActual - (duracionEnHoras / this.getPrecioPorHora());
			creditosDisponibles.put(celular, nuevoSaldo);
		} else {
			throw new Exception("ERROR: Celular no encontrado para el numero " + celular);
		}
	}

	public void actualizarTicketsEmitidos() {
		this.ticketsEmitidos ++;
	}
	
	public void notificarEntidades() {
		this.entidadesObservadoras.stream().forEach( e -> e.update());
	}
	
	public ZonaDeEstacionamientoMedido getZonaDeInspector(Inspector inspector) {
		Optional<ZonaDeEstacionamientoMedido> zona = this.getZonas().stream().filter(z -> z.getInspector() == inspector).findFirst();
		return zona.orElse(null);
	}
}

