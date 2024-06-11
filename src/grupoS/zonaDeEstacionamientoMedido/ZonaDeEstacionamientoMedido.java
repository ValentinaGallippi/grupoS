package grupoS.zonaDeEstacionamientoMedido;

import java.util.*;

import grupoS.inspector.Inspector;
import grupoS.puntoDeVenta.PuntoDeVenta;

public class ZonaDeEstacionamientoMedido {
	
	private Inspector inspector;
	private List<PuntoDeVenta> puntosDeVenta;

	public ZonaDeEstacionamientoMedido(Inspector inspector) {
		this.inspector = inspector;
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
	}
	
	public Inspector getInspector() {
		return this.inspector;
	}
	
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	
	public void addPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.add(puntoDeVenta);
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		
		return this.puntosDeVenta;
	}

}
