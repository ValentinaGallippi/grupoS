package grupoS.appConductor;

import java.time.LocalTime;

import grupoS.SEM.SEM;
import grupoS.usuario.Usuario;

public class AppConductor {
	
	private SEM sem;
    private Usuario usuario;
    
    public AppConductor(Usuario usuario) {
    }

/* 
    public void iniciarEstacionamiento() {
        double saldoDeUsuario = this.sem.saldoDe(this.usuario.getCelular());
        if(saldoDeUsuario >= 0) {
            System.out.println("La hora de inicio es: " + LocalTime.now() + "La hora mÃ¡xima es:" + this.calcularHoraMaxima(saldoDeUsuario,LocalTime.now())); //hacer salto
        EstacionamientoApp estacionamiento = new EstacionamientoApp(this.usuario, LocalTime.now());
        this.sem.registrarEstacionamiento(estacionamiento);
        } else {
            System.out.println("no tenes saldo chabon");
        }
    }
*/

    public void iniciarEstacionamiento() {
        if(elUsuarioTieneSaldoPositivo()) {
            indicarHoraDeComienzoYHoraMaxima();
            registrarEstacionamientoEnElSistema();
        } else {
            indicarSaldoInsuficiente();
        }
    }

    private LocalTime calcularHoraMaxima(double saldoDeUsuario, LocalTime horaDeInicio) {
     //calcular ;
     return ;
    }

    public void finalizarEstacionamiento() {
        EstacionamientoApp estacionamiento = new EstacionamientoApp(this.usuario, LocalTime.now());
        this.sem.terminarEstacionamiento(estacionamiento);
    }

    public double consultarSaldo() {
        return this.sem.saldoDe(this.usuario.getCelular());
    }

    public boolean elUsuarioTieneSaldoPositivo() {
        return (consultarSaldo()>=0);
    }

    private void indicarHoraDeComienzoYHoraMaxima() {
        ;
    }
    
    private void registrarEstacionamientoEnElSistema() {
        ;
    }

    private void indicarSaldoInsuficiente() {
        ;
    }

}

