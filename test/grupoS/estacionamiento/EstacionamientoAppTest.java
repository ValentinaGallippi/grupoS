package grupoS.estacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstacionamientoAppTest {

    private EstacionamientoApp estacionamientoApp;



    @BeforeEach
	void setUp()  throws Exception {

    	estacionamientoApp = new EstacionamientoApp(1135430743,"TAY 013", LocalTime.of(14,30), LocalTime.of(16,40)); 

    }

    @Test 
    void cuandoSeCreaUnEstacionamiento_SuCelularSera1135430743() {

    	assertEquals(estacionamientoApp.getCelular(), 1135430743);
    }
    
    @Test
    void cuandoSeLePreguntaAUnEstacionamientoSiEsDeApp_RetornaTrue() {

    	assertTrue(estacionamientoApp.esDeApp());

    }
    
    @Test
    void cuandoSeLeModificaLaHoraDeFinAUnEstacionamientoApp_LaNuevaHoraDeFinSera() {
    	estacionamientoApp.setHoraDeFin(LocalTime.of(15,40));
    	
    	assertEquals(estacionamientoApp.getHoraDeFin(), LocalTime.of(15,40));
    }



} 
