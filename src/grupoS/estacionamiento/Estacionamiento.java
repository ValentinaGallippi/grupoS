package grupoS.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	    private String patente;	
	    private LocalTime horaDeInicio;
	    private LocalTime horaDeFin; // en el caso de estacionamiento por app es la hora maxima de alcance por saldo o las 20hs. 

	    public Estacionamiento(LocalTime horaDeInicio, LocalTime horaDeFin, String patente) {
	    	this.patente = patente;
	        this.horaDeInicio = horaDeInicio;
	        this.horaDeFin = horaDeFin;
	        
	    }


		public String getPatente() {
			return patente;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public  boolean estaVigente() {
			return this.horaDeFin.isBefore(LocalTime.now());
		}

		public LocalTime horaDeInicio() {
		
			return this.horaDeInicio;
	}


		public abstract boolean esDeApp();


		public abstract int getCelular();

}
