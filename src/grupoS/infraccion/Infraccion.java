package grupoS.infraccion;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.inspector.Inspector;
import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

public class Infraccion {
	
	private LocalDate fecha;
	private LocalTime hora;
	private Inspector inspector;
	private ZonaDeEstacionamientoMedido zona;
	
	
	public Infraccion(LocalDate fecha, LocalTime hora, Inspector inspector, ZonaDeEstacionamientoMedido zona) {
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public ZonaDeEstacionamientoMedido getZona() {
		return zona;
	}
}
