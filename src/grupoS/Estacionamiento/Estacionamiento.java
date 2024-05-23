package grupoS.Estacionamiento;

import grupoS.usuario.Usuario;

public class Estacionamiento {
	 	private Boolean estaVigente = true;
	    private Usuario usuario;

	    public Estacionamiento( Usuario usuario) {
	        this.usuario = usuario;
	    }

	    public String getPatente() {
	        return this.usuario.getPatente();
	    }

	    public boolean estaVigente() {
	        return this.estaVigente;
	    }

	}

