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
		this.sem = sem;
		this.inspector = inspector;
	}

	public boolean consultarVigenciaDeEstacionamiento(String patente){
        return this.sem.estaVigente(patente);
    }

    public void realizarInfraccion(String patente) {
        if (this.sem.estaVigente(patente)) {
        	Infraccion infraccion = new Infraccion(LocalDate.now(), LocalTime.now(), this.inspector , this.sem.getZonaDeInspector(inspector));
        	this.sem.registrarInfraccion(infraccion);
        }
    }
    
    
}