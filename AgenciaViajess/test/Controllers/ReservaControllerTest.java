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
import java.util.ArrayList;
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
    @Test
    public void testMetodoE() {
        System.out.println("metodoE");
        ReservaController instance = new ReservaController();
        HotelController instance2 = new HotelController();
        List<Hotel> expected = new ArrayList<>();
        expected.add(instance2.getGeneralById(1)); //sé que el plan 1 tiene "baile"
        expected.add(instance2.getGeneralById(2));
        
        List<Hotel> result = instance.metodoE();

        assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getId(), result.get(i).getId());
        }
    }
    
}
