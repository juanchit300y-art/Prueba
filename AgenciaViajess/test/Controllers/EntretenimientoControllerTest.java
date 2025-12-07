/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Entretenimiento;
import Modelos.Plan;
import Modelos.Viaje;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class EntretenimientoControllerTest {
    
    public EntretenimientoControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testMetodoG() {
        System.out.println("metodoG");
        EntretenimientoController instance = new EntretenimientoController();
        int expResult = 4;
        int result = instance.metodoG();
        assertEquals(expResult, result);
    }
    
}
