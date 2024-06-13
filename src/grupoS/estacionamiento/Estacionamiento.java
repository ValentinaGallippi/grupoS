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

		public  boolean estaVigente() {
			return this.horaDeFin.isAfter(LocalTime.now());
		}
		
		public LocalTime getHoraDeInicio() {
			return horaDeInicio;
		}

		public LocalTime getHoraDeFin() {
			return horaDeFin;
		}


		public void setHoraDeFin(LocalTime horaDeFin) {
			this.horaDeFin = horaDeFin;
		}


		public abstract boolean esDeApp();


		public abstract int getCelular();

}
