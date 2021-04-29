package edu.upc.dsa;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Usuario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Covid19ManagerImplTest {
    Covid19Manager escenario;

    @Before
    public void setUp() {
        escenario = Covid19ManagerImpl.getInstance();
        escenario.anadirUsuario("1234", "Arnau");
        escenario.anadirUsuario("5678", "Juan");
        escenario.anadirUsuario("9876", "Pedro");

        escenario.anadirMarca("Pfizer");
        escenario.anadirMarca("AstraZeneca");
        escenario.anadirMarca("Moderna");
        escenario.anadirMarca("Janssen");

    }

    @After
    public void tearDown() {
        escenario.clearInstance();
    }

    @Test
    public void testRealizarPedido() {

        escenario.aplicarVacuna("1234", "Pfizer", new Date());
        escenario.aplicarVacuna("5678", "Moderna", new Date());


    }

    @Test
    public void testServirPedido() {

        escenario.anadirSeguimiento("1234", "Bien", new Date());
        escenario.anadirSeguimiento("1234", "Mejor", new Date());

        Assert.assertEquals("Mejor", escenario.getSeguimientos("1234").get(1).getDescripcion());

    }
}
