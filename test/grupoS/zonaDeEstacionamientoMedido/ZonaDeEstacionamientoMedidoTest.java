package grupoS.zonaDeEstacionamientoMedido;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;


import grupoS.inspector.Inspector;
import grupoS.puntoDeVenta.PuntoDeVenta;

class ZonaDeEstacionamientoMedidoTest {

    private ZonaDeEstacionamientoMedido zona;
    private Inspector inspector;
    private PuntoDeVenta puntoDeVenta;

    @BeforeEach
    void setUp() throws Exception {
        this.inspector = mock(Inspector.class);
        this.puntoDeVenta = mock(PuntoDeVenta.class);
        this.zona = new ZonaDeEstacionamientoMedido(inspector);
    }

    @Test
    void cuandoUnaZonaEsCreada_NoTendraNingunPuntoDeVenta() {
        assertTrue(this.zona.getPuntosDeVenta().isEmpty());
    }

    @Test
    void cuandoUnaZonaEsCreada_SeLeAsignaUnInspectorACargo() {
        assertTrue(this.zona.getInspector().equals(inspector));
    }

    @Test
    void cuandoAUnaZona_SeLeAgregaUnPuntoDeVenta_EsePuntoDeVentaFormaraParteDeLosPuntosDeVentaDeLaZona() {
        this.zona.addPuntoDeVenta(puntoDeVenta);

        assertTrue(this.zona.getPuntosDeVenta().contains(puntoDeVenta));
    }

    @Test
    void cuandoAUnaZona_SeLeCambiaElInspector_ElNuevoInspectorPasaAReemplazarElAnterior() {
        this.zona.setInspector(inspector);

        assertTrue(this.zona.getInspector().equals(inspector));
    }
}