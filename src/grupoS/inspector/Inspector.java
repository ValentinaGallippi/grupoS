package grupoS.inspector;

import grupoS.zonaDeEstacionamientoMedido.ZonaDeEstacionamientoMedido;

public class Inspector {
	 private int legajo;
	 private ZonaDeEstacionamientoMedido zona;
	public Inspector(int legajo, ZonaDeEstacionamientoMedido zona) {
		super();
		this.legajo = legajo;
		this.zona = zona;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public ZonaDeEstacionamientoMedido getZonaDeEstacionamientoMedido() {
		return zona;
	}
	public void setZona(ZonaDeEstacionamientoMedido zona) {
		this.zona = zona;
	}
	 
	 
	 
}
