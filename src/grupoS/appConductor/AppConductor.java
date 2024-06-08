package grupoS.appConductor;

import java.time.LocalTime;


import grupoS.MovementSensor.MovementSensor;
import grupoS.SEM.SEM;
import grupoS.asistencia.Asistencia;
import grupoS.asistencia.AsistenciaDesactivada;
import grupoS.estacionamiento.Estacionamiento;
import grupoS.estado.Driving;
import grupoS.estado.Estado;
import grupoS.estado.Walking;
import grupoS.modoDeAppConductor.ModoDeAppConductor;
import grupoS.modoDeAppConductor.ModoManual;


public class AppConductor implements MovementSensor {
	
	private SEM sem;
    private int celular;
    private ModoDeAppConductor modoDeApp;    
    private Asistencia modoDeAsistencia;
    private Estado     estado;
    private String patente;
    
    public AppConductor(int celular, SEM sem) {
    	this.celular = celular;
    	this.sem = sem;
    	this.modoDeApp = new ModoManual(); // por default una aplicacion se inicia en modo manual
    	this.modoDeAsistencia = new AsistenciaDesactivada(); // y con la asistencia desactivada
    }

 // usamos el strategy
    public void iniciarEstacionamiento(String patente) {
    	this.patente = patente;
    	this.modoDeApp.iniciarEstacionamiento(this, patente);
    }

    public void finalizarEstacionamiento() {
    	this.modoDeApp.finalizarEstacionamiento(this);
    }
    
    public void cambiarModo(ModoDeAppConductor modo) {
    	this.modoDeApp = modo;
    }
    
    public double consultarSaldo() {
    	return this.sem.saldoDe(this.celular);
    }
    
    public void registrarEstacionamiento(Estacionamiento estacionamiento) {
    	this.sem.registrarEstacionamiento(estacionamiento);
    }

   

	public SEM getSem() {
		return sem;
	}

	public void setSem(SEM sem) {
		this.sem = sem;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public ModoDeAppConductor getModoDeApp() {
		return modoDeApp;
	}

	public void setModoDeApp(ModoDeAppConductor modoDeApp) {
		this.modoDeApp = modoDeApp;
	}

	public LocalTime calcularHoraMaxima() {
		double cantidadDeHorasRestantes = this.consultarSaldo()/ 40;
		LocalTime ahora = LocalTime.now();
		if (ahora.plusHours((long) cantidadDeHorasRestantes).isAfter(LocalTime.of(20, 0))){
			return LocalTime.of(20, 00);
		} else {
			return ahora.plusHours((long) cantidadDeHorasRestantes);
		}
	}

	public Estacionamiento buscarEstacionamientoApp() throws Exception {
		return this.sem.buscarEstacionamientoApp(this.celular);
	}

	public void cobrarPorHoras(double duracionEnHoras) throws Exception {
		this.sem.cobrarEstacionamientoApp(duracionEnHoras, this.celular);
		
	}

	public double precioPorHora() {
		return this.sem.getPrecioPorHora();
	}

	public void finalizarEnElSem(Estacionamiento estacionamiento) {
		this.sem.terminarEstacionamiento(estacionamiento);
	}
	
	
	@Override
	public void walking() throws Exception {
		this.estado.caminando(this);
	}
	
	@Override
	public void driving() throws Exception {
		this.estado.manejando(this);
	}
	
	
	public void cambiarAsistencia(Asistencia asistencia) throws Exception {
		this.modoDeApp.cambiarAsistencia(asistencia, this);
	}

	public void setAsistencia(Asistencia asistencia) {
		this.modoDeAsistencia = asistencia;
		
	}
	
	public void cambiarModoDeApp(ModoDeAppConductor modo) throws Exception {
		this.modoDeAsistencia.cambiarModoDeApp(modo,this);
	}

	public Asistencia getModoAsistencia() {
		return this.modoDeAsistencia;
	}

	public void cambiarModoACaminando() {
		this.estado = new Walking();
		
	}

	public boolean tieneEstacionamientoVigenteEnMismoPuntoGeografico() throws Exception {
		Estacionamiento estacionamiento = this.sem.buscarEstacionamientoApp(celular);
		return this.sem.elPuntoEstaIncluidoEnZonas(this.ubicacionActual()) && estacionamiento.estaVigente();
	}

	private Object ubicacionActual() {
		// no implementamos la generación del punto, solo lo utilizamos en los test de mock.
		return null;
	}

	public void cambiarModoAManejando() {
		this.estado = new Driving();
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
}
