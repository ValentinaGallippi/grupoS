package grupoS.estacionamiento;

import java.time.LocalTime;


public class EstacionamientoApp extends Estacionamiento{

    
    private int celular;

    public EstacionamientoApp(int celular, String patente, LocalTime horaDeInicio, LocalTime horaDeFin) {
        super(horaDeInicio,horaDeFin,patente);
        this.celular = celular;
    }

	public int getCelular() {
		return celular;
	}

	@Override
	public boolean esDeApp() {
		return true;
	}
  
	
}