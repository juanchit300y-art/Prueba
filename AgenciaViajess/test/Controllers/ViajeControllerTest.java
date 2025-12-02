/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Cuota;
import Modelos.Entretenimiento;
import Modelos.Factura;
import Modelos.ItinerarioTransporte;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class ViajeControllerTest {
    
    public ViajeControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMetodoA() {
        System.out.println("metodoA");
        ViajeController instance = new ViajeController();
        Double expResult = 2.0;
        Double result = instance.metodoA();
        assertEquals(expResult, result);
    }

    @Test
    public void testMetodoC() {
        System.out.println("metodoC");
        String nombreActividad = "";
        ViajeController instance = new ViajeController();
        int expResult = 0;
        int result = instance.metodoC(nombreActividad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
