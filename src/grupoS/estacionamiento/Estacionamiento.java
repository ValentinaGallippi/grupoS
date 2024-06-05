package grupoS.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	    private int celular;
	    private String patente;	

	    public Estacionamiento(int celular, String patente) {
	        this.celular= celular;
	        this.patente = patente;
	    }

	    public int getCelular() {
			return celular;
		}

		public void setCelular(int celular) {
			this.celular = celular;
		}

		public String getPatente() {
			return patente;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public abstract boolean estaVigente();
	}

