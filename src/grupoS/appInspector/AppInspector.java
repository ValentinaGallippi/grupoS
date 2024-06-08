package grupoS.appInspector;

import java.time.LocalDate;
import java.time.LocalTime;

import grupoS.SEM.SEM;
import grupoS.infraccion.Infraccion;
import grupoS.inspector.Inspector;

public class AppInspector {

    private SEM sem;
    private Inspector inspector;
    


    public AppInspector(SEM sem, Inspector inspector) {
		super();
		this.sem = sem;
		this.inspector = inspector;
	}

	public boolean consultarVigenciaDeEstacionamiento(String patente) throws Exception {
        return this.sem.estaVigente(patente);
    }

    public void realizarInfraccion(String patente) throws Exception {
        if (this.sem.estaVigente(patente)) {
        	Infraccion infraccion = new Infraccion(LocalDate.now(), LocalTime.now(), this.inspector , this.inspector.getZonaDeEstacionamientoMedido());
        	this.sem.registrarInfraccion(infraccion);
        }
    }

}