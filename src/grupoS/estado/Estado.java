package grupoS.estado;

import grupoS.appConductor.AppConductor;

public interface Estado {

	void manejando(AppConductor appConductor);

	void caminando(AppConductor appConductor);

}
