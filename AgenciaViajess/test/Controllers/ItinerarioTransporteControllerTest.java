/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.ItinerarioTransporte;
import Modelos.Reserva;
import Modelos.Trayecto;
import Modelos.Viaje;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class ItinerarioTransporteControllerTest {
    
    public ItinerarioTransporteControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMetodoI() {
        System.out.println("MetodoI");
        Integer viajeId = 1;
        ItinerarioTransporteController instance = new ItinerarioTransporteController();
        Double expResult = 3000.0;
        Double result = instance.MetodoI(viajeId);
        assertEquals(expResult, result);
    }

    
}
