package grupoS.estacionamiento;

public class EstacionamientoPuntual extends Estacionamiento{
    
    private int cantidadDeHoras;

    public EstacionamientoPuntual(int celular, String patente, int cantidadDeHoras) {
        super(celular, patente);
        this.cantidadDeHoras = cantidadDeHoras;
    }
    
    @Override
    public boolean estaVigente() {
    	return 
    }
}