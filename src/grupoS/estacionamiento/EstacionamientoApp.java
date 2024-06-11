package grupoS.estacionamiento;

import java.time.LocalTime;


public class EstacionamientoApp extends Estacionamiento{

    
    private int celular;

    public EstacionamientoApp(int celular, String patente, LocalTime horaDeInicio, LocalTime horaDeFin) {
        super(horaDeInicio,horaDeFin,patente);
        this.celular = celular;
    }

    @Override
	public int getCelular() {
		return celular;
	}

	
	public boolean esDeApp() {
		return true;
	}
  
	
}