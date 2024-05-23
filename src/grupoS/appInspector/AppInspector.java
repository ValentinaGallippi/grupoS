package grupoS.appInspector;

import grupoS.SEM.SEM;

public class AppInspector {

    private SEM sem;

    public AppInspector(SEM sem) {
        this.sem = sem;
    }

    public boolean consultarVigenciaDeEstacionamiento(String patente) {
        return this.sem.estaVigente(patente);
    }

    public void realizarInfraccion(String patente) {
        if (this.consultarVigenciaDeEstacionamiento(patente) == false) {
            this.sem.realizarInfraccion(patente);
        }
    }

}