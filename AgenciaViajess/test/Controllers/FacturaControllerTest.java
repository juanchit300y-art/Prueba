/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelos.Cliente;
import Modelos.Factura;
import Modelos.Plan;
import Modelos.Viaje;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Guerrero
 */
public class FacturaControllerTest {
    
    public FacturaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }


    @Test
    public void testMetodoD() {
        System.out.println("metodoD");
        Integer idCliente = 1;
        FacturaController instance = new FacturaController();
        Double expResult = 2000.0;
        Double result = instance.metodoD(idCliente);
        assertEquals(expResult, result);
    }

    @Test
    public void testMetodoH() {
        System.out.println("metodoH");
        Integer idAerolinea = 1;
        Integer idMunicipio = 1;
        FacturaController instance = new FacturaController();
        int expResult = 1;
        int result = instance.metodoH(idAerolinea, idMunicipio);
        assertEquals(expResult, result);
    }

    @Test
    public void testMetodoF() {
        System.out.println("metodoF");
        FacturaController instance = new FacturaController();
        Double expResult = 1.5;
        Double result = instance.metodoF();
        assertEquals(expResult, result);
    }
    
}
