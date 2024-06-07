package grupoS.estacionamiento;

import java.time.LocalTime;


public class EstacionamientoApp extends Estacionamiento{

    
    private boolean estaVigente;

    public EstacionamientoApp(int celular, String patente, LocalTime horaDeInicio) {
        super(celular,patente, horaDeInicio);
    }


	@Override
	public boolean estaVigente() {
	
		return this.estaVigente();
	}
	
	public void estacionamientoFinalizado() {
		this.estaVigente = false;
	}
    
	
}