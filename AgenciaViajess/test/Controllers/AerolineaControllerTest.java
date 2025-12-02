/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Aeronave;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class AerolineaControllerTest {
    
    public AerolineaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMetodoB() {
        System.out.println("MetodoB");
        Integer aerolineaId = 1;
        AerolineaController instance = new AerolineaController();
        Double expResult = 1000.0;
        Double result = instance.MetodoB(aerolineaId);
        assertEquals(expResult, result);
    }
    
}
