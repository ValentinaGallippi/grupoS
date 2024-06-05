package grupoS.estacionamiento;

import java.time.LocalTime;


public class EstacionamientoApp extends Estacionamiento{

    private LocalTime horaDeInicio;
    private boolean estaVigente;

    public EstacionamientoApp(int celular, String patente, LocalTime horaDeInicio) {
        super(celular,patente);
        this.horaDeInicio = horaDeInicio;
        this.estaVigente = true;
    }
    
    @Override
    public LocalTime horaDeInicio() {
    	return this.horaDeInicio;
    }

	@Override
	public boolean estaVigente(Estacionamiento unEstacionamiento) {
	
		return this.estaVigente;
	}
	public void estacionamientoFinalizado(boolean unBooleano) {
		
		this.estaVigente = unBooleano;
	}
    
	
}