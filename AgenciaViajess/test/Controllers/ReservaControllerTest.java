/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Habitacion;
import Modelos.Hotel;
import Modelos.ItinerarioTransporte;
import Modelos.Reserva;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class ReservaControllerTest {
    
    public ReservaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMetodoK() {
        System.out.println("metodoK");
        ReservaController instance = new ReservaController();
        Double expResult = 1.0;
        Double result = instance.metodoK();
        assertEquals(expResult, result);
    }
}
